package com.paicoding.service.article.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paicoding.api.model.enums.PushStatusEnum;
import com.paicoding.api.model.enums.YesOrNoEnum;
import com.paicoding.service.article.repository.entity.CategoryDO;
import com.paicoding.service.article.repository.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类目service
 */
@Repository
public class CategoryDao extends ServiceImpl<CategoryMapper, CategoryDO> {
    public List<CategoryDO> listAllCategoriesFromDb() {
        return lambdaQuery()
                .eq(CategoryDO::getDeleted, YesOrNoEnum.NO.getCode())
                .eq(CategoryDO::getStatus, PushStatusEnum.ONLINE.getCode())
                .list();
    }
}
