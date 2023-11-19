package com.paicoding.service.article.service.impl;

import com.paicoding.service.article.repository.dao.ArticleDao;
import com.paicoding.service.article.service.ArticleReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 文章查询相关服务类
 */
@Service
public class ArticleReadServiceImpl implements ArticleReadService {
    @Autowired
    private ArticleDao articleDao;

    /**
     * 根据分类统计文章计数
     * @return
     */
    @Override
    public Map<Long, Long> queryArticleCountsByCategory() {
        return articleDao.countArticleByCategoryId();
    }
}
