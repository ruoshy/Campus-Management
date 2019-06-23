package cn.ousky.smartcampus.model;

import cn.ousky.smartcampus.entity.Classroom;
import cn.ousky.smartcampus.entity.Course;
import cn.ousky.smartcampus.entity.Subadministrator;

import java.util.List;

public class CourseMInfo {
    private List<Course> courses;
    private Subadministrator subadmin;
    private Classroom classroom;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Subadministrator getSubadmin() {
        return subadmin;
    }

    public void setSubadmin(Subadministrator subadmin) {
        this.subadmin = subadmin;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
