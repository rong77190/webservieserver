package com.snake.server;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.snake.bean.User;
import com.snake.util.RESTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snake.dao.UserDao;

@Service
@WebService(endpointInterface= "com.snake.server.UserService", serviceName="UserService")
@SOAPBinding(style = Style.RPC)
 public class UserServiceImpl implements UserService {
//    public static String url = "http://119.29.213.224/snake";
   @Autowired
   UserDao dao;
    public List<User> getJavaScore() {
        return dao.allUser();
    }


   public List<User> getAllScore(){
       List<User> userList1 = dao.allUser();
       List<User> userList2 = RESTClient.getPHPScore("http://119.29.213.224/snake");
       userList1.addAll(userList2);
       Collections.sort(userList1);
       return userList1;
   }


    public User getUser(String username) {
        User user=dao.getUserByUserName(username);
        if (user == null){
            user  = new User();
            user.setId(0);
            user.setUserName("");
            user.setScore(0);
            return user;
        }else
            return user;
    }

    public int addUser(String username) {
        User user = new User();
        user.setUserName(username);
        return dao.insertSelective(user);
    }

    public int updateUser(User user) {
        return dao.updateByPrimaryKeySelective(user);
    }


}
