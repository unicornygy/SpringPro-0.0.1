package com.unicorn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @RequestMapping(path = "/test")
    public String test(){
        return "news";
    }
}
