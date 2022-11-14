package ro.esolacad.msge.storeservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{product_code}")
    public Optional<ProductModel> getProduct(@PathVariable("product_code") String code) {
        return productService.findByProductCode(code);
    }
}
