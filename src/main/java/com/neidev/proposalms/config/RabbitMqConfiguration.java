package com.neidev.proposalms.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    // Consumed by credit microservice
    @Bean
    public Queue createPendingProposalCreditQueue() {
        return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build();
    }

    // Consumed by notification microservice
    @Bean
    public Queue createPedingProposalNotificationQueue() {
        return QueueBuilder.durable("proposta-pendente.ms-notificacao").build();
    }

    // Consumed by proposal microservice
    @Bean
    public Queue createConluedProposalQueue() {
        return QueueBuilder.durable("proposta-concluida.ms-proposta").build();
    }

    // Consumed by notification microservice
    @Bean
    public Queue createConcludedProposalConluedProposalQueue() {
        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build();
    }

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange createFanOutExchangePendingProposal() {
        return ExchangeBuilder.fanoutExchange("proposta-pendente.ex").build();
    }

    @Bean
    public Binding createPendingProposalToCreditMsBinding() {
        return BindingBuilder
                .bind(createPendingProposalCreditQueue())
                .to(createFanOutExchangePendingProposal());
    }

    @Bean
    public Binding createPedingProposalToNotificationMsBinding() {
        return BindingBuilder
                .bind(createPedingProposalNotificationQueue())
                .to(createFanOutExchangePendingProposal());
    }
}
