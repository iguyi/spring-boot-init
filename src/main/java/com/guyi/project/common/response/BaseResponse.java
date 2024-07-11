package com.guyi.project.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用响应对象
 *
 * @param <D> 响应数据的类型
 * @author 孤诣
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<D> implements Serializable {
    /**
     * 返回状态码
     */
    @ApiModelProperty("返回状态码")
    private int code;

    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private D data;

    /**
     * 响应信息
     */
    @ApiModelProperty("响应信息")
    private String message;

    private static final long serialVersionUID = 7830512838023729592L;
}
