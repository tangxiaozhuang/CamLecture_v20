package com.camLecture.contrller;

import com.camLecture.entity.ApplyProgress;
import com.camLecture.entity.CamLecture;
import com.camLecture.entity.Company;
import com.camLecture.entity.User;
import com.camLecture.service.IApplyProgressService;
import com.camLecture.service.ICamLectureService;
import com.camLecture.service.ICompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Administrator on 2018/3/6.
 */
@Controller
@RequestMapping("/ApplyProgress")
public class ApplyProgressController {
    @Resource
    private IApplyProgressService applyProgressService ;
    @Resource
    private ICompanyService companyService;




    @RequestMapping("/selectAllPro.do")
    public String selectCom(HttpServletRequest request, HttpServletResponse response, Model model ,User user
    ) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ApplyProgress param =new ApplyProgress();
        param.setUserId(user.getId());
        ArrayList<ApplyProgress> appList=new ArrayList<ApplyProgress>();
        appList=applyProgressService.getAllPro(param);
        model.addAttribute("appList",appList);
        return "showAllApplyProgress";
    }


    @RequestMapping("/newApp.do")
    public String newApp(HttpServletRequest request,HttpServletResponse response,Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        ArrayList<Company> comList=companyService.getAllCom();
        model.addAttribute("comList",comList);
        return "applyProgress/addNewApplyprogress";
    }

    @RequestMapping("/addApply.do")
    public String addApply(HttpServletRequest request, HttpServletResponse response, Model model ,ApplyProgress applyProgress) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String message;
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            model.addAttribute("message","请先登录");
            return "/login/login";
        }
        applyProgress.setUserId(user.getId());

        if(applyProgress.getCompany()==null||applyProgress.getCompany()==""){
            Company company = companyService.selectCompany(applyProgress.getCompanyId());
            applyProgress.setCompany(company.getComName());
        }else{
            if(applyProgress.getCompany().equals("0")){
                applyProgress.setCompanyId(0);
                applyProgress.setCompany(request.getParameter("otherCompany"));
            }else{
                String[] s=new String[10];
                s=applyProgress.getCompany().split(":");
                Long camId=Long.parseLong(s[0]);
                applyProgress.setCompanyId(camId);
                applyProgress.setCompany(s[1]);
            }
        }
        if(applyProgress.getProgress()==0) {
            applyProgress.setProgress(1);
        }

        ApplyProgress applyProgress1=applyProgressService.getPro(applyProgress);
        if(applyProgress1!=null){
            message="该记录已存在，请勿重复添加";

        }
        else {
            int result = applyProgressService.insertPro(applyProgress);
            if (result != 0) {
                message = "success";
            } else
                message = "error";
        }
        model.addAttribute("result",message);
        applyProgress.setUserId(user.getId());
        ArrayList<ApplyProgress> appList=applyProgressService.getAllPro(applyProgress);
        model.addAttribute("appList",appList);
        return  "applyProgress/showApplyprogressList";
    }

    @RequestMapping("/showAppList.do")
    public String showAppList(HttpServletResponse response,HttpServletRequest request,Model model,ApplyProgress applyProgress){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            model.addAttribute("message","请先登录");
            return "/login/login";
        }
        applyProgress.setUserId(user.getId());
        ArrayList<ApplyProgress> appList=new ArrayList<>();
        appList=applyProgressService.getAllPro(applyProgress);

        model.addAttribute("appList",appList);

        return "applyProgress/showApplyprogressList";
    }

    @RequestMapping("/updateProgress.do")
    public String update(HttpServletRequest request,HttpServletResponse response,
                         Model model,ApplyProgress applyProgress){
        User user=(User)request.getSession().getAttribute("user");
        String message;
        long id=Long.parseLong(request.getParameter("id"));
        int progress=Integer.parseInt(request.getParameter("progress"));
        applyProgress=applyProgressService.selectPro(id);
        applyProgress.setProgress(progress);
        int result=applyProgressService.update(applyProgress);
        if(result==0){
            message="更新失败";
        }
        else
            message="更新成功";

        model.addAttribute("message",message);
        applyProgress.setUserId(user.getId());
        ArrayList<ApplyProgress> appList=applyProgressService.getAllPro(applyProgress);
        model.addAttribute("appList",appList);
        return  "applyProgress/showApplyprogressList";
    }

    @RequestMapping("showAppDetail")
    public String showAppDetail(HttpServletRequest request,HttpServletResponse response,Model model){
        ApplyProgress applyProgress=applyProgressService.selectPro(Long.parseLong(request.getParameter("id")));
        model.addAttribute("applyProgress",applyProgress);
        return "applyProgress/showApplyprogressDetails";
    }

    @RequestMapping("editApp")
    public String editApp(HttpServletRequest request,HttpServletResponse response,Model model,ApplyProgress applyProgress){
        int result=applyProgressService.update(applyProgress);
        if(result!=1){
            String message="更新失败，请重试";
            model.addAttribute("message",message);
            model.addAttribute("applyProgress",applyProgress);
            return "applyProgress/showApplyprogressDetails";
        }else {
            User user = (User) request.getSession().getAttribute("user");
            applyProgress.setUserId(user.getId());
            ArrayList<ApplyProgress> appList = applyProgressService.getAllPro(applyProgress);
            model.addAttribute("appList", appList);
            return "applyProgress/showApplyprogressList";
        }
    }

    @RequestMapping("deleteApp")
    public String deleteApp(HttpServletRequest request,HttpServletResponse response,
                            Model model){
        long id=Long.parseLong(request.getParameter("id"));
        int result=applyProgressService.delete(id);
        String deleteMsg;
        if(result!=0){
            deleteMsg="删除失败";
            model.addAttribute("deleteMsg",deleteMsg);
        }
        User user = (User) request.getSession().getAttribute("user");
        ApplyProgress applyProgress=new ApplyProgress();
        applyProgress.setUserId(user.getId());
        ArrayList<ApplyProgress> appList = applyProgressService.getAllPro(applyProgress);
        model.addAttribute("appList", appList);
        return "applyProgress/showApplyprogressList";
    }
}
