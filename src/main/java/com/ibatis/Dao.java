package com.ibatis;

import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:36 2018/3/6
 */
public interface Dao {
    public List<Ibatis> getList();
    public Ibatis getByName(String name);
    public Ibatis getById(String id);
    public void insert(Ibatis ibatis);
    public void delete(String id);
    public void update(Ibatis ibatis);
}