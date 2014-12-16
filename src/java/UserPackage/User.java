package UserPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamciak
 */
public class User {
    public User(){}
    
    
    public User(String name, String surename, String pesel, String password, String country, String city , String post_code, String street, String phone_number) throws InvalidDataException{
        try{
            _name = name;
            _surename = surename;
            _country = country;
            if(checkPesel(pesel))
                _pesel = pesel;
            else
                throw new InvalidPeselException();
            _password = password;
            _city = city;
            _post_code = post_code;
            _street = street;
            _phone_number = phone_number;
        } catch(InvalidDataException e){
            System.err.println(e.getMessage());
        }
    }
    
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        
        builder.append("Imię i nazwisko: "+_name + " " + _surename + "\n");
        builder.append("PESEL: " + _pesel + "\n");
        builder.append(this.getAddress());
        builder.append("Numer telefonu:" + _phone_number + "\n");
        
        return builder.toString();
    }
    
    public void setPassword(String password){
        _password = password;
    }
    
    public void setName(String name){
        _name = name;
    }
    
    public void setSurename(String surename){
        _surename = surename;
    }
    
    public void setPesel(String pesel) throws InvalidPeselException{
        
            if (checkPesel(pesel))
                _pesel = pesel;
            else
                throw new InvalidPeselException();
    }
    
    public void setCountry(String country){
        _country = country;
    }
    
    public void setCity(String city){
        _city = city;
    }
    
    public void setPostCode(String post_code){
        _post_code = post_code;
    }
    
    public void setStreet(String street){
        _street = street;
    }
    
    public void setPhoneNumber(String phone_number){
        _phone_number = phone_number;
    }
    
    public String getPassword(){
        return _password;
    }
    
    public String getName(){
        return _name;
    }
    
    public String getSurename(){
        return _surename;
    }
    
    public String getPesel(){
        return _pesel;
    }
    
    public String getCountry(){
        return _country;
    }
    
    public String getCity(){
        return _city;
    }
    
    public String getPostCode(){
        return _post_code;
    }
    
    public String getStreet(){
        return _street;
    }
    
    public String getAddress(){
        StringBuilder builder = new StringBuilder();
        
        builder.append("Kraj: "+ _country + "\n");
        builder.append("Miasto: "+_post_code+" "+ _city + "\n");
        builder.append("Ulica: "+ _street + "\n");
        
        return builder.toString();
    }
    
    public String getPhoneNumber(){
        return _phone_number;
    }
    
    
    
    private String _password;
    private String _name;
    private String _surename;
    private String _pesel;
    private String _phone_number;
    private String _country;
    private String _city;
    private String _post_code;
    private String _street;

    private boolean checkPesel(String pesel){
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
