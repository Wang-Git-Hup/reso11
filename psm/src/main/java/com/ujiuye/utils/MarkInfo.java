package com.ujiuye.utils;

import org.springframework.stereotype.Component;

public class MarkInfo {
    @Override
    public String toString() {
        return "MarkInfo{" +
                "id=" + id +
                ", mark=" + mark +
                ", pid=" + pid +
                ", eid=" + eid +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private  Integer  id;
    private  Integer   mark;
    private  Integer  pid;
    private Integer eid;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
