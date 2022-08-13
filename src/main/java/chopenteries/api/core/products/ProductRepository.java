package chopenteries.api.core.products;

import chopenteries.api.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    Optional<Products> findProductById(Integer id);

    Optional<Products> findProductBySku(Integer sku);

}
