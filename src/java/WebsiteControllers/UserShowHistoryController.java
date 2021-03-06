/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import BookPackage.Borrowings;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.UniversalService;

/**
 *
 * @author Kamil Gzyl
 */
public class UserShowHistoryController extends AbstractController{
    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("userShowHistoryView");
        String userPesel = (String)request.getSession().getAttribute("userPesel");
        List<Borrowings> historyList = universalService.getFinishedBorrowingsByUser(userPesel);
        mv.addObject("historyList",historyList);
        
        return mv;
    }
}