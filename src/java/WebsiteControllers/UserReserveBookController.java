/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.UniversalService;

/**
 *
 * @author kamil
 */
public class UserReserveBookController extends AbstractController{

    private UniversalService universalService;

    public UniversalService getUniversalService() {
        return universalService;
    }

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    @Override
    //@RequestParam("name1") String one, @RequestParam("name2") String two, @RequestParam("name3") String three
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer bookId = Integer.parseInt(request.getParameter("bookid"));
        String userPesel = request.getParameter("userpesel");
        
        System.out.println("" + bookId + " pesel: "+userPesel);
        universalService.borrowBook(userPesel, bookId);
        ModelAndView mv = new ModelAndView("userReserveBookView");
        return mv;
    }
}

/*
@RequestMapping(method=RequestMethod.GET)
    public String dosmth(HttpServletRequest request, @RequestParam("name1") String one, @RequestParam("name2") String two, @RequestParam("name3") String three) {

        JOptionPane.showMessageDialog(null,
                " Param 1 is:" +one +" \n Param 2 is: " +two +" \n Param 3 is: " +three);

        return "redirect:/";
    }
*/
