package ro.esolacad.msge.storeservice.product.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import ro.esolacad.msge.storeservice.product.ProductInventoryModel;

@Slf4j
@Component
public class InventoryFeignClientFallbackFactory implements FallbackFactory<InventoryFeignClient> {
    @Override
    public InventoryFeignClient create(final Throwable cause) {
        log.error("I have error!", cause);
        return new InventoryFeignClient() {
            @Override
            public ProductInventoryModel getInventory(final String productCode) {
                return ProductInventoryModel.builder()
                        .productCode(productCode)
                        .stock(0)
                        .build();
            }
        };
    }
}
