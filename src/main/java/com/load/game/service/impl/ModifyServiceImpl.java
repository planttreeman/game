package com.load.game.service.impl;

import com.load.game.dao.UserDao;
import com.load.game.entity.User;
import com.load.game.service.IModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
@Service
public class ModifyServiceImpl implements IModifyService {
    @Autowired
    private UserDao userDao;
    @Override
    public String userModify(String userAccount, String userOldPassWord, String userNewPassWord) {
        User user = userDao.findByUserAccount(userAccount);
        if (user != null) {
            if (user.getUserPassWord().equals(userOldPassWord)) {
                if (user.getUserRegistCancel() == 1) {
                    user.setUserPassWord(userNewPassWord);
                    user.setUserLoginExit(0);
                    userDao.save(user);
                    return "修改密码成功,请重新登录";
                } else {
                    return "用户已注销，无法进行修改密码";
                }
            } else {
                return "输入密码错误";
            }
        } else {
            return "用户不存在";
        }

    }
}
