package com.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:35 2018/3/6
 */
public class DaoImp implements Dao {
    private SqlMapClientTemplate sqlMapClientTemplate;

    public SqlMapClientTemplate getSqlMapClientTemplate() {
        return sqlMapClientTemplate;
    }

    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }

    @Override
    public void delete(String id) {
        this.sqlMapClientTemplate.delete("deleteUsers", id);
    }

    @Override
    public Ibatis getById(String id) {
        return (Ibatis) this.sqlMapClientTemplate.queryForObject("getUsersById", id);
    }

    @Override
    public Ibatis getByName(String name) {

        return (Ibatis) this.sqlMapClientTemplate.queryForObject("getUsersByName", name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ibatis> getList() {
        return this.sqlMapClientTemplate.queryForList("getAllUsers", null);
    }

    @Override
    public void insert(Ibatis ibatis) {
        this.sqlMapClientTemplate.insert("insertUsers", ibatis);
    }

    @Override
    public void update(Ibatis ibatis) {
        this.sqlMapClientTemplate.update("updateUsers", ibatis);
    }

}

