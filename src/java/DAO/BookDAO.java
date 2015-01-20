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
        String query = "INSERT INTO BOOK (TITLE, AUTHOR, ISBN, BOOKYEAR) "
                + "     VALUES (?,?,?,?)";
        jdbcTemplate.update(query, new Object[] {
        book.getTitle(),
        book.getAuthor(),
        book.getIsbn(),
        book.getYear(),
        
        });
    }
    
    @Override
    public ArrayList<Book> getAllBooks()
    {
       ArrayList<Book> result = new ArrayList<>();  
       String query = "SELECT * FROM APP.BOOK";
       return (ArrayList<Book>) jdbcTemplate.query(query, new BookMapper(), new Object[]{} );
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
        
        return book;
      }
    }
}
