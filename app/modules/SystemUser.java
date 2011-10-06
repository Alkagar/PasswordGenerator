package modules;

import play.*;
import play.mvc.Scope.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.io.Serializable;

import models.*;


public class SystemUser implements Serializable {

    private boolean loggedIn = false;
    public models.User information = null;


    public SystemUser() {
        
    }

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
        Session session = Session.current();
        session.remove("authUser");
    }
    
    public void storeUserInSession() {
        Session session = Session.current();
        session.put("authUser", this.information.username); 
        System.out.println("Data stored in session");
    }

    public static SystemUser retrieveUserFromSession() {
        Session session = Session.current();
        SystemUser authUser = new SystemUser();
        if(session.contains("authUser"))
        {
            System.out.println("Try to get data from session");
            List<models.User> users = models.User.find("username = ?", session.get("authUser")).fetch();
            authUser.information = users.get(0);
        }
        return authUser;
    }
}
