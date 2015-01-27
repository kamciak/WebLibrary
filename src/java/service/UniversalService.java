/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import BookPackage.Book;
import BookPackage.Borrowings;
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

/**
 * Klasa odpowiedzialna za wartstwę pośredniczącą pomiędzy kontrolerami i bazą danych
 * @author Kamciak
 */
public class UniversalService {
    IUserDAO userDAO;
    IBookDAO bookDAO;

    /**
     * 
     * @return Obiekt bazodanowy książki
     */
    public IBookDAO getBookDAO() {
        return bookDAO;
    }
    /**
     * Setter obiektu bazodanowego książki
     * @param bookDAO 
     */
    public void setBookDAO(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    /**
     *
     * @return Obiekt bazodanowy użytkownika
     */
    public IUserDAO getUserDAO() {
        return userDAO;
    }
    
    /**
     * Setter obiektu bazodanowego użytkownika
     * @param userDAO Obiekt bazodanowy użytkownika
     */
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
    

    /**
     * Dodanie użytkownika do bazy
     * @param user Obiekt użytkownika
     */
        public void addUser(User user) {
        userDAO.addUser(user);
    }
    
    /**
     * Edycja użytkownika w bazie
     * @param user Obiekt użytkownika
     */
    public void editUser(User user){
        userDAO.editUser(user);
    }
    
    /**
     * Usunięcie użytkownika z bazy o zadanym numerze PESEL
     * @param userPesel
     */
    public void removeUserByPesel(String userPesel){
        userDAO.removeUserByPesel(userPesel);
    }
    
    
    /**
     * Pobranie użytkownika z bazy po numerze PESEL
     * @param pesel Pesel użytkownika
     * @return Obiekt użytkownika
     */
    public User getUser(String pesel){
        return userDAO.getUser(pesel);
    }
    
    /**
     * Pobranie wszystkich użytkowników z bazy
     * @return Lista użytkowników
     */
    public ArrayList<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
    
    /**
     * Sprawdzenie czy użytkownik o danym numerze PESEL istnieje w bazie
     * @param userPesel Pesel użytkownika
     * @return Zwraca true jezeli użytkownika nie ma w bazie, w przeciwnym wypadku false
     */
    public Boolean loginAvailable(String userPesel){
        return userDAO.loginAvailable(userPesel);
    }
    
    /**
     * Metoda logowania
     * @param login_data Dane logowania
     * @return Wrapper logowania
     */
    public LoginWrapper login(LoginData login_data){
        User user = getUser(login_data.getPesel());
        LoginWrapper lw = new LoginWrapper(user, login_data);
        lw.check();
        
        return lw;
    }
    
    
    //BOOK

    /**
     * Dodanie książki do bazy
     * @param book Obiekt książki
     */
        public void addBook(Book book) {
        bookDAO.addBook(book);
    }
    
    /**
     * Edycja książki 
     * @param book Obiekt książki
     */
    public void editBook(Book book) {
        bookDAO.editBook(book);
    }
    
    /**
     * Usunięcie książki po ID
     * @param bookId
     */
    public void removeBookById(int bookId){
        bookDAO.removeBookById(bookId);
    }
    
    /**
     * Pobranie wszystkich książek z bazy
     * @return Lista książek
     */
    public ArrayList<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }
    
    /**
     * Pobranie wszystkich dostępnych książek z bazy
     * @return Lista książek
     */
    public ArrayList<Book> getAvailableBooks(){
        return bookDAO.getAvailableBooks();
    }
    
    /**
     * Pobranie książki po ID
     * @param id ID książki
     * @return Obiekt książki
     */
    public Book getBookById(Integer id)
    {
        return bookDAO.getBookById(id);
    }
    
    /**
     * Rezerwacja książki
     * @param userPesel Pesel osoby rezerwującej
     * @param bookId ID rezerwowanej książki
     */
    public void reserveBook(String userPesel, Integer bookId){
        bookDAO.reserveBook(userPesel, bookId);
    }
    
    /**
     * Wypożyczenie książki
     * @param userPesel Pesel osoby wypożyczającej
     * @param bookId ID wypożyczanej książki
     */
    public void borrowBook(String userPesel, Integer bookId){
        bookDAO.borrowBook(userPesel, bookId);
    }
    
    /**
     * Zmiana statusu dostępności książki
     * @param bookId ID książki
     * @param available true jeżeli ksiązka ma być dostępna, false w przeciwnym przypadku
     */
    public void setBookAvailable(Integer bookId, Boolean available){
        bookDAO.setBookAvailable(bookId, available);
    }
    
    /**
     * Usunięcie wypożyczenia 
     * @param userPesel Pesel użytkownika
     * @param bookId ID książki
     */
    public void removeBorrowings(String userPesel, Integer bookId){
        bookDAO.removeBorrowings(userPesel, bookId);
    }
    
    /**
     * Usunięcie rezerwacji
     * @param userPesel Pesel użytkownika
     * @param bookId ID książki
     */
    public void removeReservation(String userPesel, Integer bookId){
        bookDAO.removeReservation(userPesel, bookId);
    }
    
    /**
     * Pobranie wszystkich rezerwacji
     * @return Lista rezerwacji
     */
    public ArrayList<Reservation> getAllReservations(){
        return bookDAO.getAllReservations();
    }
    
    /**
     * Rezerwacje użytkownika
     * @param userPesel Pesel użytkownika
     * @return Lista rezerwacji użytkownika
     */
    public ArrayList<Reservation> getReservationsByUser(String userPesel){
        return bookDAO.getReservationsByUser(userPesel);
    }
    
    /**
     * Pobieranie wszystkich wypożyczeń
     * @return Lista wypożyczeń
     */
    public ArrayList<Borrowings> getAllCurrentBorrowings(){
        return bookDAO.getAllCurrentBorrowings();
    }
    
    /**
     * Pobieranie wypożyczen danego użytkownika
     * @param userPesel Pesel użytkownika
     * @return Lista wypożyczeń użytkownika
     */
    public ArrayList<Borrowings> getCurrentBorrowingsByUser(String userPesel){
        return bookDAO.getCurrentBorrowingsByUser(userPesel);
    }
    
    /**
     * Pobranie wszystkich aktualnych wypożyczeń
     * @return Lista aktualnych wypożyczeń
     */
    public ArrayList<Borrowings> getAllBorrowings(){
        return bookDAO.getAllCurrentBorrowings();
    }
    
    /**
     * Pobieranie wypożyczenia użytkownika
     * @param userPesel Pesel użytkownika
     * @return Lista wypożyczeń użytkownika
     */
    public ArrayList<Borrowings> getBorrowingsByUser(String userPesel){
        return bookDAO.getCurrentBorrowingsByUser(userPesel);
    }
    
    /**
     * Pobieranie zakończonych wypożyczeń użytkownika 
     * @param userPesel Pesel użytkownika
     * @return Lista zakończonych wypożyczeń
     */
    public ArrayList<Borrowings> getFinishedBorrowingsByUser(String userPesel){
        return bookDAO.getFinishedBorrowingsByUser(userPesel);
    }

}
