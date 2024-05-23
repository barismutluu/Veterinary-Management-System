package com.example.Veteriner.Sistemi.api;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAnimalService;
import com.example.Veteriner.Sistemi.bussines.abstracts.IAppointmentService;
import com.example.Veteriner.Sistemi.core.config.modelMapper.IModelMapperService;
import com.example.Veteriner.Sistemi.core.result.Result;
import com.example.Veteriner.Sistemi.core.result.ResultData;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.core.utilies.ResultHelper;
import com.example.Veteriner.Sistemi.dto.request.animal.AnimalSaveRequest;
import com.example.Veteriner.Sistemi.dto.request.animal.AnimalUpdateRequest;
import com.example.Veteriner.Sistemi.dto.request.appointment.AppointmentSaveRequest;
import com.example.Veteriner.Sistemi.dto.request.appointment.AppointmentUpdateRequest;
import com.example.Veteriner.Sistemi.dto.response.CursorResponse;
import com.example.Veteriner.Sistemi.dto.response.animal.AnimalResponse;
import com.example.Veteriner.Sistemi.dto.response.appointment.AppointmentResponse;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Appointment;
import com.example.Veteriner.Sistemi.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {
    private final IAppointmentService appointmentService;
    private final IModelMapperService modelMapper;

    public AppointmentController(IAppointmentService appointmentService, IModelMapperService modelMapper) {
        this.appointmentService = appointmentService;
        this.modelMapper = modelMapper;
    }


//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
//        Appointment saveAppointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);
//        this.appointmentService.save(saveAppointment);
//        return ResultHelper.created(this.modelMapper.forResponse().map(saveAppointment, AppointmentResponse.class));
//    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentSaveRequest.getAppointmentDateTime());

        Doctor doctor = new Doctor();
        doctor.setId(appointmentSaveRequest.getDoctorId());
        appointment.setDoctor(doctor);

        Animal animal = new Animal();
        animal.setId(appointmentSaveRequest.getAnimalId());
        appointment.setAnimal(animal);

        appointment = appointmentService.save(appointment);
        AppointmentResponse appointmentResponse = modelMapper.forResponse().map(appointment, AppointmentResponse.class);
        return ResultHelper.created(appointmentResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> get(@PathVariable("id") int id) {
        Appointment appointment = this.appointmentService.get(id);
        AppointmentResponse appointmentResponse = this.modelMapper.forResponse().map(appointment, AppointmentResponse.class);
        return ResultHelper.success(appointmentResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AppointmentResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize

    ) {
        Page<Appointment> appointmentPage = this.appointmentService.cursor(page, pageSize);
        Page<AppointmentResponse> appointmentResponsePage = appointmentPage
                .map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
        return ResultHelper.cursor(appointmentResponsePage);
    }

    @GetMapping("/filter/dateANDdoctor/appointments")
    public ResultData<List<AppointmentResponse>> getAppointmentsByDateRangeDoctor(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "doctorId", required = false) Long doctorId) {
        // Randevuları belirtilen tarih aralığında ve opsiyonel olarak doktor ID'sine göre al
        List<Appointment> appointments;
        if (doctorId != null) {
            appointments = appointmentService.getAppointmentsByDateRangeAndDoctorId(startDate, endDate, doctorId);
        } else {
            appointments = appointmentService.getAppointmentsByDateRange(startDate, endDate);
        }

        // Eğer randevu bulunamadıysa
        if (appointments.isEmpty()) {
            return ResultHelper.errorWithData("Belirtilen tarih aralığında randevu bulunamadı.", null, HttpStatus.NOT_FOUND);

        }

        // Randevuları AppointmentResponse listesine dönüştür
        List<AppointmentResponse> appointmentResponses = appointments.stream()
                .map(appointment -> modelMapper.forResponse().map(appointment, AppointmentResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(appointmentResponses);
    }

    @GetMapping("/filter/dateANDanimal/appointments")
    public ResultData<List<AppointmentResponse>> getAppointmentsByDateRangeAndAnimal(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "animalId") Long animalId) {
        // Randevuları belirtilen tarih aralığında ve belirli bir hayvana göre al
        List<Appointment> appointments = appointmentService.getAppointmentsByDateRangeAndAnimal(startDate, endDate, animalId);

        // Eğer randevu bulunamadıysa
        if (appointments.isEmpty()) {
            return ResultHelper.errorWithData("Belirtilen tarih aralığında ve hayvana göre randevu bulunamadı.", null, HttpStatus.NOT_FOUND);
        }

        // Randevuları AppointmentResponse listesine dönüştür
        List<AppointmentResponse> appointmentResponses = appointments.stream()
                .map(appointment -> modelMapper.forResponse().map(appointment, AppointmentResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(appointmentResponses);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment updateAppointment=this.modelMapper.forResponse().map(appointmentUpdateRequest, Appointment.class);
        this.appointmentService.update(updateAppointment);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateAppointment, AppointmentResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.appointmentService.delete(id);
        return ResultHelper.ok();
    }

}
