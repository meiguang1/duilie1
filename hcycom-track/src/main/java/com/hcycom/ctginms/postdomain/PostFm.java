package com.hcycom.ctginms.postdomain;

public class PostFm {

    private Object select;
    private int likeSelect;
    private int likeSelectOne;

    public Object getSelect() {
        return select;
    }

    public void setSelect(Object select) {
        this.select = select;
    }

    public int getLikeSelect() {
        return likeSelect;
    }

    public void setLikeSelect(int likeSelect) {
        this.likeSelect = likeSelect;
    }

    public int getLikeSelectOne() {
        return likeSelectOne;
    }

    public void setLikeSelectOne(int likeSelectOne) {
        this.likeSelectOne = likeSelectOne;
    }

    @Override
    public String toString() {
        return "PostFm{" +
            "select=" + select +
            ", likeSelect=" + likeSelect +
            ", likeSelectOne=" + likeSelectOne +
            '}';
    }
}
