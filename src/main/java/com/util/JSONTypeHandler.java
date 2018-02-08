package com.util;

import com.domain.DO.AttributeDO;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.alibaba.fastjson.JSON.parseObject;
import static com.alibaba.fastjson.JSON.toJSON;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午8:26 2018/2/7
 */
@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({AttributeDO.class})
public class JSONTypeHandler extends BaseTypeHandler<AttributeDO> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, AttributeDO attributeDO, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, toJSON(attributeDO).toString());
    }

    @Override
    public AttributeDO getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return parseObject(resultSet.getString(s), AttributeDO.class);
    }

    @Override
    public AttributeDO getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return parseObject(resultSet.getString(i), AttributeDO.class);
    }

    @Override
    public AttributeDO getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return parseObject(callableStatement.getString(i), AttributeDO.class);
    }
}
