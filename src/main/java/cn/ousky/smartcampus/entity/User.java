package cn.ousky.smartcampus.entity;

public class User {
    private Integer id;
    private String name;
    private String user;
    private String password;
    private String year;
    private Integer school_id;
    private Integer classs_id;
    private Integer department_id;

    private Classs Classs;
    private School school;
    private Department department;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Integer getClasss_id() {
        return classs_id;
    }

    public void setClasss_id(Integer classs_id) {
        this.classs_id = classs_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public cn.ousky.smartcampus.entity.Classs getClasss() {
        return Classs;
    }

    public void setClasss(cn.ousky.smartcampus.entity.Classs classs) {
        Classs = classs;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
