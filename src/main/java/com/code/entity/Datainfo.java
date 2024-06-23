package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * ClassName:Datainfo
 * Description: 视频信息实体类
 */
@TableName("Datainfo")
public class Datainfo {

    @TableId(type = IdType.AUTO) //主键自增
    /**
     * 编号
     */
    private Integer dataid;
    /**
     * 名称
     */
    private String dataname;
    /**
     * 内容
     */
    private String datacontent;
    /**
     * 路径
     */
    private String dataurl;
    /**
     * 用户
     */
    private String datauser;
    /**
     * 简介
     */
    private String dataintro;
    /**
     * 备注
     */
    private String dataremarker;
    /**
     * 分类
     */
    private String datatype;
    /**
     * 时间
     */
    private String dataaddtime;


    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getDatacontent() {
        return datacontent;
    }

    public void setDatacontent(String datacontent) {
        this.datacontent = datacontent;
    }

    public String getDataurl() {
        return dataurl;
    }

    public void setDataurl(String dataurl) {
        this.dataurl = dataurl;
    }

    public String getDatauser() {
        return datauser;
    }

    public void setDatauser(String datauser) {
        this.datauser = datauser;
    }

    public String getDataintro() {
        return dataintro;
    }

    public void setDataintro(String dataintro) {
        this.dataintro = dataintro;
    }

    public String getDataremarker() {
        return dataremarker;
    }

    public void setDataremarker(String dataremarker) {
        this.dataremarker = dataremarker;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDataaddtime() {
        return dataaddtime;
    }

    public void setDataaddtime(String dataaddtime) {
        this.dataaddtime = dataaddtime;
    }


}
