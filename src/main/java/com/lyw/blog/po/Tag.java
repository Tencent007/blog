package com.lyw.blog.po;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity//和数据库建立对应关系
@Table(name = "t_tag")//自动生成数据库表的名字
public class Tag {

    //标签id
    @Id//代表主键
    @GeneratedValue//生成策略，自动生成
    private Long id;
    //标签name
    @NotBlank(message="标签名称不能为空")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

    //空的构造方法
    public Tag() {
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
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
