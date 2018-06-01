package com.load.game.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/20
 */
@Document
public class User implements Serializable {

    private static final long serialVersionUID = 6260835112909620942L;

@org.springframework.data.annotation.Id
    private Long Id;
    private String userAccount;
    private String userPassWord;
    private Integer UserRegistCancel;//解释：1已注册，0为已注销
    private Integer UserLoginExit;//解释：0为已退出或未登录，1为已登录

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public Integer getUserRegistCancel() {
        return UserRegistCancel;
    }

    public void setUserRegistCancel(Integer userRegistCancel) {
        UserRegistCancel = userRegistCancel;
    }

    public Integer getUserLoginExit() {
        return UserLoginExit;
    }

    public void setUserLoginExit(Integer userLoginExit) {
        UserLoginExit = userLoginExit;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", UserRegistCancel=" + UserRegistCancel +
                ", UserLoginExit=" + UserLoginExit +
                '}';
    }
}
