package com.example.latihan.Partner.entity;

import java.sql.Timestamp;

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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partner_locations")
@SQLDelete(sql = "UPDATE partner_locations SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PartnerLocation {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false)
    private String slug;
    
    @Column(name = "parent", nullable = true)
    private String parent;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "latitude", nullable = true)
    private String latitude;

    @Column(name = "longitude", nullable = true)
    private String longitude;

    @Column(name = "isPopular", nullable = false)
    @Getter
    private Boolean isPopular;

    @Column(name = "isParent", nullable = false)
    @Getter
    private Boolean isParent;

    @Column(name = "description", nullable = true)
    private String description;

    private Timestamp created_at;

    @Column(nullable = true)
    private Timestamp updated_at;

    private boolean deleted = Boolean.FALSE;
}
