package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.AvailableDate;
import org.springframework.data.domain.Page;

public interface IAvailableDateService {
    AvailableDate save(AvailableDate availableDate);

    AvailableDate get(long id);

    Page<AvailableDate> cursor(int page, int pageSize);

    AvailableDate update(AvailableDate availableDate);

    boolean delete(long id);
}
