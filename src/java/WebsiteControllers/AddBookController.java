/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import BookPackage.Book;
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
public class AddBookController extends SimpleFormController{
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    public AddBookController(){
        setCommandClass(Book.class);
        setCommandName("book_data");
        setSuccessView("addBookSuccessView");
        setFormView("addBookView");
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv = new ModelAndView(getSuccessView());
        Book book_data = (Book)command;
        
        universalService.addBook(book_data);
        mv.addObject("addBookMessage", "Dodano ksiazke");

        return mv;
    }
}
