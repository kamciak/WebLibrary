/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import UserPackage.User;
import UserPackage.UserChecker;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;


/**
 *
 * @author Kamciak
 */
public class RegisterController extends SimpleFormController {
    
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }

    
    public RegisterController() {
        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("userRegistrationSuccessView");
        setFormView("userRegistrationView");
    }

    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv;
        User user = (User)command;
        
        if(UserChecker.checkUser(user) && universalService.loginAvailable(user.getPesel())){
            mv = new ModelAndView(getSuccessView());
            mv.addObject("registrationMessage", "Witaj" + user.getName());
            universalService.addUser(user);
        } else{
            String info = "Wprowadz wszystkie dane";
            mv = new ModelAndView("userRegistrationFailureView");
            
            if(!(universalService.loginAvailable(user.getPesel())))
                info = "Użytkownik istnieje w bazie";
            
            if(!(UserChecker.checkPesel(user.getPesel())))
                info = "Niepoprawny numer PESEL";
            
            mv.addObject("errorInfo", info);
            
        }
        return mv;
    }
  
}
