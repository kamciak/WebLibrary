/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import UserPackage.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.UniversalService;

/**
 *
 * @author Kamciak
 */
public class AdminShowUsersController  extends AbstractController{
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("adminShowUsersView");
        List<User> listOfUsers = universalService.getAllUsers();
        for(User user : listOfUsers){
           System.out.println(user.getName());
        }
    
        mv.addObject("listOfUsers",listOfUsers);
        
        return mv;
        
    }
}
