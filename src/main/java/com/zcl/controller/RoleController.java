package com.zcl.controller;

import com.zcl.domain.Role;
import com.zcl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：角色服务器
 *
 * @author zhong
 * @date 2022-05-02 23:08
 */
@RequestMapping("/role")
@Controller
public class RoleController {
    /**
     * com.zcl.controller.RoleController.()
     * 注入Service层的代码
     *
     * @author zhong
     * @date 2022/5/2 23:15
     * @param  null
     * @return
     */
    @Autowired
    private RoleService roleService;

    /**
     * com.zcl.controller.RoleController.list()
     * 请求转发视图查询角色数据展示
     *
     * @author zhong
     * @date 2022/5/2 23:12
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        System.out.println("请求成功");
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        // 设置视图模型数据
        modelAndView.addObject("roleList",roleList);
        // 设置跳转的视图
        modelAndView.setViewName("role-list");
        System.out.println("输出查询列表："+roleList);
        return modelAndView;
    }
}
