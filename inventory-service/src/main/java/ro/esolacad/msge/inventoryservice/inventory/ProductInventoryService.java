package ro.esolacad.msge.inventoryservice.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;

    public Optional<ProductInventoryModel> findByProductCode(String code) {
        return productInventoryRepository.findByProductCode(code)
                .map(productInventory -> ProductInventoryModel.builder()
                        .productCode(productInventory.getProductCode())
                        .price(productInventory.getPrice())
                        .stock(productInventory.getStock())
                        .build());
    }
}
