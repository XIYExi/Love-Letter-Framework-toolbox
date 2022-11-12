package com.xion.wiki.controller;

import com.xion.wiki.controller.req.UserLoginReq;
import com.xion.wiki.controller.req.UserQueryReq;
import com.xion.wiki.controller.req.UserResetPasswordReq;
import com.xion.wiki.controller.req.UserSaveReq;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.controller.resp.UserLoginResp;
import com.xion.wiki.controller.resp.UserQueryResp;
import com.xion.wiki.service.impl.UserServiceImpl;
import com.xion.wiki.utils.R;
import com.xion.wiki.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @Resource
    private SnowFlake snowFlake;


    @GetMapping("/list")
    public R list(@Valid UserQueryReq req) {

        PageResp<UserQueryResp> list = userService.list(req);
        return R.ok().data("list",list);
    }

    @PostMapping("/save")
    public R save(@Valid @RequestBody UserSaveReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        userService.save(req);
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable Long id) {
        userService.delete(id);
        return R.ok();
    }

    @PostMapping("/reset-password")
    public R resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        userService.resetPassword(req);
        return R.ok();
    }

    @PostMapping("/login")
    public R login(@Valid @RequestBody UserLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        UserLoginResp userLoginResp = userService.login(req);

        Long token = snowFlake.nextId();
        LOG.info("生成单点登录token：{}，并放入redis中", token);
        userLoginResp.setToken(token.toString());

        return R.ok().data("list", userLoginResp);
    }

    @GetMapping("/logout/{token}")
    public R logout(@PathVariable String token) {
        LOG.info("从redis中删除token: {}", token);
        return R.ok();
    }
}
