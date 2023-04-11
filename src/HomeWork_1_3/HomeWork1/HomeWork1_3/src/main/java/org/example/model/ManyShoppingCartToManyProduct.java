package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ManyShoppingCartToManyProduct {
    int id;
    int product_id;
    int shoppingCart_id;

    public ManyShoppingCartToManyProduct(int id, Product product, ShoppingCart shoppingCart) {
        this.id = id;
        this.product_id = product.getProductId();
        this.shoppingCart_id = shoppingCart.getId();
    }

    public ManyShoppingCartToManyProduct(int id, int product_id, int shoppingCart_id) {
        this.id = id;
        this.product_id = product_id;
        this.shoppingCart_id = shoppingCart_id;
    }
}
