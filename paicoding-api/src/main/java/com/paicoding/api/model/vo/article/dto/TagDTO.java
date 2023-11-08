package com.paicoding.api.model.vo.article.dto;

import lombok.Data;

@Data
public class TagDTO {
    private Long tagId;
    private String tag;
    private Integer status;
    private Boolean selected;
}
