package com.example.latihan.Partner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.latihan.Partner.dto.CreatePartnerCategoryDto;
import com.example.latihan.Partner.response.PartnerCategoryResponse;
import com.example.latihan.Partner.service.PartnerCategoryService;
import com.example.latihan.Utils.Response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RestController
@AllArgsConstructor
public class PartnerCategoryController {
    
    @Autowired
    private final PartnerCategoryService partnerCategoryService;


    public Response<PartnerCategoryResponse> getDetail(@PathVariable("contactId") String id) {
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
}
