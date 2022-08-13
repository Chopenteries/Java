package chopenteries.api.entities;

import chopenteries.api.entities.templates.DefaultEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products extends DefaultEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // package name
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Integer sku;

    // price
    @Column(nullable = false)
    private Integer price;

    // Relation
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private ProductDetails productDetails;

}
