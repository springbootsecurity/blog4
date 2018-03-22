package cn.lxl.mapper;

import cn.lxl.bean.Article;
import cn.lxl.bean.Cate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {


     List<Article> getArticleAll() ;

     int addArticle(Article article);

    void update(Article article);
}
