package com.hcycom.ctginms.postdomain;

public class PostFmReport {

    private Object selectOne;
    private int eFiles;

    public Object getSelectOne() {
        return selectOne;
    }

    public void setSelectOne(Object selectOne) {
        this.selectOne = selectOne;
    }

    public int geteFiles() {
        return eFiles;
    }

    public void seteFiles(int eFiles) {
        this.eFiles = eFiles;
    }

    @Override
    public String toString() {
        return "PostFmReport{" +
            "selectOne=" + selectOne +
            ", eFiles=" + eFiles +
            '}';
    }
}
