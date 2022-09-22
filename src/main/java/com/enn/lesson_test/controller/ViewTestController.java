package com.enn.lesson_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//跳转页面不用ResController
@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public String atguigu(Model model){
        System.out.println("方法入口");
        model.addAttribute("role","程小时");
        //model.addAttribute("role2","陆光");
        //model.addAttribute("role3","夏妍");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }


 }
