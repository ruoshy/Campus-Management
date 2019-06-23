package cn.ousky.smartcampus.entity;

import java.util.List;

public class Administrators {
    private Integer id;
    private String name;
    private String user;
    private String password;
    private Integer school_id;

    private List<News> news;
    private List<Subadministrator> Subadministrators;
    private School school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Subadministrator> getSubadministrators() {
        return Subadministrators;
    }

    public void setSubadministrators(List<Subadministrator> subadministrators) {
        Subadministrators = subadministrators;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
