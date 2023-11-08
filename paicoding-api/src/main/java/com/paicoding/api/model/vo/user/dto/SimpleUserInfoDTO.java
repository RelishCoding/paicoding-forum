package com.paicoding.api.model.vo.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基本用户信息
 */
@Data
public class SimpleUserInfoDTO {
    @ApiModelProperty("作者ID")
    private Long userId;

    @ApiModelProperty("作者名")
    private String name;

    @ApiModelProperty("作者头像")
    private String avatar;

    @ApiModelProperty("作者简介")
    private String profile;
}
