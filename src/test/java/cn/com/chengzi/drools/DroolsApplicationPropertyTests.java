package cn.com.chengzi.drools;

import cn.com.chengzi.drools.domain.model.User;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
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
public class DroolsApplicationPropertyTests {

    @Autowired
    private KieSession kieSession;

    /**
     * 优先级, salience 属性默认值为 0, 数值越大优先级越高
     * 同时它的值可以是一个负数.
     * 规则的salience 默认值为0，所以如果我们不手动设置规则的salience 属性，那么它的执行顺序是随机的.
     */
    @Test
    public void testSalience() {
        kieSession.fireAllRules();
    }

    /**
     * date-effective日期比较（小于等于）,小于等于当前时间执行
     * 需要注意的是Drools默认的时间格式是dd-MMM-yyyy的，也就是说你必须使用24-十一月-2018它才能识别，我为什么能使用yyyy-MM-dd呢，请参考上篇文章中进行自动配置时的getKieServices()方法
     */
    @Test
    public void testDateEffective() {
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("dateEffective"));
    }

    /**
     * date-expires 日期比较（大于）
     */
    @Test
    public void dateExpires() {
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("dateExpires"));
    }


    /**
     * 测试 禁用属性 enabled
     */
    @Test
    public void testEnabled() {
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("enabled"));
    }


    /**
     * 测试 全局变量
     */
    @Test
    public void testGlobal() {
        List list = new ArrayList();
        kieSession.setGlobal( "myGlobalList", list);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("Using a global"));
    }


    /**
     * 测试 on-loop
     * 不允许循环执行 no-loop : 定义当前的规则是否不允许多次循环执行，默认是 false，也就是当前的规则只要满足条件，可以无限次执行
     */
    @Test
    public void testOnLoopFalse() {
        User user = new User().setName("张三").setAge(0);
        kieSession.insert( user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("Using no-loop false"));
    }

    @Test
    public void testOnLoopTrue() {
        User user = new User().setName("张三").setAge(0);
        kieSession.insert( user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("Using no-loop true"));
    }

    @Test
    public void testOnLoopDefault() {
        User user = new User().setName("张三").setAge(0);
        kieSession.insert( user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("Using no-loop default"));
    }

}
