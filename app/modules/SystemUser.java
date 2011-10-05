package modules;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class SystemUser {

    private boolean loggedIn = false;
    public models.User information = null;

    public void authorize(String username, String password) {
        List<models.User> users = models.User.find("username", username).fetch();
        if(users.size() == 1)
        {
            this.loggedIn = true;
            this.information = users.get(0);
        }
        else
        {
            this.loggedIn = false;
        }
    }



    public boolean isLoggedIn() {
        return this.loggedIn;
    }

}
