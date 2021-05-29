package com.ccarlos.sqlSession;

import com.ccarlos.pojo.Configuration;
import com.ccarlos.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration,MappedStatement mappedStatement,Object... params) throws Exception;

}
