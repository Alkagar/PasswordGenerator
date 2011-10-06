package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.security.SecureRandom;
import java.math.BigInteger;

import models.*;
import modules.*;



public class User extends ApplicationDefault {

    public static void login() {
        validation.required(params.get("username"));
        validation.minSize(params.get("username"), 5);
        validation.minSize(params.get("password"), 5);

        /** application logic  */
        if(validation.hasErrors())
        {
            flash.error("Nope... I can't log you in. I can't validate your data. Sorry Winnetou... :(");
            Application.index();
        }
            
        SystemUser user = new SystemUser();
        user.authorize(params.get("username"), params.get("password"));
        user.storeUserInSession();
        if(user.isLoggedIn()) 
        {
            Application.index();
        }
        else
        {
            flash.error("Nope... I can't log you in. Wrong password or user name. Sorry Winnetou... :(");
            Application.index();
        }
    }

    public static void logout() {
       SystemUser user = SystemUser.retrieveUserFromSession();
       user.logout();
       Application.index();
    }
    public static void showUser(@Required String username) {
        List<models.User> users = models.User.find("username", username).fetch();
        if(users.size() == 0)
        {
            flash.error("Nope... we don't have such user in our database. Sorry Winnetou... :(");
            Application.index();
        }
        if(users.size() == 1)
        {
            models.User user = users.get(0);
            render(user);
        }
    }

    public static void createAccount(String username, String password1, String password2, String surname, String email, String firstName) {
        /** form validation  */
        validation.required(username);
        validation.minSize(username, 5);
        validation.required(password1);
        validation.minSize(password1, 5);
        validation.required(password2);
        validation.required(surname);
        validation.required(email);
        validation.required(firstName);
        if(password1 != null && password2 != null && !password1.equals(password2))
        {
            validation.addError("password1", "Passwords does not match");
        }
        
        /** application logic  */
        if(!validation.hasErrors())
        {
            new models.User(username, password1, firstName, surname, email).save();
            Application.index();
        }
        render(params); 
    }
}
