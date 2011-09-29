package controllers.Admin;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;
import java.security.SecureRandom;
import java.math.BigInteger;

import controllers.*;
import models.*;




public class Index extends ApplicationDefault {

    public static void index(){
    	render();
    }
}
