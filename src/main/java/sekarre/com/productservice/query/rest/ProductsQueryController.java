package sekarre.com.productservice.query.rest;

import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sekarre.com.productservice.query.FindProductsQuery;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductsQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> getProduct() {
        FindProductsQuery findProductsQuery = new FindProductsQuery();

        List<ProductRestModel> products = queryGateway.query(
                findProductsQuery,
                ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();

        return products;
    }

}
