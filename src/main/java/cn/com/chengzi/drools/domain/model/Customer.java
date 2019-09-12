package cn.com.chengzi.drools.domain.model;

import lombok.Builder;
import lombok.Data;

/**
 * 说明:
 *
 * @author :chengzi
 * Create :2019/9/6 11:30
 */
@Data
@Builder
public class Customer {
    private String name;
    private Integer money;
    private Integer emptyBottle;
    private Integer drinkBottleSum;

    public Customer(String name, Integer money, Integer emptyBottle, Integer drinkBottleSum) {
        this.name = name;
        this.money = money;
        this.emptyBottle = emptyBottle;
        this.drinkBottleSum = drinkBottleSum;
    }

    public Customer() {
    }
}
