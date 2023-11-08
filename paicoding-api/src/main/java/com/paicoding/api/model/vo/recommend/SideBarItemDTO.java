package com.paicoding.api.model.vo.recommend;

import lombok.Data;

import java.util.List;

/**
 * 侧边栏推广信息
 */
@Data
public class SideBarItemDTO {
    private String title;

    private String name;

    private String url;

    private String img;

    private Long time;

    //tag列表
    private List<Integer> tags;

    //评分信息
    private RateVisitDTO visit;
}
