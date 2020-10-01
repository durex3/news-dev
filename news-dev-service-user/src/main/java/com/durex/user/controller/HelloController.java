package com.durex.user.controller;

import com.durex.api.controller.user.HelloControllerApi;
import com.durex.common.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gelong
 * @date 2020/9/29 22:19
 */
@RestController
public class HelloController implements HelloControllerApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Override
    public JsonResult hello() {
        LOGGER.debug("debug: hello~");
        LOGGER.info("info: hello~");
        LOGGER.warn("warn: hello~");
        LOGGER.error("error: hello~");
        return JsonResult.ok();
    }
}
