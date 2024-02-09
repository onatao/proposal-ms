package com.neidev.proposalms.service;

import com.neidev.proposalms.json.ProposalRequestForm;
import com.neidev.proposalms.json.ProposalResponseForm;
import com.neidev.proposalms.mapper.ProposalMapper;
import com.neidev.proposalms.repository.ProposalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;

    @Transactional
    public ProposalResponseForm create(ProposalRequestForm data) {
        var entity = ProposalMapper.INSTANCE.toEntity(data);
        proposalRepository.save(entity);
        return ProposalMapper.INSTANCE.toResponse(entity);
    }
}
