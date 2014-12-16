/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import UserPackage.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Kamciak
 */
public class RegisterController extends SimpleFormController {
    
    public RegisterController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("userRegistrationSuccesView");
        setFormView("userRegistrationView");
    }

    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv = new ModelAndView(getSuccessView());
        User user = (User)command;
        mv.addObject("registrationMessage", "Witaj" + user.getName());
        return mv;
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
     ModelAndView mv = new ModelAndView(getSuccessView());
     //Do something...
     return mv;
     }
     */
}
