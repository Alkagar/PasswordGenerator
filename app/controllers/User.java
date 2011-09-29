package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.security.SecureRandom;
import java.math.BigInteger;

import models.*;




public class User extends ApplicationDefault {

    public static void showUser(@Required String username) {
        List<User> users = models.User.find("username", username).fetch();
        if(users.size() == 0)
        {
            flash.error("Nope... we don't have such user in our database. Sorry Winnetou... :(");
            Application.index();
        }
        render();
    }

    public static void createAccount(String username, String password1, String password2, String surname, String email, String firstName) {

        validation.required(username);
        validation.required(password1);
        validation.required(password2);
        validation.required(surname);
        validation.required(email);
        validation.required(firstName);
        params.flash();
       render(); 
    }
}
