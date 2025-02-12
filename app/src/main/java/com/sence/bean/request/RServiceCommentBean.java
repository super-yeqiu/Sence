package com.sence.bean.request;

import com.sence.bean.base.BaseImageRequestBean;

public class RServiceCommentBean extends BaseImageRequestBean {
    private String uid;
    private String sid;
    private String star;
    private String content;


    public RServiceCommentBean(String uid, String sid, String star, String content) {
        this.uid = uid;
        this.sid = sid;
        this.star = star;
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
