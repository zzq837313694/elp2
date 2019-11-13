package com.cn.elp.controllers;

import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.WorkerinfoService;
import com.cn.elp.util.MyContents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {
    @Resource
    WorkerinfoService workerinfoService;


   //显示登录页面
    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }
    //处理登录
    @RequestMapping(value = "/login.html",method = RequestMethod.POST)
    public String dologin(String userNo, String password, Model model, HttpSession session){
        Workerinfo workerinfo=workerinfoService.findAllWorker(userNo);
        if(workerinfo==null){
            model.addAttribute("error","用户名不存在！");
            return "login";
        }else if(workerinfo.getStatus().equals(MyContents.CIRCUITSTOPUSE)){
            model.addAttribute("error","此用户号已停用，无法登陆！");
            return "login";
        }
        else if(workerinfo.getPassword().equals(password)){
            session.setAttribute(MyContents.WORKER_SESSION,workerinfo);
            Date lastOnline=new Date();
            System.out.println(lastOnline);
            System.out.println(lastOnline.toString());
            int rel=workerinfoService.updateWorkerLastTime(lastOnline,userNo);
            if (rel>0){
                return "redirect:index.html";
            }
            else {
                return "login";
            }
        }else{
            model.addAttribute("userNo",userNo);
            model.addAttribute("errorpwd","密码错误！");
            return "login";
        }
    }

    @RequestMapping("index.html")
    public  String index(){
        return "index";
    }



    @RequestMapping("exit.html")
    public String exit(HttpSession session){
        session.invalidate();
        return  "redirect:login.html";
    }
    @RequestMapping("head.html")
    public  String head(){
        return "head";
    }
    @RequestMapping("left.html")
    public  String left(){
        return "left";
    }
    @RequestMapping("main.html")
    public  String main(){
        return "main";
    }

}
