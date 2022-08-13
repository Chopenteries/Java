package chopenteries.api.https.products.dto;

import chopenteries.api.entities.ProductDetails;
import chopenteries.api.response.converter.DtoConverter;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Getter
@Setter
public class ProductDetailRequest implements DtoConverter<ProductDetails> {

    @Max(50)
    private String description;

    private String productType;

    @Override
    public ProductDetails convertToEntity() {
        return null;
    }

    @Override
    public ProductDetails updateEntity(ProductDetails productDetails) {
        return null;
    }
}
