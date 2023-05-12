package com.innocodes.organizationservice.mapper;

import com.innocodes.organizationservice.dto.OrganizationDto;
import com.innocodes.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationCode(),
                organization.getOrganizationDescription(),
                organization.getCreatedDate()
        );
        return organizationDto;
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationCode(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getCreatedDate()
        );
        return organization;
    }

}
