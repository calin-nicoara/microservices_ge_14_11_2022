package ro.esolacad.msge.inventoryservice.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryResource {

    private final ProductInventoryService productInventoryService;

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProductInventoryModel> getProductByCode(@PathVariable("code") String code) {
        return productInventoryService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
