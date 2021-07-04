package sekarre.com.productservice.query;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sekarre.com.productservice.core.data.ProductEntity;
import sekarre.com.productservice.core.data.ProductRepository;
import sekarre.com.productservice.core.events.ProductCreatedEvent;

@RequiredArgsConstructor
@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productRepository.save(productEntity);
    }

}
