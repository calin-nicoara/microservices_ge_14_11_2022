package ro.esolacad.msge.inventoryservice.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ProductListener {

//    @KafkaListener(topics = "PRODUCT_TOPIC")
    public void newProductListener(@Payload GenericMessage<String> productMessage) {
        System.out.println(productMessage.getPayload());
    }

    @Bean
    public Consumer<Message<ProductModel>> storeproduct() {
        return productModelMessage -> {
//            System.out.println(new String(productModelMessage.getHeaders().get(KafkaHeaders.RECEIVED_MESSAGE_KEY)));
            System.out.println(productModelMessage.getPayload());
        };
    }

}
