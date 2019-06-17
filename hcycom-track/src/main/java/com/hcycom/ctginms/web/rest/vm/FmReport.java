package com.hcycom.ctginms.web.rest.vm;

public class FmReport {

    private int id;
    private String pid;
    private String fnName;
    private String fnUrl;
    private String time;
    private String reportcode;
    private String reportname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFnName() {
        return fnName;
    }

    public void setFnName(String fnName) {
        this.fnName = fnName;
    }

    public String getFnUrl() {
        return fnUrl;
    }

    public void setFnUrl(String fnUrl) {
        this.fnUrl = fnUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "FmReport{" +
            "id=" + id +
            ", pid='" + pid + '\'' +
            ", fnName='" + fnName + '\'' +
            ", fnUrl='" + fnUrl + '\'' +
            ", time='" + time + '\'' +
            ", reportcode='" + reportcode + '\'' +
            ", reportname='" + reportname + '\'' +
            '}';
    }
}
