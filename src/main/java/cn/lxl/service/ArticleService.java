package cn.lxl.service;

import cn.lxl.bean.Article;
import cn.lxl.bean.Cate;
import cn.lxl.mapper.ArticleMapper;
import cn.lxl.mapper.CateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public List<Article> getArticleAll() {
        return articleMapper.getArticleAll();
    }

    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }


    public void update(Article article) {
        articleMapper.update(article);
    }
}
