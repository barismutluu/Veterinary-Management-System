package com.example.Veteriner.Sistemi.api;

import com.example.Veteriner.Sistemi.bussines.abstracts.IDoctorService;
import com.example.Veteriner.Sistemi.core.config.modelMapper.IModelMapperService;
import com.example.Veteriner.Sistemi.core.result.Result;
import com.example.Veteriner.Sistemi.core.result.ResultData;
import com.example.Veteriner.Sistemi.core.utilies.ResultHelper;
import com.example.Veteriner.Sistemi.dto.request.doctor.DoctorSaveRequest;
import com.example.Veteriner.Sistemi.dto.request.doctor.DoctorUpdateRequest;
import com.example.Veteriner.Sistemi.dto.response.CursorResponse;
import com.example.Veteriner.Sistemi.dto.response.doctor.DoctorResponse;
import com.example.Veteriner.Sistemi.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// DoctorController sınıfı, doktor ile ilgili istekleri yönetir.
@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {
    private final IDoctorService doctorService;
    private final IModelMapperService modelMapper;

    public DoctorController(IDoctorService doctorService, IModelMapperService modelMapper) {
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    // Yeni bir doktor kaydeder.
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> save(@Valid @RequestBody DoctorSaveRequest doctorSaveRequest) {
        Doctor saveDoctor = this.modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);
        this.doctorService.save(saveDoctor);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveDoctor, DoctorResponse.class));
    }

    // Belirtilen kimliğe sahip bir doktoru döner.
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> get(@PathVariable("id") int id) {
        Doctor doctor = this.doctorService.get(id);
        DoctorResponse doctorResponse = this.modelMapper.forResponse().map(doctor, DoctorResponse.class);
        return ResultHelper.success(doctorResponse);
    }

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre doktorları döner.
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<DoctorResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize

    ) {
        Page<Doctor> doctorPage = this.doctorService.cursor(page, pageSize);
        Page<DoctorResponse> doctorResponsePage = doctorPage
                .map(doctor -> this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
        return ResultHelper.cursor(doctorResponsePage);
    }

    // Var olan bir doktoru günceller.
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest) {
        Doctor updateDoctor=this.modelMapper.forResponse().map(doctorUpdateRequest, Doctor.class);
        this.doctorService.update(updateDoctor);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateDoctor, DoctorResponse.class));
    }

    // Belirtilen kimliğe sahip bir doktoru siler.
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.doctorService.delete(id);
        return ResultHelper.ok();
    }
}
