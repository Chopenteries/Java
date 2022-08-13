package chopenteries.api.https.products.dto;

import chopenteries.api.entities.ProductDetails;
import chopenteries.api.entities.Products;
import chopenteries.api.response.converter.DtoConverter;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class ProductRequest implements DtoConverter<Products> {

    @Max(50)
    private String name;

    @Min(8)
    @Max(8)
    private Integer sku;

    private Integer price;

    @Max(50)
    private String description;

    private String productType;

    @Override
    public Products convertToEntity() {

        Products newProduct = new Products();
        newProduct.setName(this.name);
        newProduct.setSku(this.sku);
        newProduct.setPrice(this.price);

        newProduct.setProductDetails(new ProductDetails());
        newProduct.getProductDetails().setDescription(this.description);
        newProduct.getProductDetails().setProductType(this.productType);
        newProduct.getProductDetails().setProducts(new Products());

        return newProduct;
    }

    @Override
    public Products updateEntity(Products products) {

        products.setName(name == null ? products.getName() : this.name);
        products.setPrice(price == null ? products.getPrice() : this.price);

        ProductDetails productDetails = products.getProductDetails();
        if (this.description != null && !this.description.isBlank()){
            productDetails.setDescription(this.getDescription());
        }
        if (this.productType != null && !this.productType.isBlank()){
            productDetails.setProductType(this.getProductType());
        }
        return products;
    }
}
