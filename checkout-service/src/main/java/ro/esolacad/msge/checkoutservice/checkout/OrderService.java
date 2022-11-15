package ro.esolacad.msge.checkoutservice.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final StreamBridge streamBridge;

    public ShopOrderModel getOrder(final Long orderId) {
        ShopOrder shopOrder = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Not found!"));

        return ShopOrderModel.builder()
                .id(shopOrder.getId().toString())
                .totalValueWithoutTax(shopOrder.getTotalValueWithoutTax())
                .totalValueWithTax(shopOrder.getTotalValueWithTax())
                .build();
    }

    public void createOrder(ShopOrderModel shopOrderModel) {
        // 1. Create order in status PENDING

        GenericMessage<ShopOrderModel> message = new GenericMessage<>(shopOrderModel,
                Map.of(KafkaHeaders.MESSAGE_KEY, shopOrderModel.getOrderCode().getBytes())
        );
        streamBridge.send("shop-order-out-0", message);
    }
}
