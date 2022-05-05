package com.zcl.controller;

import com.zcl.domain.Role;
import com.zcl.domain.User;
import com.zcl.service.RoleService;
import com.zcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：用户列表控制器
 *
 * @author zhong
 * @date 2022-05-03 9:07
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * com.zcl.controller.UserController.list()
     * 查询用户列表
     *
     * @author zhong
     * @date 2022/5/3 23:07
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> userList = userService.list();
        System.out.println("查询用户数据："+userList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * com.zcl.controller.UserController.saveUI()
     * 新增跳转查询角色信息
     *
     * @author zhong
     * @date 2022/5/3 23:07
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        // 需要当前所有的角色数据
        List<Role> roleList = roleService.list();
        System.out.println("查询的角色信息："+roleList);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    /**
     * com.zcl.controller.UserController.save()
     * 新增用户信息
     *
     * @author zhong
     * @date 2022/5/4 8:07
     * @param  user
     * @param  roleIds
     * @return java.lang.String
     */
    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    /**
     * com.zcl.controller.UserController.del()
     * 根据用户Id删除用户信息
     *
     * @author zhong
     * @date 2022/5/5 13:07
     * @param  userId
     * @return java.lang.String
     */
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        System.out.println("获取的删除ID："+userId);
        userService.del(userId);
        return "redirect:/user/list";
    }
}

