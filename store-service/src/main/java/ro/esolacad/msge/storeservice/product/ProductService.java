package ro.esolacad.msge.storeservice.product;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.esolacad.msge.storeservice.product.feign.InventoryFeignClient;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    private final InventoryFeignClient inventoryFeignClient;

    public ProductService(ProductRepository productRepository, RestTemplate restTemplate,
                          InventoryFeignClient inventoryFeignClient) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
        this.inventoryFeignClient = inventoryFeignClient;
    }


    public Optional<ProductModel> findByProductCode(final String code) {
        return productRepository.findByCode(code)
            .map(product -> {
//                ResponseEntity<ProductInventoryModel> responseEntity = restTemplate.getForEntity("http://localhost:8082/inventory/" + code, ProductInventoryModel.class);
//                Integer stock = responseEntity.getBody().getStock();

                ProductInventoryModel inventory = inventoryFeignClient.getInventory(code);

                return ProductModel.builder()
                        .name(product.getName())
                        .code(product.getCode())
                        .categoryCode(product.getCategory().getCode())
                        .categoryName(product.getCategory().getName())
                        .stock(inventory.getStock())
                        .build();
            });
    }
}
