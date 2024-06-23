package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
* ClassName:Workinfo
* Description: 任务信息实体类
*/
@TableName("Workinfo")
public class Workinfo {

 @TableId(type = IdType.AUTO) //主键自增
    /**
    * 任务编号
    */
        private Integer wid;
    /**
    * 任务名称
    */
        private String wname;
    /**
    * 任务内容
    */
        private String wcontent;
    /**
    * 发布教师
    */
        private String wuser;
    /**
    * 发布时间
    */
        private String waddtime;


        public Integer getWid() {
        return wid;
        }

        public void setWid(Integer wid) {
        this.wid = wid;
        }

        public String getWname() {
        return wname;
        }

        public void setWname(String wname) {
        this.wname = wname;
        }

        public String getWcontent() {
        return wcontent;
        }

        public void setWcontent(String wcontent) {
        this.wcontent = wcontent;
        }

        public String getWuser() {
        return wuser;
        }

        public void setWuser(String wuser) {
        this.wuser = wuser;
        }

        public String getWaddtime() {
        return waddtime;
        }

        public void setWaddtime(String waddtime) {
        this.waddtime = waddtime;
        }


}
