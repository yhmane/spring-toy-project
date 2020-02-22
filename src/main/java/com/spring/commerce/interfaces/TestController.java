package com.spring.commerce.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hwang-yunho on 2020. 2. 2.
 * @project commerce
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LogManager.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello() {
        LOGGER.debug("debug level");
        LOGGER.info("info level");
        LOGGER.warn("warn level");
        LOGGER.error("error level");
        LOGGER.fatal("fatal level");
        return "hello world";
    }
}
