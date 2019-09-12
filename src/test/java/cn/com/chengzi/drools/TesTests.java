package cn.com.chengzi.drools;

import cn.com.chengzi.drools.domain.model.ReadingLevel;
import cn.com.chengzi.drools.domain.model.ReadingLevelTest;
import cn.com.chengzi.drools.domain.model.ReadingResult;
import cn.com.chengzi.drools.domain.util.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 *
 * @author :chengzi
 * Create :2019/9/11 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TesTests {

    @Autowired
    private KieSession kieSession;

    /**
     * 测试
     */
    @Test
    public void test() {
        ReadingLevelTest readingLevelTest = new ReadingLevelTest(1,1,null,null,null,null);
        List<ReadingResult> resultList = new ArrayList<>(3);
        resultList.add(new ReadingResult(1,1,1000,400,180,1));
        resultList.add(new ReadingResult(2,2,1000,400,180,1));
        resultList.add(new ReadingResult(3,3,1000,400,180,1));
        readingLevelTest.setResultList(resultList);
        kieSession.insert(readingLevelTest);
        ReadingLevel readingLevel = new ReadingLevel(readingLevelTest.getUserId(),readingLevelTest.getGrade(),null,null,null,null,null);
        kieSession.insert(readingLevel);
        kieSession.fireAllRules();
        System.err.println("用户: " + readingLevel.getUserId()
                + " 当前为: " + readingLevel.getGrade()
                + "年级, FR值为: " + readingLevel.getFancyRead()
                + ", 试读范围为: FR" + readingLevel.getReadingMinFr()
                + " 到 FR" + readingLevel.getReadingMaxFr()
                + " 之间, 在当前年级中相对: " + readingLevel.getRemark()
                + "读速为: " + readingLevel.getReadingSpeed() + "字/分钟"
        );
    }


    @Test
    public void randomTest(){
        Integer from = -10;
        Integer to = 10;
        for (int i = 0; i < 1000; i++) {
            Integer random = RandomUtil.randomFromTo(from, to);
            System.out.println(random);
            if(random < from || random > to){
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::----- :" + random);
            }
        }
    }
}
