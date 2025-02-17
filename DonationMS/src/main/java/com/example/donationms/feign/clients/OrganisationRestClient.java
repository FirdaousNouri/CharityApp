package com.example.donationms.feign.clients;

import com.example.donationms.feign.mappers.Organisation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organisation-ms")
public interface OrganisationRestClient {
    @GetMapping("/organisations/{id}")
    @CircuitBreaker(name = "organisationBreaker",fallbackMethod = "getDefaultOrganisation")
    Organisation Afficherorganisation(@PathVariable("id") Long organisationId);

    default Organisation getDefaultOrganisation(Long organisationId,Exception e){
        Organisation organisation = new Organisation();
        organisation.setId(organisationId);
        organisation.setName("Default Organisation Name");
        organisation.setDescription("Default Description !!");
        return organisation;
    }
}
