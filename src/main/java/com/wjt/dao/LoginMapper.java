package com.wjt.dao;

import com.wjt.model.LoginEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class})
@Repository
public interface LoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginEntity record);

    int insertSelective(LoginEntity record);

    LoginEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoginEntity record);

    int updateByPrimaryKey(LoginEntity record);
}