/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UserPackage.InvalidDataException;
import UserPackage.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tomek
 */
public class UserDAO  implements IUserDAO {
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addUser(User user) {
        String query = "INSERT INTO WL_USER (USRLOGIN, USRPASSWORD, USRNAME, USRSURNAME, USRCOUNTRY, USRCITY, USRSTREET, USRPOSTCODE, USRPHONE, USRISADMIN) "
                + "     VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query, new Object[] {
        user.getPesel(),
        user.getPassword(),
        user.getName(),
        user.getSurename(),
        user.getCountry(),
        user.getCity(),
        user.getStreet(),
        user.getPost_code(),
        user.getPhone_number(),
        user.getAdmin(),
        });
    }
    
    @Override
    public User getUser(String userLogin) {
    String query = "SELECT * FROM APP.WL_USER WHERE USRLOGIN=?";
    User user = null;
    try {
        user = (User)jdbcTemplate.queryForObject(query, new Object[] {
        userLogin},
        new RowMapper() {
        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            try {
                return new User(
                        rs.getString("USRNAME"),
                        rs.getString("USRSURNAME"),
                        rs.getString("USRLOGIN"),
                        rs.getString("USRPASSWORD"),
                        rs.getString("USRCOUNTRY"),
                        rs.getString("USRCITY"),
                        rs.getString("USRPOSTCODE"),
                        rs.getString("USRSTREET"),
                        rs.getString("USRPHONE"),
                        rs.getBoolean("USRISADMIN")
                );  } catch (InvalidDataException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
    }
    });
    } catch (Exception ex) {
        System.out.println("Could not get User form database for login [" +
        userLogin +"]");
    }
    return user;
    }
}
