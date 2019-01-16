package cn.itheima.mybatis.dao;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	// 注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	// 根据ID查询用户
	public User selectUserById(Integer id) {
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = sqlSession.selectOne("test.findUserById", id);

		// 释放资源
		sqlSession.close();
		
		return user;
	}

	// 根据用户名模糊查询用户列表
	public List<User> findUserByUsername(String username) {
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		List<User> users = sqlSession.selectList("test.findUserByUsername", username);

		// 释放资源
		sqlSession.close();
		return users;
	}

	// 添加用户
	public int insertUser(User user) {
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象执行插入
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		int n = sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();

		// 释放资源
		sqlSession.close();
		
		return n;
	}

	// 修改用户
	public int updateUserById(User user) {
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象执行插入
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		int n = sqlSession.update("test.updateUserById", user);
		
		sqlSession.commit();

		// 释放资源
		sqlSession.close();
		
		return n;
	}

	// 删除用户
	public int deleteUserById(Integer id){
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象
		int n = sqlSession.delete("test.deleteUserById", id);
		
		sqlSession.commit();

		// 释放资源
		sqlSession.close();
		
		return n;
	}

}
