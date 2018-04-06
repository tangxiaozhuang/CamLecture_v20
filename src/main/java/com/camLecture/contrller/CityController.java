package com.camLecture.contrller;

import com.camLecture.entity.City;
import com.camLecture.service.impl.CityServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/14.
 */
@Controller
@RequestMapping("/city")
public class CityController {
    @Resource
    private CityServiceImpl cityService;
    @RequestMapping("showCity")
    public String showCity(HttpServletRequest request, HttpServletResponse response, City city, Model model){
        ArrayList<City> cityList=cityService.getAllCity();
        model.addAttribute("cityList",cityList);
        return "/admin/showCityList";
    }
    @RequestMapping("addCity")
    public String addCity(HttpServletResponse response,HttpServletRequest request,Model model,City city){
        int result=cityService.insert(city);
        if(result==0){
            model.addAttribute("message","添加失败");
        }
        else{
            model.addAttribute("message","添加成功");
        }
        return "redirect:/city/showCity";
    }
    @RequestMapping("delete")
    public String deleteCity(HttpServletRequest request,HttpServletResponse response,Model model,City city){
        city.setId(Long.parseLong(request.getParameter("id")));
        int result=cityService.delete(city);
        if(result==0){
            model.addAttribute("message","删除失败");
        }
        else
            model.addAttribute("message","删除成功");
        return "redirect:/city/showCity";
    }

//    @RequestMapping("showCityList")
//    public String showCityList(HttpServletRequest request,HttpServletResponse response,Model model,City city){
//        ArrayList<City> cityList=new ArrayList<>();
//        cityList=cityService.getAllCity();
//        model.addAttribute("cityList",cityList);
//
//        return "showCityList";
//    }
//
}
