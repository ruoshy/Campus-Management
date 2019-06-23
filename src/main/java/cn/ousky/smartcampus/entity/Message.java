package cn.ousky.smartcampus.entity;

import java.util.Date;

public class Message {
    private Integer id;
    private String name;
    private String message;
    private Date date;
    private Integer subadministrator_id;

    private Subadministrator subadministrator;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSubadministrator_id() {
        return subadministrator_id;
    }

    public void setSubadministrator_id(Integer subadministrator_id) {
        this.subadministrator_id = subadministrator_id;
    }

    public Subadministrator getSubadministrator() {
        return subadministrator;
    }

    public void setSubadministrator(Subadministrator subadministrator) {
        this.subadministrator = subadministrator;
    }
}
