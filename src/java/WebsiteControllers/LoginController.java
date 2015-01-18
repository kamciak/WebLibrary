/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import UserPackage.LoginData;
import UserPackage.LoginWrapper;
import javax.inject.Scope;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;

/**
 *
 * @author Kamciak
 */

public class LoginController extends SimpleFormController{
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    
    public LoginController(){
        setCommandClass(LoginData.class);
        setCommandName("login_data");
        setSuccessView("userLoginSuccessView");
        setFormView("userLoginView");
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv = new ModelAndView(getSuccessView());
        LoginData login_data = (LoginData)command;
        
        LoginWrapper logged_user =  universalService.login(login_data);
        
        mv.addObject("loginMessage", logged_user.getMsg());
        if(logged_user.isIs_logged()){
            mv.addObject("loggedUser", logged_user.getUser().getName());
            String pesel = logged_user.getUser().getPesel();
            request.getSession().setAttribute("userPesel", pesel);
            
            //Cookie cookie = new Cookie("user_pesel", pesel);
            //response.addCookie(cookie);
       
            
        }
        
        
        
        return mv;
    }
}
    /*
    
    protected ModelAndView
onSubmit(
HttpServletRequest request,
HttpServletResponse response,
Object command,
BindException errors) throws Exception {
User user = (User)command;
LoginWrapper loginWrapper = universalService.logIn(user);
Person person = loginWrapper.getPerson();
Mode
lAndView mv = new ModelAndView(getSuccessView());
if (person == null) {
mv.addObject("welcomeMessage", loginWrapper.getMessage());
} else {
mv.addObject("welcomeMessage", universalService.personWelcome(person));
}
    
}
*/