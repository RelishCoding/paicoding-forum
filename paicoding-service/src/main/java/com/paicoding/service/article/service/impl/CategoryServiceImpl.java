package com.paicoding.service.article.service.impl;

import com.paicoding.api.model.vo.article.dto.CategoryDTO;
import com.paicoding.service.article.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目Service
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<CategoryDTO> loadAllCategories() {
        return null;
    }
}
