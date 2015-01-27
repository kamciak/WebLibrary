package UserPackage;
/**
 * Klasa użytkownika
 * @author Kamil Gzyl
 */
public class User {
    public User(){}
    
    /**
     * Konstruktor użytkownika
     * @param name Imię użytkownika
     * @param surename Nazwisko użytkownika
     * @param pesel PESEL użytkownika
     * @param password Hasło użytkownika
     * @param country Kraj użytkownika
     * @param city Miejscowość użytkownika
     * @param post_code Kod pocztowy użytkownika
     * @param street Ulica użytkownika
     * @param phone_number Number telefonu użytkownika
     * @param admin Prawa admina użytkownika
     */
    public User(String name, String surename, String pesel, String password, String country, String city , String post_code, String street, String phone_number, Boolean admin){
            _name = name;
            _surename = surename;
            _country = country;
            _pesel = pesel;
            _password = password;
            _city = city;
            _post_code = post_code;
            _street = street;
            _phone_number = phone_number;
            _admin = admin;
       
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

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getSurename() {
        return _surename;
    }

    public void setSurename(String _surename) {
        this._surename = _surename;
    }

    public String getPesel() {
        return _pesel;
    }

    public void setPesel(String _pesel) throws InvalidPeselException {
        
        this._pesel = _pesel;
    }

    public String getPhone_number() {
        return _phone_number;
    }

    public void setPhone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String _city) {
        this._city = _city;
    }

    public String getPost_code() {
        return _post_code;
    }

    public void setPost_code(String _post_code) {
        this._post_code = _post_code;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String _street) {
        this._street = _street;
    }
    
    
    public String getAddress(){
        StringBuilder builder = new StringBuilder();
        
        builder.append("Kraj: "+ _country + "\n");
        builder.append("Miasto: "+_post_code+" "+ _city + "\n");
        builder.append("Ulica: "+ _street + "\n");
        
        return builder.toString();
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
    private Boolean _admin;

    public Boolean getAdmin() {
        return _admin;
    }

    public void setAdmin(Boolean _admin) {
        this._admin = _admin;
    }
}
