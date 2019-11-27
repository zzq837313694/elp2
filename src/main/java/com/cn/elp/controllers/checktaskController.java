package com.cn.elp.controllers;

import com.cn.elp.POJO.*;
import com.cn.elp.service.*;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.FlawCheck;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.*;

@Controller
public class checktaskController {
    @Resource
    ChecktaskService checktaskService;
    @Resource
    CircuitService circuitService;
    @Resource
    TowerinfoService towerinfoService;
    @Resource
    FlawinfoService flawinfoService;
    @Resource
    FlawTypeService flawTypeService;
    @Resource
    WorkerinfoService workerinfoService;
    @Resource
    RoleServices roleServices;

    @RequestMapping("/getchecktaskListNot.html")
    @ResponseBody
    public PageSurpport<ChecktaskCondition> getchecktaskListNot(ChecktaskCondition checktaskCondition,String work) {
        PageSurpport<ChecktaskCondition> pageSurpport = checktaskService.SelectChecktaskByParamNot(checktaskCondition ,work);
        return pageSurpport;
    }

    @RequestMapping("/getchecktaskList.html")
    @ResponseBody
    public PageSurpport<ChecktaskCondition> getchecktaskList(ChecktaskCondition checktaskCondition, Model model) {
        PageSurpport<ChecktaskCondition> pageSurpport = checktaskService.SelectChecktaskByParam(checktaskCondition);
        return pageSurpport;
    }

    @RequestMapping("/checktaskPlan.html")
    public String checktaskPlan() {
        return "checktaskPlan";
    }

    @RequestMapping("/checktaskBack.html")
    public String checktaskBack() {
        return "checktaskBack";
    }

    @RequestMapping("/addChecktask.html")
    public String toAddSovleTaskPage() {
        return "addChecktask";
    }

    @RequestMapping("/getCircuitList.html")
    @ResponseBody
    public List<Circuit> getCircuitList() {
        return circuitService.findAllCircuit();
    }

    @RequestMapping("/getCircuitByNo.html")
    @ResponseBody
    public Circuit getCircuitByNo(String cirNo) {
        return circuitService.findOneCircuit(cirNo);
    }

    @RequestMapping("/showChecktask.html")
    public String showChecktask(String jobId, Model model) {
        Checktaskinfo checktaskinfo= checktaskService.SelectChecktaskById(jobId);
        String c=checktaskinfo.getCheckBy();
        String worker="";
        if(c==null||"".equals(c)){

        }else{
            String []arr=c.split(",");
            for (String arrr :arr){
                worker+=workerinfoService.findAllWorker(arrr).getUserName()+",";
            }
        }


        model.addAttribute("worker",worker);
        model.addAttribute("Checktask",checktaskinfo );

        return "showChecktask";
    }

    @RequestMapping("/getFlawinfoList.html")
    @ResponseBody
    public PageSurpport<Flawinfo> getFlawinfoList(String circuitNo, String jobId, @RequestParam(defaultValue = "1") int pageIndex, String flawLV) {
        PageSurpport<Flawinfo> pageSurpport = new PageSurpport<>();
        pageSurpport.setPageSize(8);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(flawinfoService.findFlawInfoBycheckJobNoPaging(jobId, circuitNo, pageIndex, 8, flawLV));
        pageSurpport.setTotalCount(flawinfoService.findFlawInfoBycheckJobNoPagingCount(jobId, circuitNo, flawLV));
        return pageSurpport;
    }

    @RequestMapping("/getFlawinfo.html")
    @ResponseBody
    public Object getFlawinfo(String flawNo, Model model) {
        Map map = new HashMap<>();
        map.put("flawInfo", flawinfoService.findFlawInfoByFlawNo(flawNo));
        map.put("flawTypeList", flawTypeService.findAllFlawType());
        map.put("workList", workerinfoService.findAllWorkers());
        return map;
    }
    @RequestMapping("/flawinfoCheck.html")
    public String flawinfoCheck() {
        return "flawinfoCheck";
    }

    @RequestMapping("/getflawinfoCheckList.html")
    @ResponseBody
    public Object getflawinfoCheckList(FlawCheck flawCheck) {
        PageSurpport<ChecktaskCondition> pageSurpport = checktaskService.SelectChecktask(flawCheck);
        return pageSurpport;
    }

    @RequestMapping("/getflawTypeList.html")
    @ResponseBody
    public Object getflawTypeList() {
        return flawTypeService.findAllFlawType();
    }

