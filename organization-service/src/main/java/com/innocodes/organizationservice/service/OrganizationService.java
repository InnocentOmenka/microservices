package com.innocodes.organizationservice.service;

import com.innocodes.organizationservice.dto.OrganizationDto;
import com.innocodes.organizationservice.entity.Organization;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);


}
