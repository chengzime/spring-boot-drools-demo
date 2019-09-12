package cn.com.chengzi.drools.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 说明: 阅读等级测试
 *
 * @author :chengzi
 * Create :2019/9/11 15:25
 */
@Data
@Builder
@AllArgsConstructor
@ToString
public class ReadingLevelTest {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 年级
     */
    private Integer grade;

    /**
     * 测评值
     */
    private Integer gearValue;

    /**
     * 总字数
     */
    private Integer totalWordsNum;

    /**
     * 总耗时
     */
    private Integer totalSecondTime;

    /**
     * 结果集合
     */
    private List<ReadingResult> resultList;
}
