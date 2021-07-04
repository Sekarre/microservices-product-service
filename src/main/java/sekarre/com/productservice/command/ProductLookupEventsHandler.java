package sekarre.com.productservice.command;

import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import sekarre.com.productservice.core.data.ProductLookupEntity;
import sekarre.com.productservice.core.data.ProductLookupRepository;
import sekarre.com.productservice.core.events.ProductCreatedEvent;

@RequiredArgsConstructor
@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

    private final ProductLookupRepository productLookupRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductLookupEntity productLookupEntity = new ProductLookupEntity(event.getProductId(), event.getTitle());

        productLookupRepository.save(productLookupEntity);
    }
}
