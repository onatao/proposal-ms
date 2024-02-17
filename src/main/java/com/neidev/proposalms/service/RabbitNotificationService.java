package com.neidev.proposalms.service;

import com.neidev.proposalms.json.ProposalResponseForm;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitNotificationService {

    private RabbitTemplate rabbitTemplate;

    public void notify(ProposalResponseForm data, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", data);
    }
}
