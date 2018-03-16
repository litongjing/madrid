package com.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:15 2018/3/15
 */
@Service
public class IbatisService {
    @Autowired
    private Dao dao;
    @Autowired
    private SqlMapClient sqlMapClient;

    @Resource(name = "transactionTempleteforibatis")
    TransactionTemplate transactionTemplate;

    //事物处理1
    public void insert(Ibatis ibatis) {
        transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                dao.insert(ibatis);
                int i = 1 / 0;
                return true;
            }
        });
    }
}
