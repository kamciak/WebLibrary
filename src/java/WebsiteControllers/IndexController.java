/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import UserPackage.LoginData;
import UserPackage.LoginWrapper;
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
public class IndexController extends SimpleFormController{
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
     public IndexController(){
        setCommandClass(LoginData.class);
        setCommandName("login_data");
        setSuccessView("userIndexFailureView");
        setFormView("index");
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
            request.getSession().setAttribute("userGrants", logged_user.getUser().getAdmin());
            mv.addObject("loginMsg", logged_user.getMsg());
        } else{
            mv.addObject("loginMsg", logged_user.getMsg());
        }
                

        return mv;
    }
}