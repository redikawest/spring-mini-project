package com.example.latihan.Partner.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePartnerLocationDto {
    
    @NotBlank
    private String name;

    private String parent;
    
    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @NotBlank
    private Boolean isParent;

    @NotBlank
    private Boolean isPopular;

    private String description;
}
