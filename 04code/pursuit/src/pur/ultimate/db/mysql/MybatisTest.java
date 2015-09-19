package pur.ultimate.db.mysql;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pur.ultimate.action.DformConfigListener;
import pur.ultimate.db.mysql.dao.UserInfoMapper;
import pur.ultimate.db.mysql.model.UserInfo;

public class MybatisTest {
	
	public static void testMySql(){
		try {
			String resource = "config/mybatis-config_mysql.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			Properties properties = new Properties();
			//InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/db.properties");
			InputStream inStream = MybatisTest.class.getResourceAsStream("/properties/db.properties");
			System.out.println(inStream);
			properties.load(inStream);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
//					.build(inputStream);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream, properties);
			SqlSession  sqlSession = sqlSessionFactory.openSession();
			UserInfo  userInfo = new UserInfo();
			userInfo.setId("4");
			userInfo.setUsername("wangjn1130");
			userInfo.setPassord("123456");
			userInfo.setPhoneno("18243049305");
			userInfo.setEmail("wangjn1130@163.com");
			UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
			//sqlSession.insert("pur.ultimate.db.mysql.dao.UserInfoMapper.insert", userInfo);
			userInfoMapper.insert(userInfo);
			sqlSession.commit();
			sqlSession.close();
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public static void testOracle(){
		try {
			String resource = "config/mybatis-config_oracle.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			System.out.println(sqlSessionFactory);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		new DformConfigListener().initlog();
		testMySql();

	}

}
