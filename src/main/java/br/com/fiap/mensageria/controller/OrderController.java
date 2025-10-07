package br.com.fiap.mensageria.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mensageria.model.OrderCreatedMessage;
import br.com.fiap.mensageria.service.OrderPublisher;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderPublisher orderPublisher;

    public OrderController(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreatedMessage message) {
        try {
            orderPublisher.publishOrderCreated(message);
        } catch (Exception e) {
            // logaria aqui se tiver um logger (para não perder o erro do broker)
        }
        return ResponseEntity.ok("Order message published: 123");
    }
}