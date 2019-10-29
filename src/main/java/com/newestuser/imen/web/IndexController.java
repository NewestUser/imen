package com.newestuser.imen.web;

import com.newestuser.imen.bgdate.BulgarianDate;
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

        Date gregorianDate = new Date();
        BulgarianDate bulgarianDate = new BulgarianDate();

        model.addAttribute("bulgarianDate", bulgarianDate.format(bulgarianDate.now()));
        model.addAttribute("gregorianDate", dateFormat.format(gregorianDate));

        return "index";
    }
}
