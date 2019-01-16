package cn.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.mapper.OrderMapper;
import cn.itheima.mybatis.mapper.UserMapper;
import cn.itheima.mybatis.pojo.Order;
import cn.itheima.mybatis.pojo.QueryVo;
import cn.itheima.mybatis.pojo.User;

public class MybatisMapperTest {
	@Test
	public void testMapper() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.findUserById(10);
		System.out.println(user);

	}

	@Test
	public void testMapperQueryVo() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		vo.setUser(new User());
		vo.getUser().setUsername("五");

		List users = userMapper.findUserByQueryVo(vo);
		System.out.println(users);

	}

	@Test
	public void testMapperCountUser() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		Integer countUser = userMapper.countUser();
		System.out.println(countUser);

	}

	@Test
	public void testMapperOrdersList() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		List<Order> orders = orderMapper.selectOrdersList();
		for (Order order : orders)
			System.out.println(order);

	}

	
	@Test
	public void testFindUserBySexAndUsername() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User u = new User();
		//u.setSex("1");
		u.setUsername("张小明");

		List<User> users = userMapper.selectUserBySexAndUsername(u);
		for (User user : users)
			System.out.println(user);
	}

	
	@Test
	public void testFindUserByIds() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		System.out.println("--QueryVo:");
		QueryVo vo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(16);
		ids.add(22);
		ids.add(24);
		vo.setIdsList(ids);
		List<User> users = userMapper.selectUserByIds(vo);
		for (User user : users)
			System.out.println(user);
		
		System.out.println("--Array:");
		Integer[] idsa = new Integer[]{22,16,24};
		List<User> usersa = userMapper.selectUserByIds2(idsa);
		for (User user : usersa)
			System.out.println(user);
		
		System.out.println("--List:");
		List<Integer> idsl = new ArrayList<>();
		idsl.add(24);
		idsl.add(16);
		idsl.add(22);
		List<User> usersl = userMapper.selectUserByIds1(idsl);
		for (User user : usersl)
			System.out.println(user);
	}

}
