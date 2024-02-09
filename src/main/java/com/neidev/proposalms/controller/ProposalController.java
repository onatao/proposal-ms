package com.neidev.proposalms.controller;

import com.neidev.proposalms.json.ProposalRequestForm;
import com.neidev.proposalms.json.ProposalResponseForm;
import com.neidev.proposalms.service.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal")
@AllArgsConstructor
public class ProposalController {

    private final ProposalService proposalService;

    @PostMapping()
    public ResponseEntity<ProposalResponseForm> create(@RequestBody ProposalRequestForm data) {
        var response = proposalService.create(data);
        return ResponseEntity.ok(response);
    }
}
