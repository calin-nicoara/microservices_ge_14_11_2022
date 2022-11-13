package ro.esolacad.msge.storeservice.product;

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
}
