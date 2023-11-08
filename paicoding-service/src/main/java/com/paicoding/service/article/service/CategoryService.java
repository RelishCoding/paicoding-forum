package com.paicoding.service.article.service;

import com.paicoding.api.model.vo.article.dto.CategoryDTO;

import java.util.List;

/**
 * 标签Service
 */
public interface CategoryService {
    /**
     * 查询所有的分类
     * @return
     */
    List<CategoryDTO> loadAllCategories();
}
