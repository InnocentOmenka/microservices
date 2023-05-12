package com.innocodes.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private Long id;
    private String organizationName;
    private String organizationCode;
    private String organizationDescription;
    private LocalDateTime createdDate;
}
