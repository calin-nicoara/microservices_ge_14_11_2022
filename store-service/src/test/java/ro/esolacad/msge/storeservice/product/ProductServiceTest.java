package ro.esolacad.msge.storeservice.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import ro.esolacad.msge.storeservice.category.Category;
import ro.esolacad.msge.storeservice.product.feign.InventoryFeignClient;

import java.util.Optional;

public class ProductServiceTest {

    @Test
    public void testGetProduct() {
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        InventoryFeignClient inventoryFeignClient = Mockito.mock(InventoryFeignClient.class);

        ProductService productService = new ProductService(productRepository, restTemplate, inventoryFeignClient);

        Product product = Product.builder().code("PR_1").name("Coca-Cola").category(new Category()).build();

        Mockito.when(productRepository.findByCode("PR_1"))
                .thenReturn(Optional.of(product));

        Mockito.when(inventoryFeignClient.getInventory("PR_1"))
                .thenReturn(new ProductInventoryModel());

        Optional<ProductModel> productModelOptional = productService.findByProductCode("PR_1");

        Assertions.assertTrue(productModelOptional.isPresent());

        ProductModel productModel = productModelOptional.get();
        Assertions.assertEquals("PR_1",productModel.getCode());
        Assertions.assertEquals("Coca-Cola",productModel.getName());
    }
}
