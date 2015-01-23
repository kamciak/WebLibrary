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
import service.UniversalService;

/**
 *
 * @author Kamil Gzyl
 */
public class UserEditDataController extends SimpleFormController {
    
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    
    public UserEditDataController(){
        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("userEditDataSuccessView");
        setFormView("userEditDataView");
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
        ModelAndView mv=new ModelAndView(getFormView(), "user", errors.getTarget()); 

        String userPesel = (String)request.getSession().getAttribute("userPesel");
        User user = universalService.getUser(userPesel);
        
        mv.addObject("current_user", user);
        return mv;
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv = new ModelAndView(getSuccessView());
        String userPesel = (String)request.getSession().getAttribute("userPesel");
        User user = (User)command;
        
        user.setPesel(userPesel);
        universalService.editUser(user);
        
        return mv;
    }
}