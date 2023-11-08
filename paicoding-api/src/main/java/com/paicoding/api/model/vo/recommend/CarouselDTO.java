package com.paicoding.api.model.vo.recommend;

import lombok.Data;

@Data
public class CarouselDTO {
    //说明
    private String name;

    //图片地址
    private String imgUrl;

    //跳转地址
    private String actionUrl;
}
