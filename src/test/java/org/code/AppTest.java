package org.code;

import static org.junit.Assert.assertTrue;

import com.code.StartApplication;
import com.code.entity.Scoreinfo;
import com.code.entity.Scoreinfo2;
import com.code.entity.Userinfo;
import com.code.mapper.Scoreinfo2Mapper;
import com.code.mapper.ScoreinfoMapper;
import com.code.mapper.UserinfoMapper;
import com.code.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class AppTest {

    @Autowired
    UserinfoMapper userinfoMapper;


    @Autowired
    Scoreinfo2Mapper scoreinfo2Mapper;

    @Test
    public void 生成评分数据() {

        for (int i = 1; i <=23; i++) {
            for (int j = 7; j <=23; j++) {
                int num = new Random().nextInt(5);
                if (num % 3 == 0) {
                    String s = "uid,tid,score";  //6,109,4.5
                    float score = CommonUtils.createFloatNum(1);
                    s = s.replace("uid", i + "");
                    s = s.replace("tid", j + "");
                    s = s.replace("score", score + "");
                    Scoreinfo2 scoreinfo = new Scoreinfo2();
                    scoreinfo.setUid(i + "");
                    scoreinfo.setTid(j + "");
                    scoreinfo.setScore(score + "");
                    scoreinfo2Mapper.insert(scoreinfo);
                    System.out.println(s);
                }
            }

        }
    }


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {


    }


    @Test
    public void test123() {
        List<Userinfo> userinfoList = userinfoMapper.selectByMap(null);
        for (Userinfo userinfo : userinfoList) {
            System.out.println("userinfo = " + userinfo);
        }

    }
}
