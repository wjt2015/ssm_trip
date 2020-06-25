package com.wjt.model;

import com.wjt.enums.AvailableType;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
@ToString
public class LoginEntity {
    public Long id;

    public Date createTime;

    public Date updateTime;

    public String createUser;

    public String updateUser;

    public AvailableType available;

    public String userName;

    public String password;

    public Long loginTs;

    public LoginEntity(Long id, Date createTime, Date updateTime, String createUser, String updateUser, AvailableType available, String userName, String password, long loginTs) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.available = available;
        this.userName = userName;
        this.password = password;
        this.loginTs = loginTs;
    }

    public LoginEntity() {
        super();
    }


}