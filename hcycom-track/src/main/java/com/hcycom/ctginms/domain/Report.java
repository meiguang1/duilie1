package com.hcycom.ctginms.domain;

public class Report {
    private int id;
    private String reportcode;
    private String reportname;
    private String pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportcode() {
        return reportcode;
    }

    public void setReportcode(String reportcode) {
        this.reportcode = reportcode;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Report{" +
            "id=" + id +
            ", reportcode='" + reportcode + '\'' +
            ", reportname='" + reportname + '\'' +
            ", pid='" + pid + '\'' +
            '}';
    }
}
