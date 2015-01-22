/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookPackage;

import java.util.Date;

/**
 *
 * @author Tomek
 */
public abstract class OperationBase {
    private Integer _bookId;

    public Integer getBookId() {
        return _bookId;
    }

    public void setBookId(Integer _bookId) {
        this._bookId = _bookId;
    }

    public String getUserPesel() {
        return _userPesel;
    }

    public void setUserPesel(String _userPesel) {
        this._userPesel = _userPesel;
    }

    public String getBookTitle() {
        return _bookTitle;
    }

    public void setBookTitle(String _bookTitle) {
        this._bookTitle = _bookTitle;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String _userName) {
        this._userName = _userName;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String _author) {
        this._author = _author;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date _date) {
        this._date = _date;
    }
    private String _userPesel;
    private String _bookTitle;
    private String _userName;
    private String _author;
    private Date _date;
}
