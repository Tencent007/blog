package com.lyw.blog.po;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity//和数据库建立对应关系
@Table(name = "t_type")//自动生成数据库表的名字
public class Type {

    //分类id
    @Id//代表主键
    @GeneratedValue//生成策略，自动生成
    private Long id;
    //分类name
    @NotBlank(message="分类名称不能为空")
    private String name;

    //和Blog类的映射关系
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();

    //空的构造方法
    public Type() {
    }

    //get和set方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
