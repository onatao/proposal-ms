package com.neidev.proposalms.service;

import com.neidev.proposalms.json.ProposalRequestForm;
import com.neidev.proposalms.json.ProposalResponseForm;
import com.neidev.proposalms.repository.ProposalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;

    public ProposalResponseForm create(ProposalRequestForm data) {
        return null;
    }
}
