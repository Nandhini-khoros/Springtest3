package com.example.Springtest3.dao;
import com.example.Springtest3.model.User;
        import java.sql.SQLException;
        import java.util.List;


public interface UserDao  {
    List<User> getUsers() throws SQLException;

    List<User> getUser(int id) throws SQLException;


    void insertUser(User user) throws SQLException;


    void updateUser(User user, int id) throws SQLException;


     String deleteUser(int id) throws SQLException;


}
