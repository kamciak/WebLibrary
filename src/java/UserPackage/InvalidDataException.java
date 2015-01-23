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
public class InvalidDataException extends Exception{
    private String _msg = "Invalid data.";
    public InvalidDataException(String msg){
        super(msg);
        _msg = msg;
        
    }
    
    @Override
    public String getMessage(){
        return _msg;
    }
    
    
}
