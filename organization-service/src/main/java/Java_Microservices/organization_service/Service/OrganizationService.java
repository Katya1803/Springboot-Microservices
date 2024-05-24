package Java_Microservices.organization_service.Service;

import Java_Microservices.organization_service.Dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);
}