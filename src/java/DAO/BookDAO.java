/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BookPackage.Book;
import BookPackage.Borrowings;
import BookPackage.Reservation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
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
        true,
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
        String query = "INSERT INTO RESERVATION(USRID, BOOKID, DATE) VALUES(?,?,?)";
        
        jdbcTemplate.update(query, new Object[] {
        userPesel,
        bookId,
        new Date(),
        });
        
        this.setBookAvailable(bookId, Boolean.FALSE);
    }
    
    @Override
    public void borrowBook(String userPesel, Integer bookId){
        String query = "INSERT INTO BORROW(USRID, BOOKID, DATE, DELETED) VALUES(?,?,?,?)";
        
        jdbcTemplate.update(query, new Object[] {
        userPesel,
        bookId,
        new Date(),
        false
        });
            
        //this.setBookAvailable(bookId, Boolean.FALSE);
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
        String query = "UPDATE BORROW set DELETED=true, RETURNDATE = ? WHERE USRID = ? AND BOOKID = ?";
        
        jdbcTemplate.update(query, new Object[] {
        new Date(),
        userPesel,
        bookId,
        });
        
        this.setBookAvailable(bookId, Boolean.TRUE);
    }

    @Override
    public ArrayList<Reservation> getAllReservations(){
       String query = "SELECT * FROM APP.RESERVATION"
                      + " INNER JOIN WL_USER on USRID = USRLOGIN"
                      + " INNER JOIN BOOK on BOOKID = ID ";
       return (ArrayList<Reservation>) jdbcTemplate.query(query, new ReservationMapper(), new Object[]{} );
    }
    
    @Override
    public ArrayList<Reservation> getReservationsByUser(String userPesel){
       String query = "SELECT * FROM APP.RESERVATION"
                        + " INNER JOIN WL_USER on USRID = USRLOGIN"
                        + " INNER JOIN BOOK on BOOKID = ID "
                        + " WHERE USRID = ?";
       return (ArrayList<Reservation>) jdbcTemplate.query(query, new ReservationMapper(), new Object[]{userPesel} );
    }
    
    @Override
    public ArrayList<Borrowings> getAllCurrentBorrowings(){
       String query = "SELECT * FROM APP.BORROW B"
                        + " INNER JOIN WL_USER U on B.USRID = U.USRLOGIN"
                        + " INNER JOIN BOOK BK on B.BOOKID = BK.ID"
                        + " WHERE DELETED=false";
       return (ArrayList<Borrowings>) jdbcTemplate.query(query, new BorrowingsMapper(), new Object[]{} );
    }
    
    @Override
    public ArrayList<Borrowings> getCurrentBorrowingsByUser(String userPesel){
       String query = "SELECT * FROM APP.BORROW B"
                        + " INNER JOIN WL_USER U on B.USRID = U.USRLOGIN"
                        + " INNER JOIN BOOK BK on B.BOOKID = BK.ID"
                        + " WHERE B.USRID = ? AND B.DELETED=false";
       return (ArrayList<Borrowings>) jdbcTemplate.query(query, new BorrowingsMapper(), new Object[]{userPesel} );
    }
    
    @Override
    public ArrayList<Borrowings> getAllBorrowings(){
       String query = "SELECT * FROM APP.BORROW B"
                      + " INNER JOIN WL_USER U on B.USRID = U.USRLOGIN"
                        + " INNER JOIN BOOK BK on B.BOOKID = BK.ID";
       return (ArrayList<Borrowings>) jdbcTemplate.query(query, new BorrowingsMapper(), new Object[]{} );
    }
    
    @Override
    public ArrayList<Borrowings> getBorrowingsByUser(String userPesel){
       String query = "SELECT * FROM APP.BORROW B"
                        + " INNER JOIN WL_USER U on B.USRID = U.USRLOGIN"
                        + " INNER JOIN BOOK BK on B.BOOKID = BK.ID"
                        + " WHERE B.USRID = ?";
       return (ArrayList<Borrowings>) jdbcTemplate.query(query, new BorrowingsMapper(), new Object[]{userPesel} );
    }
    
    @Override
    public ArrayList<Borrowings> getFinishedBorrowingsByUser(String userPesel){
        String query = "SELECT * FROM APP.BORROW B"
                        + " INNER JOIN WL_USER U on B.USRID = U.USRLOGIN"
                        + " INNER JOIN BOOK BK on B.BOOKID = BK.ID"
                        + " WHERE B.USRID = ? AND B.DELETED=true";
        return (ArrayList<Borrowings>) jdbcTemplate.query(query, new BorrowingsMapper(), new Object[]{userPesel} );
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
        resv.setUserPesel( rs.getString("USRID") );
        resv.setBookId( rs.getInt("BOOKID") );
        resv.setBookTitle( rs.getString("TITLE") );
        resv.setAuthor( rs.getString("AUTHOR") );
        resv.setUserName( rs.getString("USRNAME") );
        resv.setDate( rs.getDate("DATE"));
        
        return resv;
      }
    }
    
    protected static final class BorrowingsMapper implements ParameterizedRowMapper
    {
      @Override
      public Borrowings mapRow(ResultSet rs, int rowNum)
      throws SQLException 
      {
        Borrowings resv = new Borrowings();
        resv.setUserPesel(rs.getString("USRID") );
        resv.setBookId(rs.getInt("BOOKID") );
        resv.setBookTitle(rs.getString("TITLE") );
        resv.setAuthor(rs.getString("AUTHOR") );
        resv.setUserName(rs.getString("USRSURNAME") );
        resv.setDate(rs.getDate("DATE"));
        resv.setDeleted(rs.getBoolean("DELETED"));
        resv.setReturnDate(rs.getDate("RETURNDATE"));
        return resv;
      }
    }
}
