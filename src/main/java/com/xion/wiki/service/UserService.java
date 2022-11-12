package com.xion.wiki.service;

import com.xion.wiki.controller.req.UserLoginReq;
import com.xion.wiki.controller.req.UserQueryReq;
import com.xion.wiki.controller.req.UserResetPasswordReq;
import com.xion.wiki.controller.req.UserSaveReq;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.controller.resp.UserLoginResp;
import com.xion.wiki.controller.resp.UserQueryResp;
import com.xion.wiki.domain.User;


public interface UserService {

    public PageResp<UserQueryResp> list(UserQueryReq req);

    public void save(UserSaveReq req);

    public void delete(Long id);

    public User selectByLoginName(String LoginName);
    public void resetPassword(UserResetPasswordReq req);
    public UserLoginResp login(UserLoginReq req);

}
