package ro.esolacad.msge.checkoutservice.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public ShopOrderModel getOrder(final Long orderId) {
        ShopOrder shopOrder = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Not found!"));

        return ShopOrderModel.builder()
                .id(shopOrder.getId().toString())
                .totalValueWithoutTax(shopOrder.getTotalValueWithoutTax())
                .totalValueWithTax(shopOrder.getTotalValueWithTax())
                .build();
    }
}
