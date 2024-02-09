package com.neidev.proposalms.repository;

import com.neidev.proposalms.entity.Proposal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, String> {

}
