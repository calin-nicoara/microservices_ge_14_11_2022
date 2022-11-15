package ro.esolacad.msge.checkoutservice.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @GetMapping(path = "/{order_id}")
    public ResponseEntity<ShopOrderModel> getOrder(@PathVariable("order_id") Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @PostMapping
    public void createOrder(@RequestBody ShopOrderModel shopOrderModel) {
        orderService.createOrder(shopOrderModel);
    }
}
