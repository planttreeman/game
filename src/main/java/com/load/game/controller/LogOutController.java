package com.load.game.controller;

import com.load.game.service.ILogOutService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
@RestController
@RequestMapping("/game")
public class LogOutController {
    @Autowired
    private ILogOutService iLogOutService;

    @ApiOperation(value = "用户注销",tags = "用户注销",httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = Void.class),
            @ApiResponse(code = 400, message = "参数错误", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class)
    })
    @PostMapping(value = "/userLogOut/{userAccount}/{userPassWord}")
    private String say(@PathVariable("userAccount")String userAccount,@PathVariable("userPassWord")String userPassWord){
        return iLogOutService.userLogOut(userAccount,userPassWord);
    }
}
