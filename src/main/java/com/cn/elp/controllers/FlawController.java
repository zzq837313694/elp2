package com.cn.elp.controllers;

import com.cn.elp.POJO.Flawtype;
import com.cn.elp.service.FlawTypeService;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FlawController {
    @Resource
    FlawTypeService flawTypeService;
    //显示缺陷类型
    @RequestMapping("/flawType.html")
    public String flawType(
            @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex,
            Model model){
        List<Flawtype> flawtypeList = flawTypeService.findAllFlawTypePaging(pageIndex,MyContents.PAGESIZE);

        PageSurpport<Flawtype> pageSurpport=new PageSurpport<Flawtype>();
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setTotalCount(flawTypeService.findAllFlawCount());
        pageSurpport.setDataList(flawtypeList);

        model.addAttribute("pageSurpport",pageSurpport);

        return "flawType";
    }
    //添加缺陷类型
    @RequestMapping(value = "/addFlawType.html",method = RequestMethod.POST)
    public String flawType(Flawtype flawtype){
        int rel=flawTypeService.addFlawType(flawtype);
        if (rel>0){
            System.out.println("成功");
        }
        return "redirect:/flawType.html";
    }
    //修改缺陷类型
    @RequestMapping(value = "updateFlawType.html",method = RequestMethod.POST)
    public String updateFlawType(Flawtype flawtype,Model model){
        System.out.println(flawtype.getFlawTypeId());
        int rel = flawTypeService.updateFlawTypeById(flawtype);
        if(rel>0){
            System.out.println("成功");
        }
        return "redirect:/flawType.html";
    }
    //删除缺陷类型
    @RequestMapping("delFlawType.html")
    @ResponseBody
    public int delFlawType(Integer typeid){
        int rel=flawTypeService.delFlawTypeById(typeid);
        return rel;
    }

}
