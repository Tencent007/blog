package com.lyw.blog.service;

import com.lyw.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    //保存分类新增
    Type saveType(Type type);

    //根据id查询分类
    Type getType(Long id);

    //根据name查询分类
    Type getTypeByName(String name);

    //分页查询分类
    Page<Type> listType(Pageable pageable);

    //查询所有分类
    List<Type> listType();

    //前端博客首页的分类区域显示的前n个分类
    List<Type> listTypeTop(Integer size);

    //根据id更新分类
    Type updateType(Long id,Type type);

    //根据id删除分类
    void deleteType(Long id);
}
