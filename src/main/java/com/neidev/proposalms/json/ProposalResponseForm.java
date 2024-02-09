package com.neidev.proposalms.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProposalResponseForm {

    private String id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String cpf;
    private Double income;
    private Double requiredAmount;
    private int paymentTerm;
    private Boolean approved;
    private String observation;
}
