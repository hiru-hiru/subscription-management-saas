package com.academy.subscription.service;

import com.academy.subscription.dto.CreateOrganizationRequest;
import com.academy.subscription.entity.Organization;
import com.academy.subscription.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Transactional
    public Organization createOrganization(CreateOrganizationRequest request){
        Organization organization = new Organization();

        organization.setName(request.getName());
        organization.setDescription(request.getDescription());

        return organizationRepository.save(organization);
    }
}
