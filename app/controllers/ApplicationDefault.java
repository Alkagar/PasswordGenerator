package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.security.SecureRandom;
import java.math.BigInteger;

import models.*;




public class ApplicationDefault extends Controller {

    @Before
    public static void setDefault() {
        renderArgs.put("applicationPrefix", Play.configuration.getProperty("passGen.app.prefix"));
        renderArgs.put("applicationName", Play.configuration.getProperty("passGen.app.name"));
        renderArgs.put("applicationVersion", Play.configuration.getProperty("passGen.app.version"));
    }
}
