package com.paicoding.api.model.vo.recommend;

import lombok.Data;

import java.util.List;

/**
 * 侧边栏推广信息
 */
@Data
public class SideBarDTO {
    private String title;

    private String subTitle;

    private String icon;

    private String img;

    private String url;

    private String content;

    private List<SideBarItemDTO> items;

    /**
     * 侧边栏样式
     * @See SidebarStyleEnum#getStyle()
     */
    private Integer style;
}
