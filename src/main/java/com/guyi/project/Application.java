package com.guyi.project;

import com.guyi.project.common.constant.ProjectProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author 孤诣
 */
@SpringBootApplication
@MapperScan("com.guyi.project.mapper")
@EnableConfigurationProperties(ProjectProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
