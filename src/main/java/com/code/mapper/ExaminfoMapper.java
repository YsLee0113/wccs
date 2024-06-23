package com.code.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.code.entity.Examinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

//examinfo表的题目数据库操作
@Component
public interface ExaminfoMapper extends BaseMapper<Examinfo> {

    @Select("SELECT * FROM Examinfo where tid=#{tid} ORDER BY RAND() limit 10")
    public List<Examinfo> createExaminfo(@Param("tid") int tid);

}

