/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BookPackage.Book;
import BookPackage.Borrowings;
import BookPackage.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomek
 */
public interface IBookDAO {
    void addBook(Book book);
    void removeBookById(Integer bookId);
    void editBook(Book book);
    ArrayList<Book> getAllBooks();
    ArrayList<Book> getAvailableBooks();
    Book getBookById(Integer id);
    
    void reserveBook(String userPesel, Integer bookId);
    void removeReservation(String userPesel, Integer bookId);
    void borrowBook(String userPesel, Integer bookId);
    void removeBorrowings(String userPesel, Integer bookId);
    void setBookAvailable(Integer bookId, Boolean available);
    
    ArrayList<Reservation> getAllReservations();
    ArrayList<Reservation> getReservationsByUser(String userPesel);
    
    ArrayList<Borrowings> getAllCurrentBorrowings();
    ArrayList<Borrowings> getCurrentBorrowingsByUser(String userPesel);
    
    ArrayList<Borrowings> getAllBorrowings();
    ArrayList<Borrowings> getBorrowingsByUser(String userPesel);
    ArrayList<Borrowings> getFinishedBorrowingsByUser(String userPesel);
}
