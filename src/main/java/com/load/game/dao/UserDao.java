package com.load.game.dao;

import com.load.game.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
public interface UserDao extends MongoRepository<User,Long> {
    User findByUserAccount(String userAccount);//都是通过用户的账户来查询用户信息
}
