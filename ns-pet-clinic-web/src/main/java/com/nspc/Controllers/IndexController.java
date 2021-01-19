package com.nspc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"","/","index","index.html"})
    public String index(Model model){
        model.addAttribute("message","Welcome to Pet Clinic");
        return "index";

    }
}
