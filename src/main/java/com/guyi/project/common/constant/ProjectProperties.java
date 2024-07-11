package com.guyi.project.common.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 项目变量
 *
 * @author 孤诣
 */
@ConfigurationProperties("project")
@Data
public class ProjectProperties {
    /**
     * 盐值
     */
    private String salt;
}
