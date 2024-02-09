package com.neidev.proposalms.mapper;

import com.neidev.proposalms.entity.Proposal;
import com.neidev.proposalms.json.ProposalRequestForm;
import org.mapstruct.Mapper;

@Mapper
public interface ProposalMapper {
    Proposal toProposal(ProposalRequestForm data);
}
