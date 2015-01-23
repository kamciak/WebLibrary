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
 * @author Kamil Gzyl
 */
public class AdminEditBookController extends SimpleFormController {
    
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    
    public AdminEditBookController(){
        setCommandClass(Book.class);
        setCommandName("book");
        setSuccessView("adminEditBookSuccessView");
        setFormView("adminEditBookView");
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
        ModelAndView mv=new ModelAndView(getFormView(), "book", errors.getTarget()); 

        Integer bookId = Integer.parseInt(request.getParameter("bookid"));
        Book book = universalService.getBookById(bookId);
        
        mv.addObject("current_book", book);
        return mv;
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
        ModelAndView mv = new ModelAndView(getSuccessView());
        Integer bookId = Integer.parseInt(request.getParameter("bookid"));
        Book book = (Book)command;
        book.setId(bookId);
        universalService.editBook(book);
        
        return mv;
    }
    
}
