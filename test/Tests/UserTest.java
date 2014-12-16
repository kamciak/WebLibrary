package Tests;

import UserPackage.InvalidDataException;
import UserPackage.InvalidPeselException;
import UserPackage.User;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Kamciak
 */

public class UserTest {
    @Test
    public void createEmpyUser() {
        User user = new User();
        Assert.assertNotNull(user);
    }
    
    @Test
    public void correctPesel() throws InvalidDataException{
        User user = new User();
        String correctPesel = "91051403157";
        
        user.setPesel(correctPesel);
        Assert.assertEquals(correctPesel, user.getPesel());

    }    
    @Test(expected=InvalidDataException.class)
    public void invalidPesel() throws InvalidPeselException{
        User user = new User();
        String invalidPesel = "9105";
        user.setPesel(invalidPesel);   
    }
    
    
    @Test
    public void createUser(){
        try{
            User user = new User("Jan","Kowalski","91051403157","password","Polska","Kraków","30-059","Reymonta 17","795251451");
            Assert.assertNotNull(user);
        }
        catch(InvalidDataException e){
            System.err.println(e.getMessage());
        }
        
        
    }
    
}
