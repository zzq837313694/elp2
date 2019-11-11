package com.cn.elp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyWorkController {

    @RequestMapping("workerUpdate.html")
    public String workerUpdate(){
        return "workerUpdate";
    }

}
