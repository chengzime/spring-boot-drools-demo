package cn.com.chengzi.drools.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 说明:
 *
 * @author :chengzi
 * Create :2019/9/5 11:12
 */
@Data
@Accessors(chain = true)
public class Product {
    /**
     * 钻石
     */
    public static final String DIAMOND = "DIAMOND";
    /**
     * 黄金
     */
    public static final String GOLD = "GOLD";

    private String type;

    private int discount;

}
