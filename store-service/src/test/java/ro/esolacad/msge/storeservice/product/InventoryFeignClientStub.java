package ro.esolacad.msge.storeservice.product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ro.esolacad.msge.storeservice.product.feign.InventoryFeignClient;

@Component
@Primary
public class InventoryFeignClientStub implements InventoryFeignClient {
    @Override
    public ProductInventoryModel getInventory(final String productCode) {
        return new ProductInventoryModel();
    }
}
