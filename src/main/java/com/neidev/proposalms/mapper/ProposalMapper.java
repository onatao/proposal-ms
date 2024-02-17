package com.neidev.proposalms.mapper;

import com.neidev.proposalms.entity.Proposal;
import com.neidev.proposalms.json.ProposalRequestForm;
import com.neidev.proposalms.json.ProposalResponseForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface ProposalMapper {

    ProposalMapper mapper = Mappers.getMapper(ProposalMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "integrated", ignore = true)
    @Mapping(target = "observation", ignore = true)
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "user.cpf", source = "cpf")
    @Mapping(target = "user.phoneNumber", source = "phoneNumber")
    @Mapping(target = "user.income", source = "income")
    Proposal toEntity(ProposalRequestForm data);

    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "phoneNumber", source = "user.phoneNumber")
    @Mapping(target = "cpf", source = "user.cpf")
    @Mapping(target = "income", source = "user.income")
    // Calling the expression thatll convert the double
    @Mapping(target = "requiredAmountRes", expression = "java(setRequiredAmountRes(data))")
    ProposalResponseForm toResponse(Proposal data);

    List<ProposalResponseForm> parseToResponseList(Iterable<Proposal> proposal);

    /**
     * Converting the double value (Proposal - double amount) to String
     * to avoid conflict with frontend application & keep location format
     * @param data
     * @return proposal amount attribute converted from Double to String
     */
    default String setRequiredAmountRes(Proposal data) {
        return NumberFormat.getCurrencyInstance().format(data.getAmount());
    }
}
