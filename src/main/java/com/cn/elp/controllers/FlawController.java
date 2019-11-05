package com.cn.elp.controllers;

import com.cn.elp.POJO.Flawtype;
import com.cn.elp.service.FlawTypeService;
import com.cn.elp.util.MyContents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FlawController {
    @Resource
    FlawTypeService flawTypeService;
    //显示缺陷类型
    @RequestMapping("/flawType.html")
    public String flawType(Model model){
        List<Flawtype> flawtypeList = flawTypeService.findAllFlawType();
        model.addAttribute("flawtypeList",flawtypeList);
        return "flawType";
    }
    //添加缺陷类型
    @RequestMapping(value = "/flawType.html",method = RequestMethod.POST)
    public String flawType(Flawtype flawtype){
        int rel=flawTypeService.addFlawType(flawtype);
        if (rel>0){
            System.out.println("成功");
        }
        return "redirect:/flawType.html";
    }
}
