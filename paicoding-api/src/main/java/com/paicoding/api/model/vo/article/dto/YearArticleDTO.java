package com.paicoding.api.model.vo.article.dto;

import lombok.Data;

/**
 * 创作历程
 */
@Data
public class YearArticleDTO {
    //年份
    private String year;

    //文章数量
    private Integer articleCount;
}
