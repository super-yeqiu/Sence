package com.sence.bean.request.chat;

import com.sence.bean.base.BaseRequestBean;

/**
 * Created by zwy on 2019/4/17.
 * package_name is com.sence.bean.request.chat
 * 描述:SenceGit
 */
public class RChatListIdBean extends BaseRequestBean {
    public RChatListIdBean(String uid, String u_to, String page, String id) {
        this.uid = uid;
        this.u_to = u_to;
        this.page = page;
        this.pagesize = "10";
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getU_to() {
        return u_to;
    }

    public void setU_to(String u_to) {
        this.u_to = u_to;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    private String uid;
    private String u_to;
    private String page;
    private String pagesize;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
