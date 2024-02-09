package com.neidev.proposalms.entity;

import jakarta.persistence.*;

@Entity(name = "PROPOSAL")
@Table(name = "TB_PROPOSAL")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double amount;
    private int paymentTerm;
    private Boolean approved;
    private boolean integrated;
    private String observation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
