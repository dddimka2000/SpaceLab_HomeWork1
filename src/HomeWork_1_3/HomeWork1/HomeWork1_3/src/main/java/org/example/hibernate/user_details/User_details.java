package org.example.hibernate.user_details;

import lombok.*;
import org.example.hibernate.users.Users;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User_details {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int User_details_id;
    @Column
    private int age;
    @Column
    private String car;
    @OneToOne
    private Users users_id;
    public User_details(int age, String car, Users users_id) {
        this.age = age;
        this.car = car;
        this.users_id = users_id;
    }
}