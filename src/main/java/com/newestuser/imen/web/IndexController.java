package com.newestuser.imen.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IndexController {

    /**
     * This endpoint serves the index page.
     */
    @GetMapping("/")
    public String index(Model model) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        Date currentDate = new Date();

        model.addAttribute("name", dateFormat.format(currentDate));

        return "index";
    }
}
