package ro.esolacad.msge.inventoryservice.inventory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class ProductListener {

    @KafkaListener(topics = "PRODUCT_TOPIC")
    public void newProductListener(@Payload GenericMessage<String> productMessage) {
        System.out.println(productMessage.getPayload());
    }
}
