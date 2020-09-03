package com.lyw.blog.service;

import com.lyw.blog.NotFoundException;
import com.lyw.blog.dao.TypeRepository;
import com.lyw.blog.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    //注入TypeRepository
    @Autowired
    private TypeRepository typeRepository;

    //实现根据name查询分类的方法
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    //实现新增方法
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    //实现根据id查询分类的方法
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    //实现分页显示分类的方法
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    //实现查询所有分类的方法
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    //实现前端博客首页的分类区域显示的前n个分类的方法
    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size, sort);
        return typeRepository.findTop(pageable);
    }

    //实现根据id进行更新的方法
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).get();
        if(t == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);

        return typeRepository.save(t);
    }

    //实现根据id进行删除的方法
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
