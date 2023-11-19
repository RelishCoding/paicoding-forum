package com.paicoding.service.article.service.impl;

import com.google.common.cache.LoadingCache;
import com.paicoding.api.model.vo.article.dto.CategoryDTO;
import com.paicoding.service.article.conveter.ArticleConverter;
import com.paicoding.service.article.repository.dao.CategoryDao;
import com.paicoding.service.article.repository.entity.CategoryDO;
import com.paicoding.service.article.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 类目Service
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    /**
     * 分类数一般不会特别多，如编程领域可以预期的分类将不会超过30，所以可以做一个全量的内存缓存
     * TODO 后续可改为Guava -> Redis
     */
    private LoadingCache<Long, CategoryDTO> categoryCaches;

    private CategoryDao categoryDao;

    /**
     * 查询所有的分类
     * @return
     */
    @Override
    public List<CategoryDTO> loadAllCategories() {
        // 如果缓存中的分类数小于等于5，则刷新缓存
        if (categoryCaches.size() <= 5) {
            refreshCache();
        }
        // 将分类DTO对象转换为List，并删除无效分类（ID小于等于0），按照rank字段排序后返回
        List<CategoryDTO> list = new ArrayList<>(categoryCaches.asMap().values());
        list.removeIf(s -> s.getCategoryId() <= 0);
        list.sort(Comparator.comparingLong(CategoryDTO::getRank));
        return list;
    }

    /**
     * 刷新缓存
     */
    @Override
    public void refreshCache() {
        // 从数据库中获取所有分类DO对象
        List<CategoryDO> list = categoryDao.listAllCategoriesFromDb();
        // 清空缓存
        categoryCaches.invalidateAll();
        categoryCaches.cleanUp();
        // 将分类DO对象转换为DTO对象，并存入缓存
        list.forEach(s -> categoryCaches.put(s.getId(), ArticleConverter.toDto(s)));
    }
}
