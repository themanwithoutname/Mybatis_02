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

public class MybatisMapperTest2 {
	//一对一映射
	@Test
	public void testOneToOne() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		List<Order> orders = orderMapper.selectOrders();
		for (Order order : orders)
			System.out.println(order);
	}

	//一对一映射
	@Test
	public void testOneToMany() throws Exception {
		// 加载SqlMapConfig.xml配置文件
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession帮助我们生成一个实现类（要给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		List<User> users = userMapper.selectUserOneToMany();
		System.out.println(users.size());
		for (User user : users)
			System.out.println(user);
	}

}
