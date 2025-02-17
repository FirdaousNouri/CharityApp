package com.example.donationms.entities;

import com.example.donationms.feign.mappers.Organisation;
import com.example.donationms.feign.mappers.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
public class Donation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private long organisationId;
    private long userId;
    @Transient
    Organisation organisation;
    @Transient
    User user;
}
