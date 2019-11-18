package com.cn.elp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermissionController {
    @RequestMapping("/permissionSetting.html")
    public String permissionSetting(){
        return "permissionSetting";
    }
}
