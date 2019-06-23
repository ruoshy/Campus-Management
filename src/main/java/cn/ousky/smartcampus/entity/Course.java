package cn.ousky.smartcampus.entity;

import java.util.List;

public class Course {
    private int id;
    private String name;
    private String sort_time;
    private int course_table_id;
    private int classroom_id;
    private int subadministrator_id;

    private List<Resources> resources;
    private Classroom classroom;
    private CourseTable courseTable;
    private Subadministrator subadministrator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort_time() {
        return sort_time;
    }

    public void setSort_time(String sort_time) {
        this.sort_time = sort_time;
    }

    public int getCourse_table_id() {
        return course_table_id;
    }

    public void setCourse_table_id(int course_table_id) {
        this.course_table_id = course_table_id;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public int getSubadministrator_id() {
        return subadministrator_id;
    }

    public void setSubadministrator_id(int subadministrator_id) {
        this.subadministrator_id = subadministrator_id;
    }

    public List<Resources> getResources() {
        return resources;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public CourseTable getCourseTable() {
        return courseTable;
    }

    public void setCourseTable(CourseTable courseTable) {
        this.courseTable = courseTable;
    }

    public Subadministrator getSubadministrator() {
        return subadministrator;
    }

    public void setSubadministrator(Subadministrator subadministrator) {
        this.subadministrator = subadministrator;
    }
}
