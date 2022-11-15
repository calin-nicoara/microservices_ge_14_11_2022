package ro.esolacad.msge.inventoryservice.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private Long id;
    private String code;
    private String name;
    private String description;
    private String categoryName;
    private String categoryCode;
    private Integer stock;
}
