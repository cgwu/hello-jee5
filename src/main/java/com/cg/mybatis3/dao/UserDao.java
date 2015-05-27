package com.cg.mybatis3.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cg.mybatis3.model.User;

public class UserDao extends SqlSessionDaoSupport {

	public int count() {
		return this.getSqlSession().selectOne("USER.count");
	}

	public List<User> findAll() {
		return this.getSqlSession().selectList("USER.findAll");
	}

	public List<User> findAllByHalfAutoMap() {
		return this.getSqlSession().selectList("USER.findAllByHalfAutoMap");
	}

	public User findByName(String name) {
		return this.getSqlSession().selectOne("USER.findByName", name);
	}
}
