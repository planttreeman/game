package com.load.game.controller;

import com.load.game.service.ILoadInService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * descript
 *
 * @author orange
 * @Time 2018/4/24
 */
@RestController
@RequestMapping(value = "/game")
public class LoginController {
    @Autowired
    private ILoadInService iLoadInService;

    @ApiOperation(value = "用户登录",tags = "用户登录", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = Void.class),
            @ApiResponse(code = 400, message = "参数错误", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class)
    })
    @RequestMapping(value = "/userLogin/{userAccount}/{userPassWord}", method = RequestMethod.POST)
    public String say(@PathVariable("userAccount") String userAccount, @PathVariable("userPassWord")String userPassWord) {
        return  iLoadInService.userLoad(userAccount,userPassWord);
    }
}
