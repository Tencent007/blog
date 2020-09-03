package com.lyw.blog.dao;

import com.lyw.blog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    //根据name查询分类
    Type findByName(String name);

    //查询出所有分类但只显示前n条分类
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
