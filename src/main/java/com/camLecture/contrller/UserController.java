package com.camLecture.contrller;

/**
 * Created by Administrator on 2018/3/6.
 */


import com.camLecture.entity.CamLecture;
import com.camLecture.entity.City;
import com.camLecture.entity.User;
import com.camLecture.service.ICityService;
import com.camLecture.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private ICityService cityService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        //User user = this.userService.selectUserByEmail(userId);
        ObjectMapper mapper = new ObjectMapper();
        //response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }
    @RequestMapping("/insert.do")
    public String insertUser(HttpServletRequest request,
                             HttpServletResponse response,
                             Model model,User user) throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user1=this.userService.selectUserByEmail(user);
        if(user1!=null){
            model.addAttribute("message","该邮箱已被注册");
            return "login/register";
        }
        user.setRole("root");
        long result=(long)this.userService.insertUser(user);
        user.setId(result);
        model.addAttribute("user",user);
        return "redirect:/CamLecture/selectCom.do";
    }
    @RequestMapping("/login.do")
    public String login(HttpServletRequest request,HttpServletResponse response,
                        RedirectAttributes attr,Model model,User user){
        if((user.getEmail()==null&&user.getEmail()=="")||
                (user.getPassword()==null&&user.getPassword()=="")){
            model.addAttribute("message","用户名或密码不能为空");
            return "login/login";
        }
        else{
        User result=this.userService.getUser(user);
        if(result==null){
            model.addAttribute("message","用户名或密码错误");
            return "login/login";
        }
        model.addAttribute("user", result);}
        return "redirect:/CamLecture/selectCom.do";
    }

    @RequestMapping("toAdminLogin")
    public String toAdminLogin(){
        return "login/adminLogin";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(HttpServletRequest request,HttpServletResponse
            response,RedirectAttributes attr,Model model,User user){
        User result=this.userService.getUser(user);
        if(result!=null&&result.getRole()!="admin"){
            model.addAttribute("user", result);

            return "redirect:/CamLecture/getAllAdmin";
        }else{
            String msg="登录失败";
            model.addAttribute("message",msg);
            return "login/adminLogin";
        }
    }

    @RequestMapping("addAdminUser")
    public String addAdminUser(HttpServletRequest request,
                               HttpServletResponse response,
                               Model model,User user){
        String message;
        user.setRole("admin");
        User tempUser=userService.selectUserByEmail(user);
        if(tempUser!=null){
            message="用户名已存在";
        }else{
        int result=userService.insertUser(user);
        if(result==0){
            message="添加失败，请重新添加。";
        }
        else{
            message="添加成功";
        }
        }
        model.addAttribute("message",message);
        return "admin/addAdminUser";
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request,HttpServletResponse response,Model model,User user){
        int result=userService.update(user);
        return "redirect:/user/redUserDetail";
    }

    @RequestMapping("editUser")
    public String editUser(HttpServletResponse response,HttpServletRequest request,Model model){
        ArrayList<City> cityList=cityService.getAllCity();
        model.addAttribute("cityList",cityList);
        return "user/userEdit";
    }

    @RequestMapping("redUserDetail")
    public String userDetail(HttpServletRequest request,HttpServletResponse response,Model model,City city){
        ArrayList<City> cityList=cityService.getAllCity();
        model.addAttribute("cityList",cityList);
        return "user/userDetail";
    }



    @RequestMapping("/register")
    public String register(HttpServletRequest request,HttpServletResponse response,Model model){
        ArrayList<City> cityList=new ArrayList<>();
        cityList=cityService.getAllCity();
        model.addAttribute("cityList",cityList);
        return "login/register";

    }
    @RequestMapping("redAddAdminUser")
    public String redAddAdminUser(HttpServletResponse response,HttpServletRequest request,Model model){
        return "admin/addAdminUser";
    }

    @RequestMapping("/redLogin")
    public String redLogin(){
        return "login/login";
    }

}