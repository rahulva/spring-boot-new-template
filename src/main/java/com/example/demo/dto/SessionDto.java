package com.example.demo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SessionDto {

    private Long personId;

    private LocalDate date;

    private LocalTime time;

    @Length(max = 3000, min = 10, message = "Please fill the session description")
    private String description;
}
