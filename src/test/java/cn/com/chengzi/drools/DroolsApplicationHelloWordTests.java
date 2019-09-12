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
 * 说明: 基础测试
 *
 * @author :chengzi
 * Create :2019/9/5 14:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsApplicationHelloWordTests {

    @Autowired
    KieSession kieSession;

    /**
     * 执行全部规则
     */
    @Test
    public void testHelloWord() {
        kieSession.fireAllRules();
    }

    /**
     * 执行全部规则, 进行 java 对象修改
     */
    @Test
    public void testUser() {
        User user = new User("张三",18);
        kieSession.insert(user);
        kieSession.fireAllRules();
        System.err.println("规则执行完毕后张三变为了："+user.getName());
    }


    /**
     * 指定执行规则
     * RuleNameEndsWithAgendaFilter 实现了 AgendaFilter 中的 accept 来进行规则执行判定, 可以通过 实现 AgendaFilter 重写 accept 方法实现自己的执行规则的规则
     */
    @Test
    public void testOneRule() {
        User user=new User("张三",18);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("user"));
    }

    /**
     * 一个对象的某个字段是否包含另一个对象
     * not contains 相反
     */
    @Test
    public void testContains() {
        String name="张三";
        User user=new User("张三",18);
        kieSession.insert(name);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("contains"));
    }

    /**
     * 对象的某个字段是否存在于某个集合中
     * not memberOf 相反
     */
    @Test
    public void testMemberOf() {
        List<String> list=new ArrayList<>();
        list.add("张三");
        list.add("李四");
        User user=new User("李四",18);
        kieSession.insert(list);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("memberOf"));
    }

    /**
     * 正则表达式匹配
     * not matches 相反
     */
    @Test
    public void testMatches() {
        User user=new User("张三",18);
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("matches"));
    }


    /**
     * 测试 from from可以接受 service 的方法调用后的结果集，也可以指向一个对象或者一个集合
     */
    @Test
    public void testFrom() {
        List<User> list = new ArrayList<>();
        User user=new User("张三",18);
        list.add(user);
        kieSession.insert(list);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("from"));
    }
}
