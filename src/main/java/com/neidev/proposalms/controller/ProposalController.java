package com.neidev.proposalms.controller;

import com.neidev.proposalms.json.ProposalRequestForm;
import com.neidev.proposalms.json.ProposalResponseForm;
import com.neidev.proposalms.service.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposal")
@AllArgsConstructor
public class ProposalController {

    private final ProposalService proposalService;

    @PostMapping()
    public ResponseEntity<ProposalResponseForm> create(@RequestBody ProposalRequestForm data) {
        var response = proposalService.create(data);
        // returning status code 201 & resource path, location.
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(response.getId()).toUri()).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProposalResponseForm>> findAll() {
       return ResponseEntity.ok(proposalService.findAll());
    }
}
