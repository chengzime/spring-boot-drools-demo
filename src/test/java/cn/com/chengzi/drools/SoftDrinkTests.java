package cn.com.chengzi.drools;

import cn.com.chengzi.drools.domain.model.Customer;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明: 属性测试
 *
 * @author :chengzi
 * Create :2019/9/5 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoftDrinkTests {

    @Autowired
    private KieSession kieSession;

    @Test
    public void testSalience() {
        // ks.addEventListener( new DebugAgendaEventListener() );
        // ks.addEventListener( new DebugRuleRuntimeEventListener() );
        Customer customer = new Customer("刘能", 50, 0, 0);
        FactHandle insert = kieSession.insert(customer);
        int count = kieSession.fireAllRules();
        System.err.println("总执行了" + count + "条规则");
    }


}
