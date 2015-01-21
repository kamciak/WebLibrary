/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BookPackage.Book;
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
       String query = "SELECT * FROM APP.BOOK WHERE AVAILABLE=1";
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
}
