package cn.lxl.controller;

import cn.lxl.bean.Article;
import cn.lxl.bean.BaseBean;
import cn.lxl.bean.Cate;
import cn.lxl.service.ArticleService;
import cn.lxl.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CateService cateService;
    @RequestMapping("/getAll")
    public ModelAndView getArticleAll(){
        ModelAndView modelAndView = new ModelAndView("article_details");
        List<Article> articles = articleService.getArticleAll();
    if (articles!=null&&articles.size()!=0){
        modelAndView.addObject("articles",articles);
    }
        return modelAndView;

    }

    @RequestMapping("/rich_text")
    public  String rich_text(Model model){
        List<Cate> allCate = cateService.getAllCate();
        model.addAttribute("allCate",allCate);
        return "rich_text";
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public BaseBean addArticle(Article article){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishDate = simpleDateFormat.format(new Date());
        article.setPublishDate(publishDate);
        int i = articleService.addArticle(article);
        if (i==1){
            return new BaseBean("success","添加成功");
        }
        return new BaseBean("error","添加失败");
    }


    @RequestMapping("/queryById")
    public  String queryById(Model model,int id,String editorValue){

        Article article = null;
        List<Cate> allCate = cateService.getAllCate();
        List<Article> articleAll = articleService.getArticleAll();
        for (Article article1 : articleAll) {
            if(article1.getId()==(id)){
                article = article1;
            }
        }
        model.addAttribute("article",article);
        model.addAttribute("allCate",allCate);
        return "updata_details";
    }

    @RequestMapping("/update")
    @ResponseBody
    public  BaseBean update(Article article){
        System.out.println(article);
       articleService.update(article);

            return new BaseBean("success","修改成功");

    }
}
