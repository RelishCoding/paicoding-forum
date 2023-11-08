package com.paicoding.api.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageListVO<T> {
    //用户列表
    List<T> list;

    //是否有更多
    private Boolean hasMore;


}
