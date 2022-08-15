package chopenteries.api.entities;

import chopenteries.api.entities.templates.DefaultEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_details")
@Getter
@Setter
public class ProductDetails extends DefaultEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String description;

    @Column(nullable = false)
    private String productType;

    // Relation
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", referencedColumnName = "products_sku", nullable = false)
    @JsonManagedReference
    private Products products;
}
