package ro.esolacad.msge.checkoutservice.checkout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrderModel {

    private String id;

    private String clientCode;

    private ShopOrder.State state;
    private BigDecimal totalValueWithTax;
    private BigDecimal totalValueWithoutTax;

    private List<OrderItemModel> orderItems;

    private String address;
}
