package br.com.fiap.mensageria.consumer;

import br.com.fiap.mensageria.config.RabbitConfig;
import br.com.fiap.mensageria.model.OrderCreatedMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void processOrderCreated(OrderCreatedMessage message) {
        //log.info("Received OrderCreatedMessage: " + message);

    }
}
