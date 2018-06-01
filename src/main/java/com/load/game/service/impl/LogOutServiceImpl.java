package com.load.game.service.impl;

import com.load.game.dao.UserDao;
import com.load.game.entity.User;
import com.load.game.service.ILogOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
@Service
public class LogOutServiceImpl implements ILogOutService {
    @Autowired
    private UserDao userDao;

    @Override
    public String userLogOut(String userAccount, String userPassWord) {
        User user = userDao.findByUserAccount(userAccount);
        if (user != null) {
            if (user.getUserPassWord().equals(userPassWord)) {
                if (user.getUserLoginExit() == 1) {
                    user.setUserLoginExit(0);
                    user.setUserRegistCancel(0);
                    userDao.save(user);
                    return "用户注销成功";
                } else {
                    return "请先登录";
                }
            } else {
                return "密码错误，请重新输入";
            }
        } else {
            return "用户不存在";
        }

    }
}
