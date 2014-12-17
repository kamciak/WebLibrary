/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

/**
 *
 * @author Kamciak
 */
public class LoginWrapper {
    
    private User _user;
    private LoginData _login_data;
    private String _msg;
    private boolean _is_logged;
    
    public LoginWrapper(){}
    
    public LoginWrapper(User user, LoginData login_data){
        this._user = user;
        this._login_data = login_data;
        this._is_logged = false;
    }
    
    public String check(){
        if(_user != null){
            if(_user.getPassword().equals(_login_data.getPassword())){
                _msg = "Zalogowano poprawnie!";
                _is_logged = true;
            }else{
                _msg = "Niepoprawne hasło!";
                _is_logged = false;
            }
            
            
        } else {
            _msg = "Użytkownik nie istnieje w bazie.";
            _is_logged = false;
        }
    
    return _msg;
    }

    public User getUser() {
        return _user;
    }

    public void setUser(User _user) {
        this._user = _user;
    }

    public LoginData getLogin_data() {
        return _login_data;
    }

    public void setLogin_data(LoginData _login_data) {
        this._login_data = _login_data;
    }

    public String getMsg() {
        return _msg;
    }

    public void setMsg(String _msg) {
        this._msg = _msg;
    }

    public boolean isIs_logged() {
        return _is_logged;
    }

    public void setIs_logged(boolean _is_logged) {
        this._is_logged = _is_logged;
    }
    
    
}
