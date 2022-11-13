package ro.esolacad.msge.checkoutservice.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @GetMapping(path = "/{order_id}")
    public ResponseEntity<ShopOrderModel> getOrder(@PathVariable("order_id") Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }
}
