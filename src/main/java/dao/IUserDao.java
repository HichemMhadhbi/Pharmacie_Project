package dao;

import metier.entities.User;

public interface IUserDao {
    public void insertUser(String username, String password);
    public boolean checkCredentials(String username, String password);
}
