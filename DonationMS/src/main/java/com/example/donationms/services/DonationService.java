package com.example.donationms.services;

import com.example.donationms.entities.Donation;
import com.example.donationms.feign.clients.OrganisationRestClient;
import com.example.donationms.feign.clients.UserRestFeign;
import com.example.donationms.feign.mappers.Organisation;
import com.example.donationms.feign.mappers.User;
import com.example.donationms.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    @Autowired
    DonationRepository DonationRepository;
    @Autowired
    OrganisationRestClient organisationRestClient;
    @Autowired
    UserRestFeign userRestFeign;

    public Donation getDonation(Long id) {
        Donation donation = DonationRepository.findById(id).orElse(null);
        Organisation organisation = organisationRestClient.Afficherorganisation(donation.getOrganisationId());
        User user = userRestFeign.AfficherUser(donation.getUserId());
        donation.setOrganisation(organisation);
        donation.setUser(user);
        return donation;
    }

    public List<Donation> getAllDonations() {
        List<Donation> donations = DonationRepository.findAll();
        for (Donation donation : donations) {
            Organisation organisation = organisationRestClient.Afficherorganisation(donation.getOrganisationId());
            User user = userRestFeign.AfficherUser(donation.getUserId());
            donation.setOrganisation(organisation);
            donation.setUser(user);
        }
        return donations;
    }

    public Donation saveDonation(Donation Donation) {
        return DonationRepository.save(Donation);
    }

    public void deleteDonation(Long id) {
        DonationRepository.deleteById(id);
    }

    public Donation updateDonation(Donation Donation, Long id) {
        Donation oldDonation = getDonation(id);
        if (oldDonation == null) {
            throw new RuntimeException("Donation Not Found!");
        }
        else {
            oldDonation.setMessage(Donation.getMessage());
            oldDonation.setOrganisationId(Donation.getOrganisationId());
            oldDonation.setUserId(Donation.getUserId());
            return DonationRepository.save(oldDonation);
        }
    }


}
