package com.example.latihan.Partner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.latihan.Partner.entity.PartnerLocation;

public interface PartnerLocationRepository extends JpaRepository<PartnerLocation, String> {
    
}
