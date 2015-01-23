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
public class AdminEditUserController extends SimpleFormController {
    
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    
    public AdminEditUserController(){
        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("adminEditUserSuccessView");
        setFormView("adminEditUserView");
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
        ModelAndView mv=new ModelAndView(getFormView(), "user", errors.getTarget()); 

        String userPesel = request.getParameter("userpesel");
        User user = universalService.getUser(userPesel);
        
        mv.addObject("current_user", user);
        return mv;
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv = new ModelAndView(getSuccessView());
        String userPesel = request.getParameter("userpesel");
        User user = (User)command;
        try{
            String admingrants = request.getParameter("admingrants");
            System.out.println("Granty: " + admingrants);
            if(admingrants!=null)
                user.setAdmin(Boolean.TRUE);

        }
        catch(NullPointerException ex){
            user.setAdmin(Boolean.FALSE);
        }
        
        user.setPesel(userPesel);
        universalService.editUser(user);
        
        return mv;
    }
}
