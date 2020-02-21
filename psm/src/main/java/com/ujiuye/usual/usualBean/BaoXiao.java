package com.ujiuye.usual.usualBean;

import com.ujiuye.emp.empBean.Employee;

import java.util.Date;

public class BaoXiao {
    private String bxid;

    private Employee employee;

    @Override
    public String
    toString() {
        return "BaoXiao{" +
                "bxid='" + bxid + '\'' +
                ", employee=" + employee +
                ", paymode='" + paymode + '\'' +
                ", totalmoney=" + totalmoney +
                ", bxtime=" + bxtime +
                ", bxremark='" + bxremark + '\'' +
                ", bxstatus=" + bxstatus +
                ", empFk=" + empFk +
                ", result='" + result + '\'' +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private String paymode;

    private Double totalmoney;

    private Date bxtime;

    private String bxremark;

    private Integer bxstatus=0;

    private Integer empFk;

    private String result;

    public String getBxid() {
        return bxid;
    }

    public void setBxid(String bxid) {
        this.bxid = bxid == null ? null : bxid.trim();
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode == null ? null : paymode.trim();
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getBxtime() {
        return bxtime;
    }

    public void setBxtime(Date bxtime) {
        this.bxtime = bxtime;
    }

    public String getBxremark() {
        return bxremark;
    }

    public void setBxremark(String bxremark) {
        this.bxremark = bxremark == null ? null : bxremark.trim();
    }

    public Integer getBxstatus() {
        return bxstatus;
    }

    public void setBxstatus(Integer bxstatus) {
        this.bxstatus = bxstatus;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}