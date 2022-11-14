package ro.esolacad.msge.storeservice.product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.esolacad.msge.storeservice.product.ProductInventoryModel;

@FeignClient(name="inventory-service",
//        url = "http://localhost:8082",
//        fallback = InventoryFeignClientFallback.class,
        fallbackFactory = InventoryFeignClientFallbackFactory.class
)
public interface InventoryFeignClient {

    @GetMapping("/inventory/{code}")
    ProductInventoryModel getInventory(@PathVariable("code") String productCode);
}
