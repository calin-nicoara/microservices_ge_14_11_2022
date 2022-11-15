package ro.esolacad.msge.storeservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductRepository productRepository;
    private final ProductService productService;
//    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final StreamBridge streamBridge;

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
//        ListenableFuture<SendResult<String, Object>> sendResult = kafkaTemplate.send("PRODUCT_TOPIC", productModel.getCode(), productModel);
//        sendResult.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(final Throwable ex) {
//                System.out.println("FAILURE");
//            }
//
//            @Override
//            public void onSuccess(final SendResult<String, Object> result) {
//                System.out.println("SUCCESS");
//            }
//        });

        GenericMessage<ProductModel> message = new GenericMessage<>(productModel,
                Map.of(KafkaHeaders.MESSAGE_KEY, productModel.getCode().getBytes())
        );
        streamBridge.send("store-producer-out-0", message);
    }
}
