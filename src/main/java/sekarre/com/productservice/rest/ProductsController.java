package sekarre.com.productservice.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final Environment environment;

    @PostMapping
    public String createProduct() {
        return "Http post handled";
    }

    @GetMapping
    public String getProduct() {
        return "Http get handled" + environment.getProperty("local.server.port");
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Http delete handled";
    }

    @PutMapping
    public String putProduct() {
        return "Http put handled";
    }
}
