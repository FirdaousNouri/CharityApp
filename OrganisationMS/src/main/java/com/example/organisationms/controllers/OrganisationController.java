package com.example.organisationms.controllers;

import com.example.organisationms.entities.Organisation;
import com.example.organisationms.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisationController {
    @Autowired
    OrganisationService organisationService;

    @GetMapping("/organisations/{id}")
    public Organisation Afficherorganisation(@PathVariable("id") Long organisationId){
        return organisationService.getOrganisation(organisationId);
    }

    @GetMapping("/organisations/all")
    public List<Organisation> Afficherorganisations(){
        return organisationService.getAllOrganisations();
    }

    @PostMapping("/organisations/add")
    public Organisation Addorganisation(@RequestBody Organisation organisation){
        return organisationService.saveOrganisation(organisation);
    }

    @DeleteMapping("/organisations/delete/{id}")
    public void Deleteorganisation(@PathVariable Long id){
        organisationService.deleteOrganisation(id);
    }

    @PutMapping("/organisations/update/{id}")
    public Organisation Updateorganisation(@PathVariable Long id, @RequestBody Organisation organisation){
        return organisationService.updateOrganisation(organisation, id);
    }
}
