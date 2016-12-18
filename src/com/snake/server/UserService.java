package com.snake.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.snake.bean.User;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserService {

	//本系统分数
	@WebMethod
	public List<User> getJavaScore();
	//集成后的分数
	@WebMethod
	public List<User> getAllScore();
	//通过用户名获取user
	@WebMethod
	public User getUser(String username);
	//增加user
	@WebMethod
	public int addUser(String username);
	//更新user
	@WebMethod
	public int updateUser(User user);




}
