package com.neidev.proposalms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
