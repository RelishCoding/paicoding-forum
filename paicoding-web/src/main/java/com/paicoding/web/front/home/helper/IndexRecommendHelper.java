package com.paicoding.web.front.home.helper;

import com.paicoding.api.model.vo.article.dto.CategoryDTO;
import com.paicoding.service.article.service.ArticleReadService;
import com.paicoding.service.article.service.CategoryService;
import com.paicoding.web.front.home.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 首页推荐相关
 */
@Component
public class IndexRecommendHelper {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleReadService articleService;

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
    private CategoryDTO categories(String active, IndexVO vo) {
        List<CategoryDTO> allList = categoryService.loadAllCategories();
        // 查询所有分类的对应的文章数
        Map<Long, Long> articleCnt = articleService.queryArticleCountsByCategory();
        //过滤掉文章数为0的分类
        allList.removeIf(c -> articleCnt.getOrDefault(c.getCategoryId(), 0L) <= 0L);

        //刷新选中的分类
        AtomicReference<CategoryDTO> selectedArticle = new AtomicReference<>();
        allList.forEach(category -> {
            if (category.getCategory().equalsIgnoreCase(active)) {
                category.setSelected(true);
                selectedArticle.set(category);
            } else {
                category.setSelected(false);
            }
        });

        //添加默认的全部分类
        allList.add(0, new CategoryDTO(0L, CategoryDTO.DEFAULT_TOTAL_CATEGORY));
        if (selectedArticle.get() == null) {
            selectedArticle.set(allList.get(0));
            allList.get(0).setSelected(true);
        }

        vo.setCategories(allList);
        return selectedArticle.get();
    }
}
