package com.ujiuye.pro.proBean;

public class Attachment {
    private Integer id;

    private Integer proFk;

    private Project project;

    private String attname;

    private String attdis;

    private String remark;

    private String path;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProFk() {
        return proFk;
    }

    public void setProFk(Integer proFk) {
        this.proFk = proFk;
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public String getAttdis() {
        return attdis;
    }

    public void setAttdis(String attdis) {
        this.attdis = attdis == null ? null : attdis.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", proFk=" + proFk +
                ", project=" + project +
                ", attname='" + attname + '\'' +
                ", attdis='" + attdis + '\'' +
                ", remark='" + remark + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public void setPath(String path) {

        this.path = path == null ? null : path.trim();
    }
}