package ro.esolacad.msge.inventoryservice.inventory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
@Slf4j
public class InventoryResource {

    private final ProductInventoryService productInventoryService;

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProductInventoryModel> getProductByCode(@PathVariable("code") String code) {
        log.info("Getting product inventory with code: " + code);
        return productInventoryService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
