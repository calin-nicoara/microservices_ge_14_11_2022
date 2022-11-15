package ro.esolacad.msge.checkoutservice.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.msge.checkoutservice.checkout.OrderItemModel;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrderItemsForStock {

    private String orderCode;
    private List<OrderItemModel> orderItems;
}
