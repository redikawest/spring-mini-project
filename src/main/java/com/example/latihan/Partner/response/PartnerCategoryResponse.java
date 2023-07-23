package com.example.latihan.Partner.response;

import java.sql.Timestamp;

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

    private Timestamp created_at;
}
