package ro.esolacad.msge.storeservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<ProductModel> findByProductCode(final String code) {
        return productRepository.findByCode(code)
            .map(product -> ProductModel.builder()
                    .name(product.getName())
                    .code(product.getCode())
                    .categoryCode(product.getCategory().getCode())
                    .categoryName(product.getCategory().getName())
                    .build());
    }
}
