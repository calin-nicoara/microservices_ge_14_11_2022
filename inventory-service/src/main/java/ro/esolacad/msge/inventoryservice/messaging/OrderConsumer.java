package ro.esolacad.msge.inventoryservice.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Pair;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ro.esolacad.msge.inventoryservice.inventory.ProductInventory;
import ro.esolacad.msge.inventoryservice.inventory.ProductInventoryRepository;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final ProductInventoryRepository productInventoryRepository;
    private final StreamBridge streamBridge;

    @Bean
    public Consumer<Message<ShopOrderModel>> shopOrder() {
        return message -> {
            ShopOrderModel payload = message.getPayload();
            System.out.println("Logging order: " + payload);
            Map<String, Boolean> productStocks = payload.getOrderItems().stream()
                    .map(s -> {
                        Optional<ProductInventory> byProductCode = productInventoryRepository.findByProductCode(s.getProductCode());
                        return Pair.of(byProductCode.get().getProductCode(), byProductCode.get().getStock() > s.getQuantity());
                    })
                    .collect(Collectors.toMap(s -> s.getFirst(), s -> s.getSecond()));

            System.out.println("Setting order stock");
            streamBridge.send("orderStock-out-0", productStocks);
        };
    }
}
