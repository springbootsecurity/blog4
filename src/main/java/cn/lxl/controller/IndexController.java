package cn.lxl.controller;

import cn.lxl.bean.BaseBean;
import cn.lxl.bean.Cate;
import cn.lxl.service.CateService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    CateService cateService;


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelAndView doLogin(String username, String password,HttpSession session ) {
        Subject subject = SecurityUtils.getSubject();
        ModelAndView mv = new ModelAndView();
        session.setAttribute("username","zhangsan");
        System.out.println(username);
        //判断是否已经登录
        if (subject.isAuthenticated()) {
            mv.setViewName("/index");
        } else {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //执行登录
            try {
                token.setRememberMe(true);
                //当执行登录时，框架会自动去调用Realm中的方法
                subject.login(token);
                mv.setViewName("/index");
            } catch (UnknownAccountException e) {
                mv.setViewName("/login");
                mv.addObject("error", "帐户名不存在");
            } catch (IncorrectCredentialsException e) {
                mv.setViewName("/login");
                mv.addObject("error", "密码不正确");
            } catch (AuthenticationException e) {
                mv.setViewName("/login");
                mv.addObject("error", e.getMessage());
            }
        }
        return mv;
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/top")
    public String top() {
        return "top";
    }

    @RequestMapping("/left")
    public String left() {
        return "left";
    }

    @RequestMapping("/center")
    public String center() {
        return "center";
    }

    @RequestMapping("/cateName")
    public ModelAndView cateName() {
        List<Cate> cates = cateService.getAllCate();
        ModelAndView mv = new ModelAndView("center");
        mv.addObject("cates", cates);
        return mv;
    }

    @RequestMapping("/addCate")
    @ResponseBody
    public BaseBean addCate(String cateName) {
         cateService.addCate(cateName);
            return new BaseBean("success","添加成功");

    }



    @RequestMapping("/refresh")
    public ModelAndView refresh() {
        ModelAndView mv = new ModelAndView("table");
        mv.addObject("cates",cateService.getAllCate());
        return mv;
    }
    @RequestMapping("/queryById")

    public ModelAndView queryById(int id) {
        ModelAndView mv = new ModelAndView("details");
        Cate cate = cateService.queryById(id);
        mv.addObject("cate",cate);
        return mv;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public BaseBean updateById(String cateName,int id) {

        int i = cateService.updateById(cateName, id);
        if(i==1){
            return new BaseBean("success","修改成功");
        }
        return new BaseBean("error","修改失败");
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    @ResponseBody
    public BaseBean deleteById(int id) {

        int i = cateService.deleteById(id);
        if(i==1){
            return new BaseBean("success","删除成功");
        }
        return new BaseBean("error","删除失败");
    }


}
