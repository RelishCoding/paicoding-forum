package com.paicoding.web.front.home.helper;

import com.paicoding.api.model.vo.article.dto.CategoryDTO;
import com.paicoding.service.article.service.CategoryService;
import com.paicoding.web.front.home.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 首页推荐相关
 */
@Component
public class IndexRecommendHelper {
    @Autowired
    private CategoryService categoryService;


    public IndexVO buildIndexVO(String activeTab) {
        IndexVO vo = new IndexVO();
        CategoryDTO category = categories(activeTab, vo);
        vo.setCategoryId(category.getCategoryId());
        vo.setCurrentCategory(category.getCategory());
        return vo;
    }

    /**
     * 返回分类列表
     * @param active 选中的分类
     * @param vo     返回结果
     * @return       返回选中的分类，当没有匹配时，返回默认的全部分类
     */
    public CategoryDTO categories(String active, IndexVO vo) {
        return null;
    }
}
