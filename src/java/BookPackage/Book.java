/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookPackage;

/**
 *
 * @author Tomek
 */
public class Book {
    public Book(){}
    public Book(Integer id, String title, String author, String isbn, int year)
    {
        this._id = id;
        this._title = title;
        this._author = author;
        this._isbn = isbn;
        this._year = year;
    }
    

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String _author) {
        this._author = _author;
    }

    public String getIsbn() {
        return _isbn;
    }

    public void setIsbn(String _isbn) {
        this._isbn = _isbn;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int _year) {
        this._year = _year;
    }
    
    private Integer _id;
    private String _title;
    private String _author;
    private String _isbn;
    private Integer _year;
}