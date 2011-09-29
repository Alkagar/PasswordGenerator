package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
@Table(name="passwords")
public class Password extends Model {
   
    public String user;
    public String password;
    public boolean shortType;

    public Password(String user, String password, boolean shortType) {
        this.user = user;
        this.password = password;
        this.shortType = shortType;
    }
}
