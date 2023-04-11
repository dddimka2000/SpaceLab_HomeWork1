package org.example.model;

import lombok.*;
@NoArgsConstructor
@Setter
@Getter
public class ShoppingCart {
    int id;
    int user_id;

    public ShoppingCart(int id, User user) {
        this.id = id;
        this.user_id = user.getUserId();
    }
}
