package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * ClassName:Msginfo
 * Description: 评论信息实体类
 */
@TableName("Msginfo")
public class Msginfo {

    /**
     * 评论编号
     */
    @TableId(type = IdType.AUTO) //主键自增
    private Integer msgid;
    /**
     * 评论用户
     */
    private String msguser;
    /**
     * 评论内容
     */
    private String msgcontent;
    /**
     * 评论时间
     */
    private String msgaddtime; /**
     * 评论tid
     */
    private int tid;


    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getMsguser() {
        return msguser;
    }

    public void setMsguser(String msguser) {
        this.msguser = msguser;
    }

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }

    public String getMsgaddtime() {
        return msgaddtime;
    }

    public void setMsgaddtime(String msgaddtime) {
        this.msgaddtime = msgaddtime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
