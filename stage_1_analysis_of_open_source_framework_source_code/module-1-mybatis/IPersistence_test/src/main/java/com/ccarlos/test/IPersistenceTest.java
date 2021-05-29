package com.ccarlos.test;

import com.ccarlos.dao.IUserDao;
import com.ccarlos.io.Resources;
import com.ccarlos.pojo.User;
import com.ccarlos.sqlSession.SqlSession;
import com.ccarlos.sqlSession.SqlSessionFactory;
import com.ccarlos.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(2);
        user.setUsername("tom");
        User user2 = sqlSession.selectOne("com.ccarlos.dao.IUserDao.findByCondition", user);

        System.out.println(user2);

        List<User> users = sqlSession.selectList("com.ccarlos.dao.IUserDao.findAll");
        for (User user1 : users) {
            System.out.println(user1);
        }

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }



}
