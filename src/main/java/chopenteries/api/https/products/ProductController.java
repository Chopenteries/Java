package chopenteries.api.https.products;

import chopenteries.api.core.products.ProductService;
import chopenteries.api.https.products.dto.ProductRequest;
import chopenteries.api.response.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user/{id}/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ResponseTemplate responseTemplate;

    @PostMapping("/register")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object registerProduct(Authentication authentication, ProductRequest request){
        return responseTemplate.createResponse(productService.registerNewProduct(authentication,request));
    }
    
    @PostMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object UpdateProduct(@RequestBody Authentication authentication, ProductRequest request,
                                @PathVariable("id") Integer id){
        return responseTemplate.createResponse(productService.updateAll(authentication,id,request));
    }

    @GetMapping("detail")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object getProductById(@PathVariable("id") Integer id){
        return responseTemplate.createResponse(productService.findProductById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Object deleteUserById(@PathVariable("id") int id) {
        return responseTemplate.createResponse(productService.deleteProduct(id));
    }
}
