package ro.esolacad.msge.storeservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping()
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{product_code}")
    public Optional<ProductModel> getProduct(@PathVariable("product_code") String code) {
        return productService.findByProductCode(code);
    }

    @PostMapping()
    public void saveProduct(@RequestBody ProductModel productModel) {
        //save in database
        ListenableFuture<SendResult<String, Object>> sendResult = kafkaTemplate.send("PRODUCT_TOPIC", productModel.getCode(), productModel);
        sendResult.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(final Throwable ex) {
                System.out.println("FAILURE");
            }

            @Override
            public void onSuccess(final SendResult<String, Object> result) {
                System.out.println("SUCCESS");
            }
        });

    }
}
