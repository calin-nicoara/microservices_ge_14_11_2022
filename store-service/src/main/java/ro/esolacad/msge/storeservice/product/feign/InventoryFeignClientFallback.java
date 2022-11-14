package ro.esolacad.msge.storeservice.product.feign;

import org.springframework.stereotype.Component;
import ro.esolacad.msge.storeservice.product.ProductInventoryModel;

@Component
public class InventoryFeignClientFallback implements InventoryFeignClient {
    @Override
    public ProductInventoryModel getInventory(final String productCode) {
        return ProductInventoryModel.builder()
                .productCode(productCode)
                .stock(0)
                .build();
    }
}
