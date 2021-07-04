package sekarre.com.productservice.core.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sekarre.com.productservice.core.data.ProductEntity;
import sekarre.com.productservice.core.data.ProductRepository;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    @ExceptionHandler(resultType = Exception.class)
    public void handle(Exception e) throws Exception {
        throw e;
    }

    @ExceptionHandler(resultType = IllegalArgumentException.class)
    public void handle(IllegalArgumentException e) {
        throw e;

    }

    @EventHandler
    public void on(ProductCreatedEvent event) {

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productRepository.save(productEntity);
    }

}
