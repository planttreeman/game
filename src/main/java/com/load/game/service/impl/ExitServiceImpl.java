package com.load.game.service.impl;

import com.load.game.dao.UserDao;
import com.load.game.entity.User;
import com.load.game.service.IExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
@Service
public class ExitServiceImpl implements IExitService {
    @Autowired
    private UserDao userDao;

    @Override
    public String userExit(String userAccount) {
        User user = userDao.findByUserAccount(userAccount);
        if (user != null) {
            if (user.getUserLoginExit() == 1) {
                user.setUserLoginExit(0);
                userDao.save(user);
                return "用户退出成功";
            } else {
                return "用户未登录，不能进行退出操作";
            }
        } else {
            return "用户不存在";
        }


    }
}
