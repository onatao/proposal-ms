package com.neidev.proposalms.entity;

import jakarta.persistence.*;

@Entity(name = "PROPOSAL")
@Table(name = "TB_PROPOSAL")
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
