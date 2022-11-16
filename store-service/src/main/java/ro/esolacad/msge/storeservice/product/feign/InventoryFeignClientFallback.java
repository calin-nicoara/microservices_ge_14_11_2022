package ro.esolacad.msge.storeservice.product.feign;

import org.springframework.context.annotation.Profile;
import ro.esolacad.msge.storeservice.product.ProductInventoryModel;

//@Component
@Profile("!test")
public class InventoryFeignClientFallback implements InventoryFeignClient {
    @Override
    public ProductInventoryModel getInventory(final String productCode) {
        return ProductInventoryModel.builder()
                .productCode(productCode)
                .stock(0)
                .build();
    }
}
