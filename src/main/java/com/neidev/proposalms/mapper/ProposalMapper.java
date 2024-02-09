package com.neidev.proposalms.mapper;

import com.neidev.proposalms.entity.Proposal;
import com.neidev.proposalms.json.ProposalRequestForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProposalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "integrated", ignore = true)
    @Mapping(target = "observation", ignore = true)
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "user.cpf", source = "cpf")
    @Mapping(target = "user.phoneNumber", source = "phoneNumber")
    @Mapping(target = "user.income", source = "income")
    Proposal toProposal(ProposalRequestForm data);
}
