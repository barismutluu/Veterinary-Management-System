package com.example.Veteriner.Sistemi.api;

import com.example.Veteriner.Sistemi.bussines.abstracts.IVaccineService;
import com.example.Veteriner.Sistemi.core.config.modelMapper.IModelMapperService;
import com.example.Veteriner.Sistemi.core.result.Result;
import com.example.Veteriner.Sistemi.core.result.ResultData;
import com.example.Veteriner.Sistemi.core.utilies.ResultHelper;
import com.example.Veteriner.Sistemi.dto.request.vaccine.VaccineSaveRequest;
import com.example.Veteriner.Sistemi.dto.request.vaccine.VaccineUpdateRequest;
import com.example.Veteriner.Sistemi.dto.response.CursorResponse;
import com.example.Veteriner.Sistemi.dto.response.vaccine.VaccineResponse;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Vaccine;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/vaccine")
public class VaccineController {
    private final IVaccineService vaccineService;
    private final IModelMapperService modelMapper;

    public VaccineController(IVaccineService vaccineService, IModelMapperService modelMapper) {
        this.vaccineService = vaccineService;
        this.modelMapper = modelMapper;
    }

    // Yeni aşı kaydı oluşturur
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<?> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        // Yeni aşı bilgisini al
        Vaccine newVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);

        // Animal nesnesini manuel olarak oluştur ve ayarla
        Animal animal = new Animal();
        animal.setId(vaccineSaveRequest.getAnimal());
        newVaccine.setAnimal(animal);

        // Hata kontrolü: Animal ID boş olamaz
        if (newVaccine.getAnimal() == null || newVaccine.getAnimal().getId() == 0) {
//            return ResultHelper.badRequest("Animal ID cannot be null");
            return ResultHelper.errorWithData("Animal ID cannot be null", null, HttpStatus.NOT_FOUND);
        }

        // Hastaya ait aynı tip aşıları kontrol et
        List<Vaccine> existingVaccines = this.vaccineService.getAllVaccinesByAnimalId(newVaccine.getAnimal().getId());
        List<Vaccine> sameTypeVaccines = existingVaccines.stream()
                .filter(v -> v.getName().equals(newVaccine.getName()) && v.getCode().equals(newVaccine.getCode()))
                .collect(Collectors.toList());

        // Aynı tip aşı varsa, aşı koruyuculuk bitiş tarihlerini kontrol et
        for (Vaccine vaccine : sameTypeVaccines) {
            if (vaccine.getProtectionFinishDate().isAfter(newVaccine.getProtectionStartDate())) {
                // Eğer koruyuculuk bitiş tarihi daha gelmemişse hata döndür
//                return ResultHelper.badRequest("Bu tip aşı için henüz koruyuculuk bitmemiştir. Yeni aşı giremezsiniz.");
                return ResultHelper.errorWithData("Bu tip aşı için henüz koruyuculuk bitmemiştir. Yeni aşı giremezsiniz.", null, HttpStatus.NOT_FOUND);
            }
        }

        // Buraya kadar hiçbir hata oluşmamışsa yeni aşıyı kaydet
        this.vaccineService.save(newVaccine);

        // Başarı durumunda yaratılan aşı bilgisini döndür
        VaccineResponse vaccineResponse = this.modelMapper.forResponse().map(newVaccine, VaccineResponse.class);
//        return ResponseEntity.status(HttpStatus.CREATED).body(vaccineResponse);
        return ResultHelper.created(vaccineResponse);

    }

    // Belirtilen ID'ye sahip aşı bilgisini getirir
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> get(@PathVariable("id") int id) {
        Vaccine vaccine = this.vaccineService.get(id);
        VaccineResponse vaccineResponse = this.modelMapper.forResponse().map(vaccine, VaccineResponse.class);
        return ResultHelper.success(vaccineResponse);
    }

    // Belirtilen hayvana ait tüm aşıları getirir
    @GetMapping("/animal/{animalId}/vaccines")
    public ResultData<List<VaccineResponse>> getAllVaccinesByAnimalId(@PathVariable("animalId") long animalId) {
        List<Vaccine> vaccines = this.vaccineService.getAllVaccinesByAnimalId(animalId);
        List<VaccineResponse> vaccineResponses = vaccines.stream()
                .map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                .collect(Collectors.toList());
        if (vaccineResponses.isEmpty()) {
            return ResultHelper.errorWithData("Belirtilen ID ile hayvan bulunamamıştır.", null, HttpStatus.NOT_FOUND);
        }
        return ResultHelper.success(vaccineResponses);
    }

    // Belirtilen tarih aralığında gelecek aşıları getirir
    @GetMapping("/upcoming")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> getUpcomingVaccines(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Vaccine> upcomingVaccines = this.vaccineService.getUpcomingVaccines(startDate, endDate);

        if (upcomingVaccines.isEmpty()) {
            return ResultHelper.errorWithData("Belirtilen tarih aralığında aşı bulunamadı.", null, HttpStatus.NOT_FOUND);
        }
        List<VaccineResponse> vaccineResponses = upcomingVaccines.stream()
                .map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(vaccineResponses);
    }

    // Sayfalama ile tüm aşı bilgilerini getirir
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<VaccineResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize) {
        Page<Vaccine> vaccinePage = this.vaccineService.cursor(page, pageSize);
        Page<VaccineResponse> vaccineResponsePage = vaccinePage
                .map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
        return ResultHelper.cursor(vaccineResponsePage);
    }

    // Belirtilen aşı bilgisini günceller
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> update(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine updateVaccine = this.modelMapper.forResponse().map(vaccineUpdateRequest, Vaccine.class);
        this.vaccineService.update(updateVaccine);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateVaccine, VaccineResponse.class));
    }

    // Belirtilen ID'ye sahip aşının kaydını siler
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id) {
        this.vaccineService.delete(id);
        return ResultHelper.ok();
    }
}
