package com.snake.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
 

@XmlRootElement
public class User  implements Comparable<User>{

     //属性：  id---
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //属性：  userName---
     private String userName;

     public String getUserName() {
	      return userName;
     }

     public void setUserName(String  userName) {
	      this. userName = userName;
     }

     private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", score=" + score +
                '}';
    }
    public int compareTo(User o) {
        if (this.score == o.getScore()){
            return this.getUserName().compareTo(o.getUserName());//分数相同按照字母排序
        }else
            return -(this.score-(o.getScore()));//降序
    }
}