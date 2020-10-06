package com.example.Springtest3.controller;
import com.example.Springtest3.dao.UserDao;
import com.example.Springtest3.dao.UserDaoClass;
import com.example.Springtest3.model.User;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
//RequestMapping(value="/users")
public class UserController {

    UserDao userdao;


    public UserController() {

        userdao = new UserDaoClass();

    }

    @RequestMapping(value = "/getall")
    public String getall() throws SQLException {

        return userdao.getUsers().toString();

    }

    @GetMapping(value = "/getone/{id}")

    public String getone(@PathVariable int id) throws SQLException {

        return userdao.getUser(id).toString();

    }

    @PostMapping(value = "/post")

    public void create(@RequestBody User user) throws SQLException {

        userdao.insertUser(user);

    }

    @PutMapping(value = "/update/{id}")

    public void update(@RequestBody User user, @PathVariable int id) throws SQLException {

        userdao.updateUser(user, id);

    }

    @DeleteMapping(value = "/delete/{id}")

    public String delete(@PathVariable int id) throws SQLException {

        return userdao.deleteUser(id);

    }
}
