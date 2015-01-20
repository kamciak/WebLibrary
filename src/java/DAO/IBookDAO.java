/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BookPackage.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomek
 */
public interface IBookDAO {
    void addBook(Book book);
    ArrayList<Book> getAllBooks();
}
