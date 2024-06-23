package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * ClassName:Homework
 * Description: 作业信息实体类
 */
@TableName("Homework")
public class Homework {

    @TableId(type = IdType.AUTO) //主键自增
    /**
     * 作业编号
     */
    private Integer swid;
    /**
     * 作业名称
     */
    private String swname;
    /**
     * 作业内容
     */
    private String swcontent;
    /**
     * 作业分数
     */
    private String swscore;
    /**
     * 作业备注
     */
    private String swintro;
    /**
     * 提交用户
     */
    private String swuser;
    /**
     * 提交时间
     */
    private String swtime;


    public Integer getSwid() {
        return swid;
    }

    public void setSwid(Integer swid) {
        this.swid = swid;
    }

    public String getSwname() {
        return swname;
    }

    public void setSwname(String swname) {
        this.swname = swname;
    }

    public String getSwcontent() {
        return swcontent;
    }

    public void setSwcontent(String swcontent) {
        this.swcontent = swcontent;
    }

    public String getSwscore() {
        return swscore;
    }

    public void setSwscore(String swscore) {
        this.swscore = swscore;
    }

    public String getSwintro() {
        return swintro;
    }

    public void setSwintro(String swintro) {
        this.swintro = swintro;
    }

    public String getSwuser() {
        return swuser;
    }

    public void setSwuser(String swuser) {
        this.swuser = swuser;
    }

    public String getSwtime() {
        return swtime;
    }

    public void setSwtime(String swtime) {
        this.swtime = swtime;
    }


}
