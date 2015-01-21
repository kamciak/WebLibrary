/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UserPackage.User;
import java.util.ArrayList;

/**
 *
 * @author Tomek
 */
public interface IUserDAO {
    void addUser(User user);
    User getUser(String userLogin);
    //ArrayList<User> getAllUsers();
}
