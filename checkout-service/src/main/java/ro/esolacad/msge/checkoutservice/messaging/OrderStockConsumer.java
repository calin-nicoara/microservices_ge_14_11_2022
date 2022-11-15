package ro.esolacad.msge.checkoutservice.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class OrderStockConsumer {

    @Bean
    public Consumer<Message<Map<String, Boolean>>> orderStock() {
        return message -> {
            System.out.println("RECEIVED ORDER STOCK");
            System.out.println(message.getPayload());

            //2. Get shop order and set appropriate state
        };
    }
}
