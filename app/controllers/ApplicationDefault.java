package controllers;

import play.*;
import play.cache.*;
import play.mvc.*;
import play.mvc.Scope.*;
import play.data.validation.*;

import java.util.*;
import java.security.SecureRandom;
import java.math.BigInteger;

import models.*;
import modules.*;




public class ApplicationDefault extends Controller {

    @Before
    public static void setDefault() {
        /** putting defaults values to views  */
        renderArgs.put("applicationPrefix", Play.configuration.getProperty("passGen.app.prefix"));
        renderArgs.put("applicationName", Play.configuration.getProperty("passGen.app.name"));
        renderArgs.put("applicationVersion", Play.configuration.getProperty("passGen.app.version"));

        SystemUser authUser = SystemUser.retrieveUserFromSession();
        renderArgs.put("authUser", authUser); // look out, it's null when user is not authorizes, need to check in view
    }
}
