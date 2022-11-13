package ro.esolacad.msge.storeservice.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.msge.storeservice.category.Category;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(name = "product_name")
    private String name;

    private String description;

    @ManyToOne
    private Category category;
}
