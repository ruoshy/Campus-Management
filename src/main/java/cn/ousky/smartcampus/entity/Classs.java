package cn.ousky.smartcampus.entity;

import java.util.List;

public class Classs {
    private Integer id;
    private Integer number;
    private String year;
    private Integer course_table_id;
    private Integer major_id;

    private CourseTable courseTable;
    private Major major;
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getCourse_table_id() {
        return course_table_id;
    }

    public void setCourse_table_id(Integer course_table_id) {
        this.course_table_id = course_table_id;
    }

    public Integer getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }

    public CourseTable getCourseTable() {
        return courseTable;
    }

    public void setCourseTable(CourseTable courseTable) {
        this.courseTable = courseTable;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
