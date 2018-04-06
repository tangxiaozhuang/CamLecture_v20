package com.camLecture.contrller;

import com.camLecture.entity.Company;
import com.camLecture.entity.User;
import com.camLecture.service.ICompanyService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Administrator on 2018/3/6.
 */
@Controller
@RequestMapping("/Company")
public class ComController {
    @Resource
    private ICompanyService companyService;
    @RequestMapping("/selectCom")
    public String selectCom(HttpServletRequest request, HttpServletResponse response, Model model ,Company company) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        long id=Long.parseLong(request.getParameter("id"));
        Company result=companyService.selectCompany(id);
        model.addAttribute("company",result);
        return null;
    }

    @RequestMapping("showComListAdmin")
    public String showComListAdmin(HttpServletRequest request,HttpServletResponse response,Model model,Company company){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            model.addAttribute("message","请先登录");
            return "login/adminLogin";
        }
        ArrayList<Company> comList=companyService.getAllCom();
        model.addAttribute("comList",comList);
        return "admin/showCompanyList";
    }

    @RequestMapping("newComAdmin")
    public String newComAdmin(){
        return "admin/addCompany";
    }
    @RequestMapping("editCompany")
    public String editCompany(HttpServletResponse response,HttpServletRequest request,Model model,Company company){
        model.addAttribute("company",company);
        return "admin/editCompany";
    }

    @RequestMapping("addComAdmin")
    public String addComAdmin(HttpServletRequest request,
                              HttpServletResponse response,
                              Model model,Company company){
        Company company1=companyService.getCompany(company);
        if(company1==null) {
            int result = companyService.insert(company);
            if(result!=0){
                return "redirect:/Company/showComList";
            }else{
                String msg="添加失败";
                model.addAttribute("message",msg);
                return "admin/addCompany";
            }
        }
        else{
            String msg="该记录已存在";
            model.addAttribute("message",msg);
            return "admin/addCompany";
        }
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request,HttpServletResponse response,Model model,Company company){
        int result=companyService.update(company);
        return "redirect:/Company/showComListAdmin";
    }

    @RequestMapping("deleteCompany")
    public String deleteCompany(HttpServletRequest request,HttpServletResponse response,Model model,Company company){
        long id=Long.parseLong(request.getParameter("id"));
        int result=companyService.delete(id);
        return "redirect:/Company/showComListAdmin";
    }

    @RequestMapping("showComList")
    public String showComList(HttpServletResponse response,HttpServletRequest request,Model model){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            model.addAttribute("message","请先登录");
            return "login/login";
        }
        ArrayList<Company> comList=new ArrayList<>();
        comList=companyService.getAllCom();
        model.addAttribute("comList",comList);
        return "company/showComList";
    }
}
