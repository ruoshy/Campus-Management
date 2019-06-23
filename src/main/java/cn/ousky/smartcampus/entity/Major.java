package cn.ousky.smartcampus.entity;

import java.util.List;

public class Major {
    private Integer id;
    private String name;
    private Integer number;
    private Integer department_id;

    private Department department;
    private List<cn.ousky.smartcampus.entity.Classs> Classs;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<cn.ousky.smartcampus.entity.Classs> getClasss() {
        return Classs;
    }

    public void setClasss(List<cn.ousky.smartcampus.entity.Classs> classs) {
        Classs = classs;
    }
}
