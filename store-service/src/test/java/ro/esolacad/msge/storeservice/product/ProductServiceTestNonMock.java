package ro.esolacad.msge.storeservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTestNonMock {

    @Autowired
    public ProductService productService;

    @Test
    @Transactional
    @Sql(value = "/product_for_get.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testGetProduct() {
        Optional<ProductModel> productModel = productService.findByProductCode("PR_7");

        System.out.println(productModel);
    }
}
