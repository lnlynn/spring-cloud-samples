package com.liuning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuning
 * @since 2020-08-18 23:26
 */
@RestController
public class TestController {

    @RequestMapping("/heart")
    public String heart() {
        return "Hello World";
    }
}
