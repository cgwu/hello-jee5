package com.cg.mybatis3.dao;

import java.util.List;

import com.cg.mybatis3.model.User;

public class UserMyBatis3Service {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void showCount(){
		int cnt = userDao.count();
		System.out.println(cnt);
	}
	
	public void listUsers(){
		List<User> list =  userDao.findAll();
		for (User user : list) {
			System.out.println(user.getUsername());
			System.out.println(user.getBalance());
			System.out.println(user.getBirthday());
		}
		
		System.out.println("---------使用自动映射------------");
		
		list =  userDao.findAllByHalfAutoMap();
		for (User user : list) {
			System.out.println(user.getUsername());
			System.out.println(user.getBalance());
			System.out.println(user.getBirthday());
		}
	}
	
	
	public void showUser(){
		System.out.println("按用户名查找特定用户:");
		User user = userDao.findByName("张三");
		System.out.println(user.getUsername());
		System.out.println(user.getBalance());
		System.out.println(user.getBirthday());
	}
	
}
