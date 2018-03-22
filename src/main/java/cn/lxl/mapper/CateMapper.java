package cn.lxl.mapper;

import cn.lxl.bean.Cate;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CateMapper {


    public List<Cate> getAllCate() ;



    void addCate(String cateName);

    Cate queryById(int id);

    int updateById(@Param("cateName") String cateName,@Param("id") int id);

    int deleteById(int id);
}
