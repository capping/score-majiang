/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2022 z.capping@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.sevengod.score.controller;

import com.sevengod.score.domain.vo.TokenInfo;
import com.sevengod.score.pojo.Code2SessionNotice;
import com.sevengod.score.service.WeChatService;
import com.sevengod.score.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.sevengod.score.model.User;
import com.sevengod.score.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Seven God
 * @since 2022-05-19 23:00
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeChatService weChatService;

    @RequestMapping(value = "/wx_login")
    public ModelMap wxLogin(@RequestParam("code") String code) {
        ModelMap result = new ModelMap();
        Code2SessionNotice notice = weChatService.getOpenId(code);
        if (notice.getOpenid() == null) {
            result.put("msg", "授权失败, 请重新登录");
            result.put("code", 1);
            return  result;
        }

        System.out.println(notice.getOpenid());
        User user = userService.getByOpenId(notice.getOpenid());
        if (user == null) {
            user = new User();
            // 首次登录，保存用户
            user.setTel("");
            user.setOpenid(notice.getOpenid());
            user.setUnionid(notice.getUnionid() == null ? "" : notice.getUnionid());
            user.setNickName("");
            user.setAvatar("");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setCreatedAt(df.format(new Date()));
            userService.save(user);
        }
        String jwt = JwtUtil.generateToken(user.getId());
        result.put("token", jwt);
        result.put("nick_name", user.getNickName());
        result.put("avatar", user.getAvatar());
        result.put("msg", "授权成功");
        result.put("code", 0);
        return result;
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ModelMap save(@RequestBody @Validated User user) {
        ModelMap result = new ModelMap();
        String msg = user.getId() == null ? "新增成功!" : "更新成功!";
        userService.save(user);
        result.put("msg", msg);
        result.put("code", 0);
        return result;
    }

    @RequestMapping(value = "/check_login")
    public ModelMap checkLogin(@RequestParam("token") String token) {
        Integer userId = JwtUtil.verifyToken(token);
        User user = userService.getById(userId);
        ModelMap result = new ModelMap();
        HashMap<String, Boolean> data = new HashMap<>();
        data.put("is_login", user != null);
        result.put("data", data);
        return result;
    }

    @RequestMapping(value = "/upload_avatar", method = RequestMethod.POST)
    public ModelMap uploadAvatar(@RequestBody Map<String,Object> data) {
        String avatar = data.get("avatar").toString();
        User user = userService.getById(TokenInfo.get("user_id"));
        user.setAvatar(avatar);
        userService.save(user);
        ModelMap result = new ModelMap();
        result.put("msg", "头像上传成功");
        result.put("code", 0);
        return result;
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PATCH)
    public ModelMap update(@RequestBody @Validated User user) {
        Integer userId = TokenInfo.get("user_id");
        ModelMap result = new ModelMap();
        String msg = user.getId() == null ? "新增成功!" : "更新成功!";
        user.setId(userId);
        userService.save(user);
        result.put("msg", msg);
        result.put("code", 0);
        return result;
    }

    /*
    * 获取登录用户的信息
     */
    @RequestMapping(value = "/user_info", method = RequestMethod.GET)
    public ModelMap userInfo() {
        Integer userId = TokenInfo.get("user_id");
        ModelMap result = new ModelMap();
        User user = userService.getById(userId);
        result.put("msg", "成功");
        result.put("data", user);
        result.put("code", 0);

        return result;
    }
}
