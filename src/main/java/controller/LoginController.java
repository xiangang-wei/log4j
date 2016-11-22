package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiangang on 2016/11/22.
 */
@Controller
public class LoginController {



    @RequestMapping(value = "/login")
    public String login(){
        return "redirect:/success";
    }

    @RequestMapping(value = "/success")
    public ModelAndView success(HttpServletRequest request){
        return new ModelAndView("success").addObject("userName",request.getSession().getAttribute("user"));
    }

}
