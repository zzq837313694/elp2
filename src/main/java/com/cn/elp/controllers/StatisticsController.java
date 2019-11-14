package com.cn.elp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {

    @RequestMapping("checktaskStatistics.html")
    public String checktaskStatistics(){
        return "checktaskStatistics";
    }

    @RequestMapping("solveTaskStatistics.html")
    public String solveTaskStatistics(){
        return "solveTaskStatistics";
    }
}
