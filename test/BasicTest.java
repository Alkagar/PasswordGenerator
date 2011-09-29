import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
    
    @Test
    public void createAndRetrievePassword() {
        new Password("John", "SuperHasło123!@#", false).save();
        Password pass1 = Password.find("byUser", "John").first();
        new Password("Bob", "ShortOne", true).save();
        Password pass2 = Password.find("byUser", "Bob").first();

        assertNotNull(pass1);
        assertNotNull(pass2);
        assertEquals((pass1.password.length() > 10), !pass1.shortType);
        assertEquals((pass1.password.length() < 10), pass1.shortType);
        assertEquals((pass2.password.length() > 10), false);

    }

}
