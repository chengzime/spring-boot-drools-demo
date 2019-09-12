package cn.com.chengzi.drools.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 说明: 阅读等级
 *
 * @author :chengzi
 * Create :2019/9/11 15:25
 */
@Data
@Builder
@AllArgsConstructor
@ToString
public class ReadingLevel {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 年级
     */
    private Integer grade;

    /**
     * FR值
     */
    private Integer fancyRead;

    /**
     * FR值评语
     */
    private String remark;

    /**
     * 阅读速度(每分钟)
     */
    private Integer readingSpeed;


    /**
     * 最小适读范围
     */
    private Integer readingMinFr;

    /**
     * 最大适读范围
     */
    private Integer readingMaxFr;
}
