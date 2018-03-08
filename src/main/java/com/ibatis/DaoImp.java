package com.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:35 2018/3/6
 */
public class DaoImp extends SqlMapClientDaoSupport implements Dao {
    @Override
    public void delete(String id) {
        getSqlMapClientTemplate().delete("deleteUsers", id);
    }

    @Override
    public Ibatis getById(String id) {
        return (Ibatis) getSqlMapClientTemplate().queryForObject("getUsersById", id);
    }

    @Override
    public Ibatis getByName(String name) {

        return (Ibatis) getSqlMapClientTemplate().queryForObject("getUsersByName", name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ibatis> getList() {
        return getSqlMapClientTemplate().queryForList("getAllUsers", null);
    }

    @Override
    public void insert(Ibatis ibatis) {
        getSqlMapClientTemplate().insert("insertUsers", ibatis);
    }

    @Override
    public void update(Ibatis ibatis) {
        getSqlMapClientTemplate().update("updateUsers", ibatis);
    }

}

