package com.cn.elp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sovleTaskReceiptController {

    @RequestMapping("/sovleTaskreceipt.html")
    //添加消缺任务
    public String toAddSovleTaskPage(Model model) {


        return "sovleTaskReceipt";
    }
}
