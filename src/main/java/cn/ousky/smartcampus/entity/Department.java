package cn.ousky.smartcampus.entity;

import java.util.List;

public class Department {
    private Integer id;
    private String name;
    private Integer school_id;
    private Integer number;

    private School school;
    private List<Major> majors;
    private List<Subadministrator> subadministrator;
    private List<User> users;

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

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public List<Subadministrator> getSubadministrator() {
        return subadministrator;
    }

    public void setSubadministrator(List<Subadministrator> subadministrator) {
        this.subadministrator = subadministrator;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
