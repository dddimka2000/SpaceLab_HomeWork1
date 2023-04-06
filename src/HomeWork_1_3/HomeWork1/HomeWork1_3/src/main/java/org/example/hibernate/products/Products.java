package org.example.hibernate.products;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {
    @Id
    private int Product_id;

    @Column
    private String Productscol;

    @Column
    private String Price;
}

