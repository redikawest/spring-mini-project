package com.example.latihan.Partner.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerCategoryResponse {
    
    private Long id;

    private String name;

    private String description;

    private Instant created_at;
}
