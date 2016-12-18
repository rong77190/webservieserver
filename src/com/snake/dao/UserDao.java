package com.snake.dao;
import java.util.List;
import com.snake.bean.User;
import com.snake.bean.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

	 //获取所有
	 public List<User> allUser();

	 //获取一个用户
	 public  User  user(int  id);


	//通过用户名获取User
	public User getUserByUserName(@Param("userName")String userName);

	//创建一个用户
	public int addUser(@Param("userName")String userName);

	//更新
	int updateByPrimaryKeySelective(User record);

	//插入
	int insertSelective(User record);
}
