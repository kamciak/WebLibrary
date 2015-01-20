/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import BookPackage.Book;
import DAO.IBookDAO;
import DAO.IUserDAO;
import UserPackage.LoginData;
import UserPackage.LoginWrapper;
import UserPackage.User;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CookieValue;

/**
 *
 * @author Tomek
 */

public class UniversalService {
    IUserDAO userDAO;
    IBookDAO bookDAO;

    public IBookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    public IUserDAO getUserDAO() {
        return userDAO;
    }
    

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
    
    //USER
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    
    public User getUser(User user) {
        if (user != null) {
            //User user = getUser(user);
            return userDAO.getUser(user.getPesel());
        }
        return null;
    }
    
    
    public User getUser(String pesel){
        return userDAO.getUser(pesel);
    }
    
    
    public LoginWrapper login(LoginData login_data){
        User user = getUser(login_data.getPesel());
        LoginWrapper lw = new LoginWrapper(user, login_data);
        lw.check();
        
        return lw;
    }
    
    
    //BOOK
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }
    
    public ArrayList<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }
    
    public ArrayList<Book> getAvailableBooks(){
        return bookDAO.getAvailableBooks();
    }
    
    public Book getBookById(Integer id)
    {
        return bookDAO.getBookById(id);
    }

}
