package com.example.latihan.Partner.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePartnerCategoryDto {
    
    @NotBlank
    private String name;

    private String description;
}
