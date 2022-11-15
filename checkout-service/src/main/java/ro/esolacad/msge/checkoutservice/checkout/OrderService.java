package ro.esolacad.msge.checkoutservice.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import ro.esolacad.msge.checkoutservice.messaging.ShopOrderItemsForStock;

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

    public void createOrderWithSaga(final ShopOrderModel shopOrderModel) {
        //1. Create initial order
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setOrderCode("ORD_1");

        //2. Create related saga
        OrderSaga orderSaga = new OrderSaga();
        orderSaga.setShopOrder(shopOrder);
        orderSaga.setStep(OrderSaga.Step.RESERVE_STOCK);

        ShopOrderItemsForStock shopOrderItemsForStock = ShopOrderItemsForStock.builder()
                .orderCode(shopOrderModel.getOrderCode())
                .orderItems(shopOrderModel.getOrderItems())
                .build();

        streamBridge.send("shop-order-check-stock-out-0", shopOrderItemsForStock);

        //TODO
        // On inventory-service create a new channel to connect to SHOP_ORDER_CHECK_STOCK
        // After checking stock, send new message on a different topic SHOP_ORDER_STOCK_VERIFIED
        // Check out service will listen to new message, if all products are in stock
        //   the saga with go to next step CHECK_CUSTOMER
        //   checkout service will send a new message on SHOP_ORDER_CHECK_CUSTOMER
        // to account-service and see if customer has a good credit (credit > order value)
        // then the account-service will send message back to checkout-service
    }
}
