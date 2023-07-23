package com.example.latihan.Partner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.latihan.Partner.entity.PartnerCategory;

public interface PartnerCategoryRepository extends JpaRepository<PartnerCategory, String> {
    
}
