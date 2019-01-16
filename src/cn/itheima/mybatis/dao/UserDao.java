package cn.itheima.mybatis.dao;

import java.util.List;

import cn.itheima.mybatis.pojo.User;

public interface UserDao { 

	// 根据ID查询用户
	public User selectUserById(Integer id);	
	
	// 根据用户名模糊查询用户列表
	public List<User> findUserByUsername(String username);
	
	// 添加用户
	public int insertUser(User user);	
	
	// 修改用户
	public int updateUserById(User user);	
	
	// 删除用户
	public int deleteUserById(Integer id);

}
