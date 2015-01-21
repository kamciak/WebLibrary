/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import BookPackage.Book;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.UniversalService;

/**
 *
 * @author Kamciak
 */
public class AdminDeleteBookController extends AbstractController{

    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Integer bookId = (Integer)request.getSession().getAttribute("bookid");
        Integer bookId = Integer.parseInt(request.getParameter("bookid"));
        //System.out.println();
        universalService.removeBookById(bookId);
        
        ModelAndView mv = new ModelAndView("adminDeleteBookView");
        return mv;
    }

    
}
