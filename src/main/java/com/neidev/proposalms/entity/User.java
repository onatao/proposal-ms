package com.neidev.proposalms.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "USER")
@Table(name = "TB_USER")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String lastName;
    private String cpf;
    private String phoneNumber;
    private double income;

    @OneToOne(mappedBy = "user")
    private Proposal proposal;
}
