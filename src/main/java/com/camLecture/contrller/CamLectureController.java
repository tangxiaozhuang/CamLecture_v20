package com.camLecture.contrller;

import com.camLecture.dao.ICityDao;
import com.camLecture.entity.CamLecture;
import com.camLecture.entity.City;
import com.camLecture.entity.Company;
import com.camLecture.entity.User;
import com.camLecture.service.ICamLectureService;
import com.camLecture.service.ICityService;
import com.camLecture.service.ICompanyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Administrator on 2018/3/6.
 */
@Controller
@RequestMapping("/CamLecture")
public class CamLectureController {
    @Resource
    private ICamLectureService camLectureService ;

    @Resource
    private ICityService cityService;
    @Resource
    private ICompanyService companyService;
    @RequestMapping("/selectCom.do")
    public String selectCom(HttpServletRequest request, HttpServletResponse response, Model model
    ) throws IOException, ParseException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        CamLecture param =new CamLecture();
        Object object=request.getSession().getAttribute("user");
        User user=new User();
        if(object!=null) {
            user=(User)object;
            param.setCity(user.getCity());
        }
        else
            param.setCity(1);
        Date date=new Date();
        param.setCamDate(date);
        ArrayList<CamLecture> camList= new ArrayList<CamLecture>();
        camList=camLectureService.getAllCam(param);
        ArrayList<Company> comList=new ArrayList<>();
        comList=companyService.getAllCom();
        model.addAttribute("comList",comList);
        model.addAttribute("camList",camList);
        return "showCamLecture";
    }
    @RequestMapping("showDetails")
    public String showDetails(HttpServletRequest request, HttpServletResponse response,CamLecture camLecture, Model model) throws ParseException {
        camLecture.setId(Long.parseLong(request.getParameter("id")));
        camLecture.setTheme(request.getParameter("theme"));
        camLecture.setAddress(request.getParameter("address"));
        camLecture.setCity(Long.parseLong(request.getParameter("city")));
        camLecture.setContent(request.getParameter("content"));
        camLecture.setPosition(request.getParameter("position"));
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date=sdf2.parse(sdf2.format(sdf1.parse(request.getParameter("camDate"))));;
        camLecture.setCamDate(date);
        camLecture.setRef1(request.getParameter("ref1"));
        model.addAttribute(camLecture);
        return "camLecture/showCamLetureDetails";
    }

    /*
    * 管理员：跳转到新增页面
    * */
    @RequestMapping("/newCamAdmin")
    public String newCamAdmin(HttpServletRequest request,HttpServletResponse response,Model model){
        ArrayList<City> cityList=cityService.getAllCity();
        ArrayList<Company> comList=companyService.getAllCom();
        model.addAttribute("cityList",cityList);
        model.addAttribute("comList",comList);
        return "admin/addCamLecture";
    }
    /*
    *
    * 管理员添加宣讲会信息
    * */
    @RequestMapping("/addCam.do")
    public String addCam(HttpServletRequest request,
                         HttpServletResponse response,
                         Model model,CamLecture camLecture) throws ParseException {
        String message;
        CamLecture camLecture1=camLectureService.getCam(camLecture);
        if(camLecture1!=null){
            message="该记录已存在，请重新输入！";
            model.addAttribute("message",message);
            return "redirect:/CamLecture/newCamAdmin";
        }else {
            Date date;
            String d=request.getParameter("camDate1");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            date = sf.parse(d);
            camLecture.setCamDate(date);
            int result=camLectureService.insertCam(camLecture);
            if(result==0){
                message="添加失败，请重新输入";
                model.addAttribute("message",message);
                return "redirect:/CamLecture/newCamAdmin";
            }else{
                message="添加成功";
                ArrayList<CamLecture> camList=new ArrayList<>();
                camList=camLectureService.getAllCam(camLecture);
                model.addAttribute("camList",camList);
                model.addAttribute("message",message);
                return "admin/showCamList";
            }
        }
    }

    /*
    * 管理员获取所有宣讲会信息
    * */
    @RequestMapping("getAllAdmin")
    public String getAllAdmin(HttpServletRequest request,HttpServletResponse response ,Model model,CamLecture camLecture){
        User user=(User)request.getSession().getAttribute("user");
        String message;
        if(!user.getRole().equals("admin")){
            message="对不起，您没有权限";
            model.addAttribute("message",message);
            return "admin/error";
        }
        if(camLecture.getCity()==0) {
            camLecture.setCity(1);
        }
        if(camLecture.getCamDate()==null){
            Date date=new Date();
            camLecture.setCamDate(date);
        }
        ArrayList<City> cityList=new ArrayList<>();
        cityList=cityService.getAllCity();
        ArrayList<Company> comList = new ArrayList<>();
        comList=companyService.getAllCom();
        ArrayList<CamLecture> camList=new ArrayList<>();
        camList=camLectureService.getAllCam(camLecture);
        model.addAttribute("camList",camList);
        model.addAttribute("comList",comList);
        model.addAttribute("cityList",cityList);
        return "admin/showCamList";
    }

    @RequestMapping("/deleteCamAdmin")
    public String deleteCam(HttpServletRequest request,HttpServletResponse response,Model model,CamLecture camLecture){
        Long id=Long.parseLong(request.getParameter("id"));
        int result=camLectureService.delete(id);
        String message;
        if(result==0){
            message="删除失败";
        }
        else
            message="删除成功";
        if(camLecture.getCity()==0) {
            camLecture.setCity(1);
        }
        if(camLecture.getCamDate()==null){
            Date date=new Date();
            camLecture.setCamDate(date);
        }

        ArrayList<CamLecture> camList=new ArrayList<>();
        camList=camLectureService.getAllCam(camLecture);
        model.addAttribute("camList",camList);
        return "admin/showCamList";
    }

    @RequestMapping("editCamAdmin")
    public String editCamLure(HttpServletRequest request,HttpServletResponse response,Model model,CamLecture camLecture) throws ParseException {
        camLecture.setId(Long.parseLong(request.getParameter("id")));
        camLecture.setTheme(request.getParameter("theme"));
        camLecture.setAddress(request.getParameter("address"));
        camLecture.setCity(Long.parseLong(request.getParameter("city")));
        camLecture.setContent(request.getParameter("content"));
        camLecture.setPosition(request.getParameter("position"));
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date=sdf2.parse(sdf2.format(sdf1.parse(request.getParameter("camDate"))));
        camLecture.setCamDate(date);
        camLecture.setRef1(request.getParameter("ref1"));
        model.addAttribute(camLecture);
        ArrayList<City> cityList=cityService.getAllCity();
        ArrayList<Company> comList=companyService.getAllCom();
        model.addAttribute("cityList",cityList);
        model.addAttribute("comList",comList);

        return "admin/editCamLecture";
    }

    @RequestMapping("updateCamAdmin")
    public String updateCam(HttpServletRequest request,HttpServletResponse response,Model model,CamLecture camLecture) throws ParseException {
        Date date;
        String d=request.getParameter("camDate1");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date = sf.parse(d);
        camLecture.setCamDate(date);
        int result=camLectureService.update(camLecture);
        return "redirect:/CamLecture/getAllAdmin";
    }
}
