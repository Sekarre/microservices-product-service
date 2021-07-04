package sekarre.com.productservice.command.rest;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import sekarre.com.productservice.command.CreateProductCommand;
import sekarre.com.productservice.rest.CreateProductRestModel;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    private final Environment environment;
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel product) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .title(product.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;

        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }

        return returnValue;
    }

//    @GetMapping
//    public String getProduct() {
//        return "Http get handled" + environment.getProperty("local.server.port");
//    }
//
//    @DeleteMapping
//    public String deleteProduct() {
//        return "Http delete handled";
//    }
//
//    @PutMapping
//    public String putProduct() {
//        return "Http put handled";
//    }
}