    @RequestMapping("/doaddChecktask.html")
    public  String addChecktask(Checktaskinfo checktaskinfo){
        checktaskinfo.setCreateDate(new Date());

        int rel=checktaskService.addChecktaskinfo(checktaskinfo);
        System.out.println(rel);
        return "checktaskPlan";
    }
    @RequestMapping("/updateChecktask.html")
    public  String updateChecktask(String jobId,Model model){
        model.addAttribute("check",checktaskService.SelectChecktaskById(jobId));
        return "updateChecktask";
    }
    @RequestMapping("/doupdateChecktask.html")
    public  String doupdateChecktask(Checktaskinfo checktaskinfo){
        Checktaskinfo checktaskinfo1=checktaskService.SelectChecktaskById(checktaskinfo.getJobId());
        checktaskinfo.setStatus(checktaskinfo1.getStatus());
        checktaskinfo.setAbolish(checktaskinfo1.getAbolish());
        checktaskinfo.setCreateDate(checktaskinfo1.getCreateDate());
        int rel=checktaskService.updateCheck(checktaskinfo);
        System.out.println(rel);
        return "checktaskPlan";
    }
    @RequestMapping("/backFlaw.html")
    public String backFlaw(String jobId, Model model) {
        model.addAttribute("Checktask", checktaskService.SelectChecktaskById(jobId));
        return "backFlaw";
    }
    @RequestMapping("/getTowerList.html")
    @ResponseBody
    public Object getTowerList(String circuitNo, String jobId, @RequestParam(defaultValue = "1") int pageIndex) {
        Map map=new HashMap();
        PageSurpport<Towerinfo> pageSurpport = new PageSurpport<>();
        pageSurpport.setPageSize(8);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(towerinfoService.findTowerListByCircuitNoPaging(circuitNo,pageIndex,8));
        pageSurpport.setTotalCount(towerinfoService.findTowerListByCircuitNoPagingCount(circuitNo));
        map.put("ps",pageSurpport);
        map.put("fs",checktaskService.findFlawInfoBycheckJobNo(jobId));
        return map;
    }
    @RequestMapping("/addFlawinfo.html")
    @ResponseBody
    public int addFlawinfo(Flawinfo flawinfo,int  intcatRates){
        double d=intcatRates;
        flawinfo.setIntcatRate(d);
        flawinfo.setCheckDate(new Date());
        int rel=flawinfoService.addFlawinfo(flawinfo);
        return rel;
    }
    @RequestMapping("/update.html")
    @ResponseBody
    public int upFlawinfo(Flawinfo flawinfo,Integer  intcatRates){
        double d=intcatRates;
        flawinfo.setIntcatRate(d);
        int rel=flawinfoService.updateFlawinfo(flawinfo);
        return rel;
    }
    @RequestMapping("/cancel.html")
    public String cancel(String jobId){
        Checktaskinfo checktaskinfo=checktaskService.SelectChecktaskById(jobId);
        checktaskinfo.setAbolish("是");
        checktaskService.updateCheck(checktaskinfo);
        return "checktaskPlan";
    }
    @RequestMapping("/changeStuts.html")
    public String changeStuts(String jobId,String status){
        Checktaskinfo checktaskinfo=checktaskService.SelectChecktaskById(jobId);
        checktaskinfo.setStatus(status);
        if("已完成".equals(status)){
            checktaskinfo.setFinishDate(new Date());
        }
        int rel=checktaskService.updateCheck(checktaskinfo);
        System.out.println(rel);
        if("执行中".equals(status)||"已完成".equals(status)){
            return "checktaskBack";
        }else{
            return "checktaskPlan";
        }

    }


    @RequestMapping("/chooseCheckWorker")
    @ResponseBody
    /*选择消缺员*/
    public Map<String, Workerinfo> chooseSolveWorker(String taskNo, Model model) {
        Map workers = new HashMap();
        List<Workerinfo> leftWorker = workerinfoService.findAllWorkers();
        int roleId = roleServices.findRoleByRoleName("巡检员").getRoleId();
        int no = 0;
        while (no < leftWorker.size()) {
            if (leftWorker.get(no).getRoleId() != roleId || "冻结".equals(leftWorker.get(no).getStatus())) {
                leftWorker.remove(no);
                continue;
            }
            no++;
        }
        List<Workerinfo> rightWorker = new ArrayList<>();
        if (taskNo == null || "".equals(taskNo)) {
            workers.put("leftWorker", leftWorker);
            workers.put("rightWorker", rightWorker);
            return workers;
        }
        /*String nowWorker = solvetaskServices.findSolveTaskByTaskNo(taskNo).getFinishiworkerId();*/
        String nowWorker = checktaskService.SelectChecktaskById(taskNo).getCheckBy();
        if (nowWorker == null || nowWorker.length() == 0) {
            workers.put("leftWorker", leftWorker);
            workers.put("rightWorker", rightWorker);
        } else {
            String[] workerArray = nowWorker.split(",");
            for (int i = 0; i < workerArray.length; i++) {
                rightWorker.add(workerinfoService.findAllWorker(workerArray[i]));
            }
            for (Workerinfo worker : leftWorker) {
                rightWorker.remove(worker);
            }
            workers.put("leftWorker", leftWorker);
            workers.put("rightWorker", rightWorker);
        }

        return workers;
    }

    @RequestMapping("/allocatingtask.html")
    @ResponseBody
    public int allocatingtask(String worker,String jobId){
    Checktaskinfo checktaskinfo=checktaskService.SelectChecktaskById(jobId);
    checktaskinfo.setStatus("已分配");
    checktaskinfo.setCheckBy(worker);
    int rel=checktaskService.updateCheck(checktaskinfo);
        return rel;
    }
}