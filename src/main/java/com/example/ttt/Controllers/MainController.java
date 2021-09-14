package com.example.ttt.Controllers;

import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/vehicle")
    public String vehicle( Model model) {

        return "vehicle";
    }

    @GetMapping("/vehicle/search")
    public String search( Model model) {
        // model.addAttribute("name", name);
        return "search";
    }

    @GetMapping("/vehicle/types")
    public String types( Model model) {
        // model.addAttribute("name", name);
        return "types";
    }



}