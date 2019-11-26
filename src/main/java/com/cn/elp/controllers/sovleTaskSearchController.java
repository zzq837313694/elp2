package com.cn.elp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sovleTaskSearchController {

    @RequestMapping("sovleTaskSearch.html")
    public String  sovleTaskSearch(Model model){


        return "sovleTaskSearch";
    }


}
