/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BookPackage.Book;
import BookPackage.Reservation;
import UserPackage.InvalidDataException;
import UserPackage.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author Tomek
 */
public class BookDAO implements IBookDAO {
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addBook(Book book)
    {
        String query = "INSERT INTO BOOK (TITLE, AUTHOR, ISBN, BOOKYEAR, AVAILABLE) "
                + "     VALUES (?,?,?,?,?)";
        jdbcTemplate.update(query, new Object[] {
        book.getTitle(),
        book.getAuthor(),
        book.getIsbn(),
        book.getYear(),
        book.getAvailable(),
        });
    }
    
    @Override
    public void editBook(Book book){
        String query = "update BOOK set TITLE = ?, AUTHOR=?, ISBN=?, BOOKYEAR=?"
               + " WHERE ID=?";
       
        jdbcTemplate.update(query, new Object[] {
        book.getTitle(),
        book.getAuthor(),
        book.getIsbn(),
        book.getYear(),
        book.getId(),
        });
    }
    
    @Override
    public void removeBookById(Integer bookId){
        String DELETE = " DELETE FROM BOOK WHERE ID=?";
        jdbcTemplate.update(DELETE, bookId);
    }
    
    @Override
    public ArrayList<Book> getAllBooks()
    {
       String query = "SELECT * FROM APP.BOOK";
       return (ArrayList<Book>) jdbcTemplate.query(query, new BookMapper(), new Object[]{} );
    }
    
    @Override
    public ArrayList<Book> getAvailableBooks()
    {
       String query = "SELECT * FROM APP.BOOK WHERE AVAILABLE=true";
       return (ArrayList<Book>) jdbcTemplate.query(query, new BookMapper(), new Object[]{} );
    }
    
    @Override
    public Book getBookById(Integer id)
    {
       String query = "SELECT * FROM APP.BOOK WHERE ID =?";
       return (Book)jdbcTemplate.queryForObject(query, new BookMapper(), id);
       //SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
       //return (Book)jdbcTemplate.queryForObject(query, new BookMapper(), namedParameters);
    }
    
    @Override
    public void reserveBook(String userPesel, Integer bookId){
        String query = "INSERT INTO RESERVATION(USRID, BOOKID) VALUES(?,?)";
        
        jdbcTemplate.update(query, new Object[] {
        userPesel,
        bookId,
        });
        
        this.setBookAvailable(bookId, Boolean.FALSE);
    }
    
    @Override
    public void borrowBook(String userPesel, Integer bookId){
        String query = "INSERT INTO BORROW(USRID, BOOKID, DELETED) VALUES(?,?, false)";
        
        jdbcTemplate.update(query, new Object[] {
        userPesel,
        bookId,
        });
        
        this.removeReservationWithoutAvailability(userPesel, bookId);
    }
    
    private void removeReservationWithoutAvailability(String userPesel, Integer bookId){
        String query = "DELETE FROM RESERVATION WHERE USRID=? AND BOOKID=?";
        
        jdbcTemplate.update(query, new Object[] {
        userPesel,
        bookId,
        });
    }
    
    @Override
    public void removeReservation(String userPesel, Integer bookId){
        this.removeReservationWithoutAvailability(userPesel, bookId);
        this.setBookAvailable(bookId, Boolean.TRUE);
    }
    
    @Override
    public void setBookAvailable(Integer bookId, Boolean available)
    {
        String query = "UPDATE BOOK set AVAILABLE=? WHERE ID = ?";
        
        jdbcTemplate.update(query, new Object[] {
        available,
        bookId,
        });
    }
    
    @Override
    public void removeBorrowings(String userPesel, Integer bookId)
    {
        String query = "UPDATE BORROW set DELETED=true WHERE USRID = ? AND BOOKID = ?";
        
        jdbcTemplate.update(query, new Object[] {
        userPesel,
        bookId,
        });
        
        this.setBookAvailable(bookId, Boolean.TRUE);
    }

    @Override
    public ArrayList<Reservation> getAllReservations(){
       String query = "SELECT * FROM APP.RESERVATION";
       return (ArrayList<Reservation>) jdbcTemplate.query(query, new ReservationMapper(), new Object[]{} );
    }
    
    @Override
    public ArrayList<Reservation> getReservationsByUser(String userPesel){
       String query = "SELECT * FROM APP.RESERVATION WHERE USRID = ?";
       return (ArrayList<Reservation>) jdbcTemplate.query(query, new ReservationMapper(), new Object[]{userPesel} );
    }
    
    
    
    
     
    protected static final class BookMapper implements ParameterizedRowMapper
    {
      @Override
      public Book mapRow(ResultSet rs, int rowNum)
      throws SQLException 
      {
        Book book = new Book();
        book.setId( rs.getInt("ID") );
        book.setTitle(rs.getString("TITLE"));
        book.setAuthor(rs.getString("AUTHOR"));
        book.setIsbn(rs.getString("ISBN"));
        book.setYear(rs.getInt("BOOKYEAR"));
        book.setAvailable(rs.getBoolean("AVAILABLE"));
        
        return book;
      }
    }
    
    protected static final class ReservationMapper implements ParameterizedRowMapper
    {
      @Override
      public Reservation mapRow(ResultSet rs, int rowNum)
      throws SQLException 
      {
        Reservation resv = new Reservation();
        resv.setUserPesel(rs.getString("USRID") );
        resv.setBookId(rs.getInt("BOOKID") );
        
        return resv;
      }
    }
}
