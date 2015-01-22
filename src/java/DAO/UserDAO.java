/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import UserPackage.InvalidDataException;
import UserPackage.InvalidPeselException;
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
public class UserDAO implements IUserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO WL_USER (USRLOGIN, USRPASSWORD, USRNAME, USRSURNAME, USRCOUNTRY, USRCITY, USRSTREET, USRPOSTCODE, USRPHONE, USRISADMIN) "
                + "     VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query, new Object[]{
            user.getPesel(),
            user.getPassword(),
            user.getName(),
            user.getSurename(),
            user.getCountry(),
            user.getCity(),
            user.getStreet(),
            user.getPost_code(),
            user.getPhone_number(),
            false,});
    }

    @Override
    public void editUser(User user){
        String query = "update WL_USER set USRLOGIN = ?, USRNAME=?, USRSURNAME=?, USRCOUNTRY=?, USRPASSWORD=?, USRCITY=?, USRPOSTCODE=?, USRSTREET=?, USRPHONE=?, USRISADMIN=?"
               + " WHERE USRLOGIN=?";
       
        jdbcTemplate.update(query, new Object[] {
            user.getPesel(),
            user.getName(),
            user.getSurename(),
            user.getCountry(),
            user.getPassword(),
            user.getCity(),
            user.getPost_code(),
            user.getStreet(),
            user.getPhone_number(),
            user.getAdmin(),
            user.getPesel()});

    }
    
    @Override
    public User getUser(String userLogin) {
        String query = "SELECT * FROM APP.WL_USER WHERE USRLOGIN=?";
        User user = null;
        try {
            user = (User) jdbcTemplate.queryForObject(query, new UserMapper(), new Object[]{userLogin});
        } catch (Exception ex) {
            System.out.println("Could not get User form database for login ["
                    + userLogin + "]");
        }
        return user;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        String query = "SELECT * FROM APP.WL_USER";
        return (ArrayList<User>) jdbcTemplate.query(query, new UserMapper(), new Object[]{});
    }

    
    @Override
    public void removeUserByPesel(String userPesel){
        String DELETE = " DELETE FROM WL_USER WHERE USRLOGIN=?";
        jdbcTemplate.update(DELETE, userPesel);
    }
    
    
    protected static final class UserMapper implements ParameterizedRowMapper {

        @Override
        public User mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            User user = new User();
            user.setName(rs.getString("USRNAME"));
            user.setSurename(rs.getString("USRSURNAME"));
            try {
                user.setPesel(rs.getString("USRLOGIN"));
            } catch (InvalidPeselException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            user.setPassword(rs.getString("USRPASSWORD"));
            user.setCountry(rs.getString("USRCOUNTRY"));
            user.setCity(rs.getString("USRCITY"));
            user.setPost_code(rs.getString("USRPOSTCODE"));
            user.setStreet(rs.getString("USRSTREET"));
            user.setPhone_number(rs.getString("USRPHONE"));
            user.setAdmin(rs.getBoolean("USRISADMIN"));

            return user;
        }
    }
}
