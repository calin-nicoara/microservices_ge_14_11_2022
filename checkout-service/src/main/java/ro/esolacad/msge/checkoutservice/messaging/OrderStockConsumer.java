package ro.esolacad.msge.checkoutservice.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ro.esolacad.msge.checkoutservice.checkout.OrderSaga;

import java.util.Map;
import java.util.function.Consumer;

import static ro.esolacad.msge.checkoutservice.checkout.OrderSaga.Step.CHECK_STOCK_LATER;
import static ro.esolacad.msge.checkoutservice.checkout.OrderSaga.Step.SEND_DELIVERY;

@Component
public class OrderStockConsumer {

    @Bean
    public Consumer<Message<Map<String, Boolean>>> orderStock() {
        return message -> {
//            System.out.println("RECEIVED ORDER STOCK");
//            System.out.println(message.getPayload());
//
//            //2. Get shop order and set appropriate state

            OrderSaga orderSaga = new OrderSaga();
            // Verify the inventory

            boolean stockIsValid = true;
            if(stockIsValid) {
                orderSaga.setStep(SEND_DELIVERY);
                //Send message to delivery service
            } else {
                orderSaga.setStep(CHECK_STOCK_LATER);

            }
        };
    }
}
