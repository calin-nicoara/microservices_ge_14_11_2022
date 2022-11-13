package ro.esolacad.msge.inventoryservice.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventoryModel {

    private String productCode;
    private BigDecimal price;
    private Integer stock;
}
