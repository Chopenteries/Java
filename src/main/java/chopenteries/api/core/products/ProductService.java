package chopenteries.api.core.products;

import chopenteries.api.core.users.UserRepository;
import chopenteries.api.entities.Products;
import chopenteries.api.entities.User;
import chopenteries.api.https.exceptions.customExceptions.ProductIdNotFound;
import chopenteries.api.https.exceptions.customExceptions.UserMobileNumberNotFound;
import chopenteries.api.https.products.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Products registerNewProduct(Authentication authentication, ProductRequest request) {
        User user = findUserByAuth(authentication);
        Products newProduct = request.convertToEntity();
        newProduct.setCreatedBy("User_" + user.getId());
        newProduct.setUpdatedBy("User_" + user.getId());
        newProduct.getProductDetails().setCreatedBy("User_" + user.getId());
        newProduct.getProductDetails().setUpdatedBy("User_" + user.getId());

        return productRepository.save(newProduct);
    }

    public Products updateAll(Authentication authentication, int id, ProductRequest request) {
        User user = findUserByAuth(authentication);
        Products products = findProductById(id).orElseThrow();
        request.updateEntity(products);
        products.setUpdatedBy("User_" + user.getId());
        products.getProductDetails().setUpdatedBy("User_" + user.getId());
        return productRepository.save(products);
    }

    public Optional<Products> findProductById(int id) {
        return productRepository.findProductById(id);
    }

    public Optional<Products> findProductBySku(Integer sku){
        return productRepository.findProductBySku(sku);
    }

    public Products deleteProduct(int id){
        Products products = findProductById(id).orElseThrow(ProductIdNotFound::new);
        productRepository.delete(products);
        return products;
    }

    /*Private*/
    private User findUserByAuth(Authentication authentication) {
        return userRepository.findByMobileNumber(authentication.getName()).orElseThrow(UserMobileNumberNotFound::new);
    }
}
