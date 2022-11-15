package ro.esolacad.msge.inventoryservice.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrderModel {

    private String orderCode;
    private String clientCode;

    private List<OrderItemModel> orderItems;
}
