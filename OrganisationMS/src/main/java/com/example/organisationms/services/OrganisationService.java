package com.example.organisationms.services;

import com.example.organisationms.entities.Organisation;
import com.example.organisationms.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OrganisationService {
    @Autowired
    OrganisationRepository organisationRepository;

    public Organisation getOrganisation(Long id) {
        return organisationRepository.findById(id).orElse(null);
    }

    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }

    public Organisation saveOrganisation(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    public void deleteOrganisation(Long id) {
        organisationRepository.deleteById(id);
    }

    public Organisation updateOrganisation(Organisation organisation, Long id) {
        Organisation oldOrganisation = getOrganisation(id);
        if (oldOrganisation == null) {
            throw new RuntimeException("Organisation Not Found!");
        }
        else {
            oldOrganisation.setName(organisation.getName());
            oldOrganisation.setDescription(organisation.getDescription());
            return organisationRepository.save(oldOrganisation);
        }
    }


}
