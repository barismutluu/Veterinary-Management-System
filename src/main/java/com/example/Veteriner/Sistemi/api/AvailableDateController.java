package com.example.Veteriner.Sistemi.api;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAvailableDateService;
import com.example.Veteriner.Sistemi.bussines.abstracts.IDoctorService;
import com.example.Veteriner.Sistemi.core.config.modelMapper.IModelMapperService;
import com.example.Veteriner.Sistemi.core.result.Result;
import com.example.Veteriner.Sistemi.core.result.ResultData;
import com.example.Veteriner.Sistemi.core.utilies.ResultHelper;
import com.example.Veteriner.Sistemi.dto.request.availabledate.AvailableDateSaveRequest;
import com.example.Veteriner.Sistemi.dto.request.availabledate.AvailableDateUpdateRequest;
import com.example.Veteriner.Sistemi.dto.response.CursorResponse;
import com.example.Veteriner.Sistemi.dto.response.availabledate.AvailableDateResponse;
import com.example.Veteriner.Sistemi.entities.AvailableDate;
import com.example.Veteriner.Sistemi.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// AvailableDateController sınıfı, kullanılabilir tarihlerle ilgili istekleri yönetir.
@RestController
@RequestMapping("/v1/availabledate")
public class AvailableDateController {
    private final IAvailableDateService availableDateService;
    private final IDoctorService doctorService;
    private final IModelMapperService modelMapper;

    public AvailableDateController(IAvailableDateService availableDateService, IDoctorService doctorService, IModelMapperService modelMapper) {
        this.availableDateService = availableDateService;
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    // Yeni bir kullanılabilir tarih kaydeder.
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate saveAvailableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);

        Doctor doctor = this.doctorService.get(availableDateSaveRequest.getDoctorId());
        saveAvailableDate.setDoctor(doctor);

        this.availableDateService.save(saveAvailableDate);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveAvailableDate, AvailableDateResponse.class));
    }

    // Belirtilen kimliğe sahip bir kullanılabilir tarihi döner.
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> get(@PathVariable("id") int id) {
        AvailableDate availableDate = this.availableDateService.get(id);
        AvailableDateResponse availableDateResponse = this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class);
        return ResultHelper.success(availableDateResponse);
    }

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre kullanılabilir tarihleri döner.
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AvailableDateResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize

    ) {
        Page<AvailableDate> availableDatePage = this.availableDateService.cursor(page, pageSize);
        Page<AvailableDateResponse> availableDateResponsePage = availableDatePage
                .map(availableDate -> this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
        return ResultHelper.cursor(availableDateResponsePage);
    }

    // Var olan bir kullanılabilir tarihi günceller.
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest) {
        AvailableDate updateAvailableDate = this.modelMapper.forResponse().map(availableDateUpdateRequest, AvailableDate.class);
        this.availableDateService.update(updateAvailableDate);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateAvailableDate, AvailableDateResponse.class));
    }

    // Belirtilen kimliğe sahip bir kullanılabilir tarihi siler.
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id) {
        this.availableDateService.delete(id);
        return ResultHelper.ok();
    }
}
