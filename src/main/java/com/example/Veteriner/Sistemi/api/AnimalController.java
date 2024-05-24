package com.example.Veteriner.Sistemi.api;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAnimalService;
import com.example.Veteriner.Sistemi.bussines.abstracts.ICustomerService;
import com.example.Veteriner.Sistemi.core.config.modelMapper.IModelMapperService;
import com.example.Veteriner.Sistemi.core.result.Result;
import com.example.Veteriner.Sistemi.core.result.ResultData;
import com.example.Veteriner.Sistemi.core.utilies.ResultHelper;
import com.example.Veteriner.Sistemi.dto.request.animal.AnimalSaveRequest;
import com.example.Veteriner.Sistemi.dto.request.animal.AnimalUpdateRequest;
import com.example.Veteriner.Sistemi.dto.response.CursorResponse;
import com.example.Veteriner.Sistemi.dto.response.animal.AnimalResponse;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Customer;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// AnimalController sınıfı, hayvanlarla ilgili istekleri yönetir.
@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final IAnimalService animalService;
    private final IModelMapperService modelMapper;
    private final ICustomerService customerService;

    public AnimalController(IAnimalService animalService, IModelMapperService modelMapper, ICustomerService customerService) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    // Yeni bir hayvan kaydeder.
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest) {
        Animal saveAnimal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);

        Customer customer = this.customerService.get(animalSaveRequest.getCustomerId());
        saveAnimal.setCustomer(customer);

        this.animalService.save(saveAnimal);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveAnimal, AnimalResponse.class));

    }

    // Belirtilen kimliğe sahip bir hayvanı döner.
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> get(@PathVariable("id") int id) {
        Animal animal = this.animalService.get(id);
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(animal, AnimalResponse.class);
        return ResultHelper.success(animalResponse);
    }

    @GetMapping("/customer/{customerId}/animals")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AnimalResponse>> getCustomerAnimals(@PathVariable("customerId") long customerId) {
        // Hayvan sahibinin kimlik numarasına göre ilgili hayvanları al
        List<Animal> customerAnimals = this.animalService.getCustomerAnimals(customerId);

        // Alınan hayvanları AnimalResponse nesnelerine dönüştür
        List<AnimalResponse> animalResponses = customerAnimals.stream()
                .map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class))
                .collect(Collectors.toList());

        // Başarılı bir şekilde hayvanları dön
        return ResultHelper.success(animalResponses);
    }

    // Belirtilen ada göre hayvan listesi döner.
    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AnimalResponse>> findByName(@RequestParam("name") String name) {
        List<Animal> animals = this.animalService.findByName(name);
        List<AnimalResponse> animalResponses = animals.stream()
                .map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(animalResponses);
    }

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre hayvanları döner.
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AnimalResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize

    ) {
        Page<Animal> animalPage = this.animalService.cursor(page, pageSize);
        Page<AnimalResponse> animalResponsePage = animalPage
                .map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
        return ResultHelper.cursor(animalResponsePage);
    }

    // Var olan bir hayvanı günceller.
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest) {
        Animal updateAnimal = this.modelMapper.forResponse().map(animalUpdateRequest, Animal.class);
        this.animalService.update(updateAnimal);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateAnimal, AnimalResponse.class));
    }

    // Belirtilen kimliğe sahip bir hayvanı siler.
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id) {
        this.animalService.delete(id);
        return ResultHelper.ok();
    }
}
