package com.code.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.lang.Integer;
import java.util.List;

/**
 * ClassName:Examinfo
 * Description: 题目实体类
 */
@TableName("Examinfo")
public class Examinfo {

    @TableId(type = IdType.AUTO) //主键自增
    /**
     * ID
     */
    private Integer id;
    /**
     * 题目
     */
    private String name;
    /**
     * 分数
     */
    private String fenshu;
    /**
     * 选项
     */
    private String xuanxiang;
    /**
     * 答案
     */
    private String answer;
    /**
     * 所属id
     */
    private String tid;
    /**
     * 备注
     */
    private String intro;
    /**
     * 时间
     */
    private String addtime;
    /**
     * 不映射数据库
     */
    @TableField(exist = false)
    private List xuanxiangMap;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFenshu() {
        return fenshu;
    }

    public void setFenshu(String fenshu) {
        this.fenshu = fenshu;
    }

    public String getXuanxiang() {
        return xuanxiang;
    }

    public void setXuanxiang(String xuanxiang) {
        this.xuanxiang = xuanxiang;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public List getXuanxiangMap() {
        return xuanxiangMap;
    }

    public void setXuanxiangMap(List xuanxiangMap) {
        this.xuanxiangMap = xuanxiangMap;
    }

    @Override
    public String toString() {
        return "Examinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fenshu='" + fenshu + '\'' +
                ", xuanxiang='" + xuanxiang + '\'' +
                ", answer='" + answer + '\'' +
                ", tid='" + tid + '\'' +
                ", intro='" + intro + '\'' +
                ", addtime='" + addtime + '\'' +
                ", xuanxiangMap=" + xuanxiangMap +
                '}';
    }
}
