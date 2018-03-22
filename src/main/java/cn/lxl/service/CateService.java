package cn.lxl.service;

import cn.lxl.bean.Cate;
import cn.lxl.mapper.CateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CateService {
    @Autowired
    CateMapper cateMapper;
    public List<Cate> getAllCate() {
        return cateMapper.getAllCate();
    }

    public void addCate(String cateName) {
        cateMapper.addCate(cateName);
    }

    public Cate queryById(int id) {
        return cateMapper.queryById(id);
    }

    public int updateById(String cateName,int id) {
       return cateMapper.updateById(cateName,id);
    }

    public int deleteById(int id) {
        return cateMapper.deleteById(id);
    }
}
