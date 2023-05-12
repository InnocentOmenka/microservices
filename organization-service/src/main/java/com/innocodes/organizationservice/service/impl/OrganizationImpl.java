package com.innocodes.organizationservice.service.impl;

import com.innocodes.organizationservice.dto.OrganizationDto;
import com.innocodes.organizationservice.entity.Organization;
import com.innocodes.organizationservice.mapper.OrganizationMapper;
import com.innocodes.organizationservice.repository.OrganizationRepository;
import com.innocodes.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        //convert OrganizationDto to organization entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
