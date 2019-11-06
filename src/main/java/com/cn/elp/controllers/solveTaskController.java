package com.cn.elp.controllers;



import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.service.SolvetaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class solveTaskController {

    @Resource
    SolvetaskServices solvetaskServices;

    @RequestMapping("/makesSolveTask.html")
    public String makesSolveTask(Model model){
      List<Solvetaskinfo> solveTasks = solvetaskServices.findAllSolveTask();
      model.addAttribute("solveTasks",solveTasks);
        return  "makesSolveTask";
    }

}
