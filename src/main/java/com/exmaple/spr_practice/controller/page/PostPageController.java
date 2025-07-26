package com.exmaple.spr_practice.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return "post/" + page;
    }
}
