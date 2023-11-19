package com.paicoding.service.article.service;

import java.util.Map;

public interface ArticleReadService {
    /**
     * 根据分类统计文章计数
     * @return
     */
    Map<Long, Long> queryArticleCountsByCategory();
}
