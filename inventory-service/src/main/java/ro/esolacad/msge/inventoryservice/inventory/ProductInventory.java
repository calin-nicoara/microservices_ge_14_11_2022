package ro.esolacad.msge.inventoryservice.inventory;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory {

    @Id
    private Long id;

    @Column(unique = true)
    private String productCode;

    private BigDecimal price;

    private Integer stock;
}
