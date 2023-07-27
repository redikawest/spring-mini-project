package com.example.latihan.Partner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.latihan.Partner.dto.CreatePartnerLocationDto;
import com.example.latihan.Partner.dto.UpdatePartnerLocationDto;
import com.example.latihan.Partner.response.PartnerLocationResponse;
import com.example.latihan.Partner.service.PartnerLocationService;
import com.example.latihan.Utils.Response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RestController
@AllArgsConstructor
public class PartnerLocationController {
    
    @Autowired
    final private PartnerLocationService partnerLocationService;

    @GetMapping(
        path = "/api/server/partner/location/{locationId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<PartnerLocationResponse> getDetail(@PathVariable("locationId") String id) {

        PartnerLocationResponse partnerLocationResponse = partnerLocationService.getDetail(id);
        return Response.<PartnerLocationResponse>builder().data(partnerLocationResponse).build();
    }

    @PostMapping(
        path = "/api/server/partner/location",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<PartnerLocationResponse> create(@RequestBody @Valid CreatePartnerLocationDto request) {

        PartnerLocationResponse partnerLocationResponse = partnerLocationService.create(request);
        return Response.<PartnerLocationResponse>builder().data(partnerLocationResponse).build();
    }

    @PutMapping(
        path = "/api/server/partner/location/{locationId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<PartnerLocationResponse> update(@PathVariable("locationId") String id,
                                        @RequestBody @Valid UpdatePartnerLocationDto request) {
            
        PartnerLocationResponse partnerLocationResponse = partnerLocationService.update(id, request);
        return Response.<PartnerLocationResponse>builder().data(partnerLocationResponse).build();
    }

    @DeleteMapping(
        path = "/api/server/partner/location/{locationId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<String> delete(@PathVariable("locationId") String id) {

        partnerLocationService.delete(id);
        return Response.<String>builder().data("Oke").build();
    }
}
