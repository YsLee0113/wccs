package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * ClassName:Studyinfo
 * Description: 学习记录实体类
 */
@TableName("Studyinfo")
public class Studyinfo {

    @TableId(type = IdType.AUTO) //主键自增
    /**
     * 编号
     */
    private Integer id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 课程编号
     */
    private String tid;
    /**
     * 课程名称
     */
    private String tname;
    /**
     * 学习时间
     */
    private String addtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }


}
