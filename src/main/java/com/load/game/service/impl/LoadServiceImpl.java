package com.load.game.service.impl;

import com.load.game.dao.UserDao;
import com.load.game.entity.User;
import com.load.game.service.ILoadInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
@Service
public class LoadServiceImpl implements ILoadInService {
    @Autowired
    private UserDao userDao;

    @Override
    public String userLoad(String userAccount, String userPassWord) {
        User user = userDao.findByUserAccount(userAccount);
        if (user == null) {
            return "用户不存在";
        } else if (user.getUserRegistCancel() == 0) {
            return "用户已注销,无法注销";
        } else {
            if (user.getUserPassWord().equals(userPassWord)) {
                if (user.getUserLoginExit() == 0) {
                    user.setUserLoginExit(1);
                    userDao.save(user);
                    return "用户登录成功";
                } else {
                    return "用户已登录，请退出后重新登录";
                }
            } else {
                return "输入的密码错误，请重新核对密码";
            }
        }
    }
}
