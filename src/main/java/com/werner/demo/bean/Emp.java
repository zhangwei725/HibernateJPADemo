package com.werner.demo.bean;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;


public class Emp {
    @Id
    @GeneratedValue
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;

    @Basic
    @Column(name = "EMPNO")
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Basic
    @Column(name = "ENAME")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "JOB")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "MGR")
    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    @Basic
    @Column(name = "HIREDATE")
    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Basic
    @Column(name = "SAL")
    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Basic
    @Column(name = "COMM")
    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp emp = (Emp) o;

        if (empno != emp.empno) return false;
        if (ename != null ? !ename.equals(emp.ename) : emp.ename != null) return false;
        if (job != null ? !job.equals(emp.job) : emp.job != null) return false;
        if (mgr != null ? !mgr.equals(emp.mgr) : emp.mgr != null) return false;
        if (hiredate != null ? !hiredate.equals(emp.hiredate) : emp.hiredate != null) return false;
        if (sal != null ? !sal.equals(emp.sal) : emp.sal != null) return false;
        if (comm != null ? !comm.equals(emp.comm) : emp.comm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empno;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (mgr != null ? mgr.hashCode() : 0);
        result = 31 * result + (hiredate != null ? hiredate.hashCode() : 0);
        result = 31 * result + (sal != null ? sal.hashCode() : 0);
        result = 31 * result + (comm != null ? comm.hashCode() : 0);
        return result;
    }

}
