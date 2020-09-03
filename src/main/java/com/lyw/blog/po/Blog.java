package com.lyw.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity//和数据库建立对应关系
@Table(name = "t_blog")//自动生成数据库表的名字
public class Blog {

    //博客id
    @Id//代表主键
    @GeneratedValue//生成策略，自动生成
    private Long id;
    //博客标题
    private String title;

    //博客内容
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    //博客首图
    private String firstPicture;
    //博客标记（原创、转载）
    private String flag;
    //博客浏览次数
    private Integer views;
    //赞赏是否开启
    private boolean appreciation;
    //转载声明是否开启
    private boolean shareStatement;
    //评论是否开启
    private boolean commentabled;
    //发布和草稿
    private boolean published;
    //是否推荐
    private boolean recommend;
    //博客创建时间
    @Temporal(TemporalType.TIMESTAMP)//数据库生成的时间的类型
    private Date createTime;
    //博客更新时间
    @Temporal(TemporalType.TIMESTAMP)//数据库生成的时间的类型
    private Date updateTime;

    //一个博客只能有一个类型（type）,而一个类型可以有多个博客（blog），所以是多对一
    @ManyToOne
    private Type type;

    //一个博客可以有多个标签（tag），而一个标签也可以有多个博客（blog），所以是多对多
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    //一个博客只能归属于一个用户（user）,而一个用户可以有多个博客（blog），所以是多对一
    @ManyToOne
    private User user;

    //一个博客可以有多条评论（comment），而一个comment只归属于一个博客（blog），所以是一对多
    @OneToMany(mappedBy = "blog")//多的一方是维护端
    private List<Comment> comments = new ArrayList<>();


    @Transient
    private String tagIds;

    //博客描述
    private String description;

    //空的构造方法
    public Blog() {
    }

    //set和get方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }

    //
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
