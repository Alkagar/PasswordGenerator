package modules;

import play.*;
import play.cache.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.io.Serializable;

import models.*;


public class SystemUser implements Serializable {

    private boolean loggedIn = false;
    public models.User information = null;

    public void authorize(String username, String password) {
        List<models.User> users = models.User.find("username = ? and password = ?", username, password).fetch();
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

    public void logout() {
        Cache.safeDelete("authUser");
    }
    
    public void storeUserInSession() {
        Cache.set("authUser", this);
    }

    public static SystemUser retrieveUserFromSession() {
        SystemUser authUser = (SystemUser)Cache.get("authUser");
        return authUser;
    }
}
