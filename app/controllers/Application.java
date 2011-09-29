package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.security.SecureRandom;
import java.math.BigInteger;

import models.*;




public class Application extends Controller {

    public static void index() {
        List<models.Password> passwords = models.Password.all().from(0).fetch(10);
        render(passwords);
    }

    public static void generate(@Required String username) {
        SecureRandom random = new SecureRandom();
        String randomPassword = new BigInteger(130, random).toString(32);
        if(validation.hasErrors()) {
            flash.error("Ooops, I need your name to generate random password");
            index();
        }
        new models.Password(username, randomPassword, false).save();
        index();
    }
    public static void sayHello(@Required String myName) {
        if(validation.hasErrors()) {
            flash.error("Oops, validation fails");
            index();
        }
        render(myName);
    }
}
