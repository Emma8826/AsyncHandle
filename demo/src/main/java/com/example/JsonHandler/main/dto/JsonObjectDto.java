package com.example.JsonHandler.main.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class JsonObjectDto {
    String name;
    Integer price;
    Integer stock;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate updateDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate createdate;
}
