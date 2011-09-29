package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
@Table(name="users")
public class User extends Model {
   
    public String username;
    public String password;
    public String firstName;
    public String surname;
    public String email;


    public User(String username, String password, String firstName, String surname, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
    }
}
