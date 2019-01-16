package cn.itheima.mybatis.junit;

import java.util.Date;
import java.util.List;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.pojo.User;

public class MyBatisFirstTest {
	// 根据ID查询用户
	@Test
	public void testMybatis() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = sqlSession.selectOne("test.findUserById", 1);

		// 6. 打印结果
		System.out.println(user);

		// 7. 释放资源
		sqlSession.close();
	}

	// 根据用户名模糊查询用户列表
	@Test
	public void testFindUserByUsername() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		List<User> users = sqlSession.selectList("test.findUserByUsername", "五");

		// 6. 打印结果
		for (User user : users) {
			System.out.println(user);
		}

		// 7. 释放资源
		sqlSession.close();
	}

	// 添加用户
	@Test
	public void testInsertUser() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象执行插入
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = new User();
		user.setUsername("何炅");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("bj");
		int n = sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();

		// 6. 打印结果
		System.out.println(n);
		System.out.println(user);

		// 7. 释放资源
		sqlSession.close();
	}

	// 修改用户
	@Test
	public void testUpdateUserById() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象执行插入
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = new User();
		user.setId(31);
		user.setUsername("何炅22");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("bj22");
		int n = sqlSession.insert("test.updateUserById", user);
		
		sqlSession.commit();

		// 6. 打印结果
		System.out.println(n);
		System.out.println(user);

		// 7. 释放资源
		sqlSession.close();
	}

	// 删除用户
	@Test
	public void testDeleteUserById() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行SqlSession对象
		int n = sqlSession.insert("test.deleteUserById", 30);
		
		sqlSession.commit();

		// 6. 打印结果
		System.out.println(n);

		// 7. 释放资源
		sqlSession.close();
	}
	
}
