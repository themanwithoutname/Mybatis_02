package cn.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itheima.mybatis.dao.UserDaoImpl;
import cn.itheima.mybatis.pojo.User;

public class MybatisDaoTest {
	public SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void before() throws IOException{
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	// 根据用户ID查询
	@Test
	public void testDao(){
		UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(10);
		
		System.out.println(user);
	}
	
	// 根据用户名模糊查询
	@Test
	public void testDao1(){
		UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> users = userDao.findUserByUsername("五");
		
		System.out.println(users);
	}
	
}
