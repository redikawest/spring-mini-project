package com.example.latihan.Partner.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.latihan.Partner.dto.CreatePartnerCategoryDto;
import com.example.latihan.Partner.dto.UpdatePartnerCategoryDto;
import com.example.latihan.Partner.entity.PartnerCategory;
import com.example.latihan.Partner.repository.PartnerCategoryRepository;
import com.example.latihan.Partner.response.PartnerCategoryResponse;
import com.example.latihan.Utils.Response;

@Service
public class PartnerCategoryService {
    
    @Autowired
    private PartnerCategoryRepository partnerCategoryRepository;

    public PartnerCategoryResponse create(CreatePartnerCategoryDto request) {
        PartnerCategory partnerCategory = new PartnerCategory();
        partnerCategory.setName(request.getName());
        partnerCategory.setDescription(request.getDescription());
        partnerCategory.setCreated_at(new Timestamp(0));

        partnerCategoryRepository.save(partnerCategory);

        return response(partnerCategory);
    }

    public PartnerCategoryResponse getDetail(String id) {
        PartnerCategory partnerCategory = partnerCategoryRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Category is not found"));

        return response(partnerCategory);
    }

    public PartnerCategoryResponse update(String id, UpdatePartnerCategoryDto request) {
        PartnerCategory partnerCategory = partnerCategoryRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Category is not found"));

        partnerCategory.setName(request.getName());
        partnerCategory.setDescription(request.getDescription());
        partnerCategory.setUpdated_at(new Timestamp(0));

        partnerCategoryRepository.save(partnerCategory);

        return response(partnerCategory);
    }

    public Response<String> delete(String id) {
        PartnerCategory partnerCategory = partnerCategoryRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Category is not found"));

        partnerCategoryRepository.delete(partnerCategory);

        return Response.<String>builder().data("OK").build();
    }

    private PartnerCategoryResponse response(PartnerCategory partnerCategory) {
        return PartnerCategoryResponse.builder()
                                        .id(partnerCategory.getId())
                                        .name(partnerCategory.getName())
                                        .description(partnerCategory.getDescription())
                                        .created_at(partnerCategory.getCreated_at())
                                        .build();
                                    
    }
}
