package cn.com.chengzi.drools.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 说明: 阅读结果
 *
 * @author :chengzi
 * Create :2019/9/11 15:32
 */
@Data
@Builder
@AllArgsConstructor
@ToString
public class ReadingResult {
    /**
     * 索引
     */
    private Integer index;

    /**
     * 文章id
     */
    private Integer summaryId;

    /**
     * 字数
     */
    private Integer wordsNum;

    /**
     * FR 值
     */
    private Integer fancyRead;

    /**
     * 耗时
     */
    private Integer secondTime;

    /**
     * 难易程度( 难: -1, 合适: 0, 简单: 1)
     */
    private Integer status;

}
