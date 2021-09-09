package com.hasim.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 登录功能的 demo controller
 * @Author Hasim
 * @Date 2021/9/9 10:23
 * @Version 1.0
 */
@Api(tags = "LoginController", description = "登录功能")
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation("请求登录成功页面")
    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName(); // 获取当前登录用户
        logger.info("当前登陆用户：" + name);

        return "home.html";
    }

    @ApiOperation("登录请求")
    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @ApiOperation("admin权限验证")
    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')") // 用于判断用户是否有指定权限，没有就不能访问
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @ApiOperation("user权限验证")
    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
}
