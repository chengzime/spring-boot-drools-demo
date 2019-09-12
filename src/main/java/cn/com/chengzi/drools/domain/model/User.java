package cn.com.chengzi.drools.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 说明:
 *
 * @author :chengzi
 * Create :2019/9/5 14:08
 */
@Data
@Accessors(chain = true)
public class User {
    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 地址
     */
    private String location;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
