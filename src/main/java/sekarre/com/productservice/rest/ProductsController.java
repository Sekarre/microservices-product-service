package sekarre.com.productservice.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @PostMapping
    public String createProduct() {
        return "Http post handled";
    }

    @GetMapping
    public String getProduct() {
        return "Http get handled";
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
