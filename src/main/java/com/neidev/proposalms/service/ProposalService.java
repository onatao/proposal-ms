package com.neidev.proposalms.service;

import com.neidev.proposalms.json.ProposalRequestForm;
import com.neidev.proposalms.json.ProposalResponseForm;
import com.neidev.proposalms.mapper.ProposalMapper;
import com.neidev.proposalms.repository.ProposalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final RabbitNotificationService rabbitNotificationService;

    @Transactional
    public ProposalResponseForm create(ProposalRequestForm data) {
        var entity = ProposalMapper.mapper.toEntity(data);
        proposalRepository.save(entity);

        var response = ProposalMapper.mapper.toResponse(entity);
        rabbitNotificationService.notify(response, "proposta-pendente.ex");

        return response;
    }

    @Transactional
    public List<ProposalResponseForm> findAll() {
        return ProposalMapper
                .mapper.parseToResponseList(proposalRepository.findAll());
    }
}
