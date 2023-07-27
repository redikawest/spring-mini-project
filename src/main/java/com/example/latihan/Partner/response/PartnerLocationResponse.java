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
public class PartnerLocationResponse {
    
    private Long id;

    private String name;

    private String slug;

    private String parent;

    private String latitude;

    private String longitude;

    private Boolean isPopular;

    private Boolean isParent;

    private String description;

    private Timestamp created_at;
}
