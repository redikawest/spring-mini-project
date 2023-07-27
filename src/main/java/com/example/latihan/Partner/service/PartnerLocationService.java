package com.example.latihan.Partner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

import com.example.latihan.Partner.dto.CreatePartnerLocationDto;
import com.example.latihan.Partner.dto.UpdatePartnerLocationDto;
import com.example.latihan.Partner.entity.PartnerLocation;
import com.example.latihan.Partner.repository.PartnerLocationRepository;
import com.example.latihan.Partner.response.PartnerLocationResponse;
import com.example.latihan.Utils.Response;

@Service
public class PartnerLocationService {

    @Autowired
    private PartnerLocationRepository partnerLocationRepository;
    
    public List<PartnerLocationResponse> getAll() {
        List<PartnerLocation> partnerLocations = partnerLocationRepository.findAll();
        
        List<PartnerLocationResponse> partnerLocationResponses = partnerLocations.stream()
                .map(this::response)
                .toList();

        return partnerLocationResponses;
    }

    public PartnerLocationResponse getDetail(String id) {
        PartnerLocation partnerLocation = partnerLocationRepository.findById(id)
                                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Location is not found"));

        return response(partnerLocation);
    }

    public PartnerLocationResponse create(CreatePartnerLocationDto request) {
        PartnerLocation partnerLocation = new PartnerLocation();

        partnerLocation.setName(request.getName());
        partnerLocation.setSlug(request.getName());
        partnerLocation.setLatitude(request.getLatitude());
        partnerLocation.setLongitude(request.getLongitude());
        partnerLocation.setIsParent(request.getIsParent());
        partnerLocation.setIsPopular(request.getIsPopular());
        partnerLocation.setDescription(request.getDescription());

        partnerLocationRepository.save(partnerLocation);

        return response(partnerLocation);
    }

    public PartnerLocationResponse update(String id, UpdatePartnerLocationDto request) {

        PartnerLocation partnerLocation = partnerLocationRepository.findById(id)
                                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Location is not found"));

        partnerLocation.setName(request.getName());
        partnerLocation.setSlug(request.getName());
        partnerLocation.setLatitude(request.getLatitude());
        partnerLocation.setLongitude(request.getLongitude());
        partnerLocation.setIsParent(request.getIsParent());
        partnerLocation.setIsPopular(request.getIsPopular());
        partnerLocation.setDescription(request.getDescription());

        partnerLocationRepository.save(partnerLocation);

        return response(partnerLocation);
    }

    public Response<String> delete(String id) {
        PartnerLocation partnerLocation = partnerLocationRepository.findById(id)
                                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner Location is not found"));

        partnerLocationRepository.delete(partnerLocation);

        return Response.<String>builder().data("OK").build();
    }

    /*
     * 
     * Private Function
     * 
     */

    private PartnerLocationResponse response(PartnerLocation partnerLocation) {
        return PartnerLocationResponse.builder().id(partnerLocation.getId())
                                                .name(partnerLocation.getName())
                                                .parent(partnerLocation.getParent())
                                                .latitude(partnerLocation.getLatitude())
                                                .longitude(partnerLocation.getLongitude())
                                                .isParent(partnerLocation.getIsParent())
                                                .isPopular(partnerLocation.getIsPopular())
                                                .description(partnerLocation.getDescription())
                                                .created_at(partnerLocation.getCreated_at())
                                                .build();
    }
}
