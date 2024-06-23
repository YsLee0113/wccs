package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * ClassName:Sortinfo
 * Description: 分类信息实体类
 */
@TableName("Sortinfo")
public class Sortinfo {

    /**
     * 分类编号
     */
    @TableId(type = IdType.AUTO) //主键自增
    private Integer sid;
    /**
     * 分类名称
     */
    private String sname;
    /**
     * 分类内容
     */
    private String scontent;
    /**
     * 分类备注
     */
    private String sremarker;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }

    public String getSremarker() {
        return sremarker;
    }

    public void setSremarker(String sremarker) {
        this.sremarker = sremarker;
    }


}
