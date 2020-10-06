package com.example.Springtest3.dao;
import com.example.Springtest3.model.User;

        import java.sql.*;
        import java.sql.DriverManager;
        import java.util.*;
        import java.util.List;

public class UserDaoClass implements UserDao{

    List<User> users = new ArrayList<>();

    Connection conc;

    {

        try {

            conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "Nandhini", "Nandhini@4");

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }

    public List<User> getUsers() throws SQLException {

        Statement stat= conc.createStatement();

        ResultSet res=stat.executeQuery(" select *  from user;");

        while(res.next()) {

            User user = new User();

            user.setId(res.getInt("id"));

            user.setName(res.getString("name"));

            user.setAge(res.getInt("age"));

            //user.setEmail(res.getString("email"));

            //user.setCountry(res.getString("country"));

            users.add(user);

        }

        return users;

    }
    public List<User> getUser(int id) throws SQLException {

        PreparedStatement stat = conc.prepareStatement("select * from user where id= ?");

        stat.setInt(1, id);

        ResultSet res = stat.executeQuery();

        while (res.next()) {

            User user = new User();

            user.setId(res.getInt("id"));

            user.setName(res.getString("name"));

            user.setAge(res.getInt("age"));

            //user.setEmail(res.getString("email"));

           // user.setCountry(res.getString("country"));

            users.add(user);

        }

        return users;

    }
    public void insertUser(User user) throws SQLException {

        PreparedStatement stat = conc.prepareStatement("insert into user (id,name,age) values(?,?,?)");

        stat.setInt(1, user.getId());

        stat.setString(2,user.getName());

        stat.setInt(3,user.getAge());

        //stat.setString(4,user.getEmail());

        //stat.setString(5,user.getCountry());

        stat.executeUpdate();
    }

    public void updateUser(User user, /*String*/int id) throws SQLException {

        PreparedStatement stat = conc.prepareStatement(" UPDATE user SET name = ?,age = ? WHERE id = ?;");

        stat.setString(1,user.getName());

        stat.setInt(2,user.getAge());

        //stat.setString(3,user.getEmail());

        //.setString(4,user.getCountry());

        //stat.setInt(2, Integer.parseInt(id));
        stat.setInt(5,id);

        stat.executeUpdate();

    }

    public String deleteUser(int id) throws SQLException {

        PreparedStatement stat = conc.prepareStatement("delete from user where id= ?;");

        stat.setInt(1, id);

        /*int res=*/stat.executeUpdate();

        return "deleted";

    }

}
