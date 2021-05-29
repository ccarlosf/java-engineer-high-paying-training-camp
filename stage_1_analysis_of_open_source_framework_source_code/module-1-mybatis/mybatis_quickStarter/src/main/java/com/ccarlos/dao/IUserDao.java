package com.ccarlos.dao;

import com.ccarlos.pojo.User;

import java.io.IOException;
import java.util.List;

public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws IOException;

}
