package com.example.latihan.Partner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.latihan.Partner.dto.CreatePartnerCategoryDto;
import com.example.latihan.Partner.dto.UpdatePartnerCategoryDto;
import com.example.latihan.Partner.response.PartnerCategoryResponse;
import com.example.latihan.Partner.service.PartnerCategoryService;
import com.example.latihan.Utils.Response;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;

@Controller
@RestController
@AllArgsConstructor
public class PartnerCategoryController {
    
    @Autowired
    private final PartnerCategoryService partnerCategoryService;

    @GetMapping(
        path = "/api/server/partner/category",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<PartnerCategoryResponse>> getAll() {
        
        List<PartnerCategoryResponse> partnerCategoryResponses = partnerCategoryService.getAll();
        return ResponseEntity.ok().body(partnerCategoryResponses);
    }

    @GetMapping(
        path = "/api/server/partner/category/{categoryId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<PartnerCategoryResponse> getDetail(@PathVariable("categoryId") String id) {
        PartnerCategoryResponse partnerCategoryResponse = partnerCategoryService.getDetail(id);

        return Response.<PartnerCategoryResponse>builder().data(partnerCategoryResponse).build();
    }

    @PostMapping(
            path = "/api/server/partner/category",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<PartnerCategoryResponse> create(@RequestBody @Valid CreatePartnerCategoryDto request) {

        PartnerCategoryResponse partnerCategoryResponse = partnerCategoryService.create(request);
        return Response.<PartnerCategoryResponse>builder().data(partnerCategoryResponse).build();
    }

    @PutMapping(
        path = "/api/server/partner/category/{categoryId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<PartnerCategoryResponse> update(@RequestBody @Valid 
                                                    UpdatePartnerCategoryDto request,
                                                    @PathVariable("categoryId") String categoryId) {

        PartnerCategoryResponse partnerCategoryResponse = partnerCategoryService.update(categoryId, request);
        return Response.<PartnerCategoryResponse>builder().data(partnerCategoryResponse).build();
    }

    @DeleteMapping(
        path = "/api/server/partner/category/{categoryId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<String> delete(@PathVariable("categoryId") String categoryId) {

        partnerCategoryService.delete(categoryId);
        return Response.<String>builder().data("OK").build();
    }
}
