package com.durex.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author gelong
 * @date 2020/9/29 23:56
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     * http://localhost:8088/swagger-ui.html     原路径
     * http://localhost:8088/doc.html     原路径
     *
     * @return ApiInfo
     */
    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档页标题
                .title("新闻·自媒体接口api")
                // 联系人信息
                .contact(new Contact("gelong",
                        "https://www.baidu.com",
                        "1119692964@qq.com"))
                // 详细信息
                .description("新闻·自媒体平台提供的api文档")
                // 文档版本号
                .version("1.0.1")
                // 网站地址
                .termsOfServiceUrl("https://www.baidu.com")
                .build();
    }

    /**
     * 配置swagger2核心配置 docket
     *
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {

        Predicate<RequestHandler> adminPredicate = RequestHandlerSelectors
                .basePackage("com.durex.admin.controller");
        Predicate<RequestHandler> articlePredicate = RequestHandlerSelectors
                .basePackage("com.durex.article.controller");
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors
                .basePackage("com.durex.user.controller");
        Predicate<RequestHandler> filesPredicate = RequestHandlerSelectors
                .basePackage("com.durex.files.controller");

        // 指定api类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // 用于定义api文档汇总信息
                .apiInfo(apiInfo())
                .select()
                .apis(Predicates.or(adminPredicate, articlePredicate, userPredicate, filesPredicate))
                // 所有controller
                .paths(PathSelectors.any())
                .build();
    }
}

