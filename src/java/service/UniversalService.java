/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import DAO.IUserDAO;
import UserPackage.User;

/**
 *
 * @author Tomek
 */

public class UniversalService {
    IUserDAO userDAO;
    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    
    public User getUser(User user) {
        if (user != null) {
            //User user = getUser(user);
            return userDAO.getUser(user.getPesel());
        }
        return null;
    }
    
    /*
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }*/

}
