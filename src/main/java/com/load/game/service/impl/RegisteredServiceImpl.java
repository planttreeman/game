package com.load.game.service.impl;

import com.load.game.dao.UserDao;
import com.load.game.entity.User;
import com.load.game.service.IRegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/23
 */
@Service
public class RegisteredServiceImpl implements IRegisteredService {
    @Autowired
    private UserDao userDao;
    @Override
    public String registerUser(String userAccount, String Password) {
        User userOld=userDao.findByUserAccount(userAccount);
        if (userOld==null){
            User user=new User();
            user.setUserAccount(userAccount);
            user.setUserPassWord(Password);
            user.setUserLoginExit(0);
            user.setUserRegistCancel(1);
            userDao.save(user);
            return "注册已成功";
        } else {
            return "用户已存在,请重新注册新的用户";
        }

    }
}
