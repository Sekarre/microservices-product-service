package sekarre.com.productservice.core.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "products")
@Entity
@Data
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 2771958345297208915L;

    @Id
    @Column(unique = true)
    private String productId;

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
