package com.cn.elp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class checktaskController {


    @RequestMapping("/checktaskPlan.html")
    public String checktaskPlan(){
        return "checktaskPlan";
    }


}
