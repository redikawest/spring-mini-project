package com.example.latihan.Partner.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partner_categories")
@SQLDelete(sql = "UPDATE partner_categories SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PartnerCategory {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp created_at;

    @Column(nullable = true)
    private Timestamp updated_at;

    private boolean deleted = Boolean.FALSE;
}
