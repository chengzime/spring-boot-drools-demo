package cn.com.chengzi.drools;

import cn.com.chengzi.drools.domain.model.User;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 说明: 函数测试
 *
 * @author :chengzi
 * Create :2019/9/5 14:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationFunctionTests {

    @Autowired
    private KieSession kieSession;

    /**
     * 测试 CRUD 函数
     */
    @Test
    public void testCRUD() {
        kieSession.fireAllRules();
    }

    /**
     * 测试函数
     */
    @Test
    public void testFunction() {
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("using a static function"));
    }


    /**
     * 测试 query query是一种搜索工作内存中与指定条件匹配的事实的简单方法.
     */
    @Test
    public void testQuery() {
        QueryResults results = kieSession.getQueryResults( "user over the age of 30" );
        System.out.println( "we have " + results.size() + " user over the age  of 30" );

        System.out.println( "These people are are over 30:" );

        for ( QueryResultsRow row : results ) {
            User user = ( User ) row.get( "user" );
            System.out.println( user.getName() + "\n" );
        }
    }


}
