package com.guyi.project.model.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户响应参数
 *
 * @author 孤诣
 */
@Data
public class UserVO implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "昵称")
    private String userName;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String userAccount;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "头像")
    private String userAvatar;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 用户角色：user / admin
     */
    @ApiModelProperty(value = "用户角色")
    private String userRole;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public void setId(Long id) {
        this.id = id == null ? null : id.toString();
    }

    public void setId(String id) {
        this.id = id;
    }
}