package sekarre.com.productservice.query;

import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sekarre.com.productservice.core.data.ProductEntity;
import sekarre.com.productservice.core.data.ProductRepository;
import sekarre.com.productservice.query.rest.ProductRestModel;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
@ProcessingGroup("product-group")
public class ProductsQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
        List<ProductRestModel> products = new ArrayList<>();

        List<ProductEntity> storedProducts = productRepository.findAll();

        for (ProductEntity productEntity : storedProducts) {
            ProductRestModel tempProduct = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, tempProduct);

            products.add(tempProduct);
        }

        return products;
    }

}
