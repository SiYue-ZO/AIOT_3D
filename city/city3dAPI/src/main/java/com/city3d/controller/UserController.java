package com.city3d.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.SysUser;
import com.city3d.service.UserService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.Res;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public @ResponseBody List<SysUser> getUser() {
        return userService.getUser();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody SysUser sysUser) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        sysUser.setUserId(uid);
        return userService.insert(sysUser);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody SysUser sysUser) throws Exception {
        return userService.updateByPrimaryKey(sysUser);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody SysUser sysUser) throws Exception {
        return userService.deleteByPrimaryKey(sysUser.getUserId());
    }

    @RequestMapping("/login")
    public @ResponseBody Object login(@RequestBody Map<String, String> param, HttpSession session) {
        String loginName = param.get("loginName");
        String pwd = param.get("pwd");
        if (StringUtils.isNotEmpty(loginName) && StringUtils.isNotEmpty(pwd)) {
            Map<String, String> res = new HashMap<>();
            SysUser sysUser = userService.findByLoginNameAndPwd(loginName, pwd);
            if (sysUser != null) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String Time = df.format(new Date());// new Date()为获取当前系统时间
                Date nowDate = new Date();
                Date createDate = new Date();
                try {
                    nowDate = df.parse(Time);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {
                    createDate = df.parse(sysUser.getCreateTime());
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int deadLine = Integer.parseInt(sysUser.getDeadLine());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(createDate);
                calendar.add(Calendar.DAY_OF_MONTH, deadLine);
                Date deadDate = new Date();
                try {
                    deadDate = df.parse(df.format(calendar.getTime()));
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (nowDate.after(deadDate)) {
                    return Res.fail("login_fail", "用户已过期，请重新申请");
                } else {
                    res.put("token", sysUser.getRole());
                    res.put("userId", sysUser.getUserId());
                    res.put("userName", sysUser.getUserName());
                    res.put("userDep", sysUser.getUserDep());
                    res.put("role", sysUser.getRole());
                    res.put("app", sysUser.getApp());
                    res.put("deadLine", sysUser.getDeadLine());
                    res.put("createTime", sysUser.getCreateTime());
                    session.setAttribute("LOGIN_USER", sysUser);
                    return Res.success(res);
                }
            } else {
                List<SysUser> sysUsers = userService.findByLoginName(loginName);
                if (sysUsers.size() != 0) {
                    return Res.fail("login_fail", "密码错误");
                } else {
                    return Res.fail("login_fail", "登录名不存在");
                }
            }
        }
        return Res.fail("login_fail", "登录失败");
    }

    @RequestMapping("/updatePwd")
    public @ResponseBody int updatePwd(@RequestBody SysUser sysUser) {
        int result = 0;
        if (sysUser.getPwd().equals(sysUser.getUserTel())) {
            result = userService.updatePwd(sysUser);
        }
        return result;
    }
}
