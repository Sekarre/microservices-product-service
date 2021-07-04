package sekarre.com.productservice.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "productlookup")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLookupEntity implements Serializable {

    private static final long serialVersionUID = -9111216258626979742L;

    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String title;
}
