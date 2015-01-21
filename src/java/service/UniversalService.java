/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import BookPackage.Book;
import BookPackage.Reservation;
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
    
    public void editUser(User user){
        userDAO.editUser(user);
    }
    
    public void removeUserByPesel(String userPesel){
        userDAO.removeUserByPesel(userPesel);
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
    
    
    public ArrayList<User> getAllUsers(){
        return userDAO.getAllUsers();
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
    
     public void editBook(Book book) {
        bookDAO.editBook(book);
    }
    
    public void removeBookById(int bookId){
        bookDAO.removeBookById(bookId);
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
    
    public void reserveBook(String userPesel, Integer bookId){
        bookDAO.reserveBook(userPesel, bookId);
    }
    
    public void borrowBook(String userPesel, Integer bookId){
        bookDAO.borrowBook(userPesel, bookId);
    }
    
    public void setBookAvailable(Integer bookId, Boolean available){
        bookDAO.setBookAvailable(bookId, available);
    }
    
    public void removeBorrowings(String userPesel, Integer bookId){
        bookDAO.removeBorrowings(userPesel, bookId);
    }
    
    public void removeReservation(String userPesel, Integer bookId){
        bookDAO.removeReservation(userPesel, bookId);
    }
    
    public ArrayList<Reservation> getAllReservations(){
        return bookDAO.getAllReservations();
    }
    
    public ArrayList<Reservation> getReservationsByUser(String userPesel){
        return bookDAO.getReservationsByUser(userPesel);
    }

}
