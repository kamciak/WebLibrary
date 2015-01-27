/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

/**
 *
 * @author Kamil Gzyl
 */
public class UserChecker {

    /**
     * Metoda sprawdzające czy wszystkie dane użytkownika zostały wprowadzone
     * @param user Obiekt użytkownika
     * @return True jeżeli wszystkie dane są dodane do obiektu User, w przeciwnym wypadku false
     * @see User
     */
    public static Boolean checkUser(User user){
     return gotAddress(user)&&gotCountry(user)
             &&gotName(user)
             &&gotPassword(user)
             &&gotPhoneNumber(user)
             &&gotPostCode(user)
             &&gotStreet(user)
             &&gotSurename(user)
             &&checkPesel(user.getPesel());
    }
    
    public static Boolean gotPassword(User user){
        return !(user.getPassword().isEmpty() || user.getPassword()==null);
    }
    
    public static Boolean gotName(User user){
        return !(user.getName().isEmpty() || user.getName()==null);
    }
    public static Boolean gotSurename(User user){
        return !(user.getSurename().isEmpty() || user.getSurename()==null);
    }
    public static Boolean gotStreet(User user){
        return !(user.getStreet().isEmpty() || user.getStreet()==null);
    }
    public static Boolean gotPostCode(User user){
        return  !(user.getPost_code().isEmpty() || user.getPost_code()==null);
    }
    public static Boolean gotPhoneNumber(User user){
        return !(user.getPhone_number().isEmpty() || user.getPhone_number()==null);
    }
    public static Boolean gotCountry(User user){
        return !(user.getCountry().isEmpty() || user.getCountry()==null);
    }
    public static Boolean gotAddress(User user){
        return !(user.getAddress().isEmpty() || user.getAddress()==null);
    }
    
    /**
     * Metoda sprawdzająca poprawność wprowadzonego numeru PESEL
     * @param pesel Number PESEL
     * @return True jeżeli PESEL poprawny, false w przeciwnym wypadku
     */
    public static Boolean checkPesel(String pesel){
        if(pesel==null) return false;
        if (pesel.length() != 11) return false;
        
        int[] scales = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};
        
        int control_sum = 0;
        for (int i = 0; i < 10; i++)
           control_sum += Integer.parseInt(pesel.substring(i, i+1)) * scales[i];
  
        int control_number = Integer.parseInt(pesel.substring(10, 11));

        control_sum %= 10;
        control_sum = 10 - control_sum;
        control_sum %= 10;

    return (control_sum == control_number);
    }    
    
}
