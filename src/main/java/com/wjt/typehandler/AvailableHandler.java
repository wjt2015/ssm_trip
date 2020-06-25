package com.wjt.typehandler;

import com.wjt.enums.AvailableType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Time 2020/4/24/21:00
 * @Author jintao.wang
 * @Description
 */
public class AvailableHandler implements TypeHandler<AvailableType> {
    @Override
    public void setParameter(PreparedStatement ps, int i, AvailableType parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, parameter.code);
    }

    @Override
    public AvailableType getResult(ResultSet rs, String columnName) throws SQLException {
        return AvailableType.codeOf(rs.getByte(columnName));
    }

    @Override
    public AvailableType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return AvailableType.codeOf(rs.getByte(columnIndex));
    }

    @Override
    public AvailableType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return AvailableType.codeOf(cs.getByte(columnIndex));
    }
}
