package org.example.model;
import java.io.Serializable;

public class User implements Serializable {
     int userId;
     String name;

     public User() {
     }

     public User(int userId, String name) {
          this.userId = userId;
          this.name = name;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getUserId() {
          return userId;
     }

     public void setUserId(int userId) {
          this.userId = userId;
     }
}

