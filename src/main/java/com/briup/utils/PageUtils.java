package com.briup.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageUtils {
    @RequestMapping("/toPage" +
            "" +
            "" +
            "")
    public String toPage(String url) {
        return url;
    }
}
