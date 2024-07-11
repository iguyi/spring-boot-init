package com.guyi.project.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求参数
 *
 * @author 孤诣
 */
@Data
public class PageRequest implements Serializable {
    /**
     * 页面大小
     */
    @ApiModelProperty("单页数据量")
    protected Integer pageSize = 10;

    /**
     * 页码
     */
    @ApiModelProperty("页码")
    protected Integer pageNum = 1;

    /**
     * 判断分页请求参数是否存在无效值
     *
     * @return 如果返回值为 true, 则表示请求参数是无效的
     */
    public static boolean notValid(PageRequest pageRequest) {
        if (pageRequest == null) {
            return true;
        }
        Integer pageSize = pageRequest.getPageSize();
        if (pageSize == null || pageSize <= 0) {
            return true;
        }
        Integer pageNum = pageRequest.getPageNum();
        return !(pageNum != null && pageNum > 0);
    }

    private static final long serialVersionUID = -2335274422041011676L;
}
