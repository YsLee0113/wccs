package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.lang.Integer;

/**
 * ClassName:Scoreinfo
 * Description: 物品评分实体类
 */
@TableName("Scoreinfo2")
public class Scoreinfo2 {

    @TableId(type = IdType.AUTO) //主键自增
    /**
     * 数据编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private String uid;
    /**
     * 物品编号
     */
    private String tid;
    /**
     * 物品评分
     */
    private String score;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Scoreinfo{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", tid='" + tid + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
