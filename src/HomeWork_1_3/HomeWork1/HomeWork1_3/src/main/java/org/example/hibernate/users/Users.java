package org.example.hibernate.users;
import lombok.*;
import javax.persistence.*;
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
     @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
     int users_id;
     @Column
     String name;
}

