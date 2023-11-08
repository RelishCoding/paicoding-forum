package com.paicoding.api.model.vo.article.dto;

import com.paicoding.api.model.enums.PushStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    public static final String DEFAULT_TOTAL_CATEGORY = "全部";
    public static final CategoryDTO DEFAULT_CATEGORY = new CategoryDTO(0L,"全部");

    private Long categoryId;
    private String category;
    private Integer rank;
    private Integer status;
    private Boolean selected;

    public CategoryDTO(Long categoryId, String category) {
        this(categoryId, category, 0);
    }

    public CategoryDTO(Long categoryId, String category, Integer rank) {
        this.categoryId = categoryId;
        this.category = category;
        this.status = PushStatusEnum.OFFLINE.getCode();
        this.rank = rank;
        this.selected = false;
    }
}
