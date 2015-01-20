/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import UserPackage.ContactData;
import UserPackage.LoginData;
import UserPackage.LoginWrapper;
import UserPackage.MainData;
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
public class MainController extends SimpleFormController{
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    public MainController(){
        setCommandClass(MainData.class);
        setCommandName("mainData");
        setSuccessView("footer");
        setFormView("userMainView");
        
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        System.out.println("Main onSubmit");
        ModelAndView mv = new ModelAndView(getSuccessView());
        request.getSession().setAttribute("userPesel", null);
        return mv;
    }
}
