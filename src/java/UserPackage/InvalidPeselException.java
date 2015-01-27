package UserPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Kamil Gzyl
 */
public class InvalidPeselException extends InvalidDataException {

    public InvalidPeselException(){
        super("Podany numer PESEL jest nieprawidłowy!");
    }
    
    
    
}
