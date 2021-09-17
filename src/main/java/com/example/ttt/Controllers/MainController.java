package com.example.ttt.Controllers;

import com.example.ttt.Models.Post;
import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class MainController {

    //переменная которая ссылается на наш репозиторий
    @Autowired
    private PostRepository postRepository;



  /*  @PostMapping( "/vehicle")
    public String vehiclePost(@RequestParam String vehicleType,@RequestParam String marque,@RequestParam String modell, @RequestParam String engine, @RequestParam int enginePowerBhp, @RequestParam int topSpeedMph,@RequestParam String datePurchase,@RequestParam int costUsd,@RequestParam int price, Model model) {
        Post post = new Post( vehicleType,marque,modell,engine,enginePowerBhp,topSpeedMph,datePurchase,costUsd,price);
        postRepository.save(post);
        return "vehicle";
    }
*/

    //добавить купленное тс в бд сервиса
    @PostMapping("/vehicle")
    Post newPost(@RequestBody Post newPost) {
        return postRepository.save(newPost);
    }
/*
    @PutMapping("/vehicle/{uuid}")
    Post replaceEmployee(@RequestBody Post newPost, @PathVariable UUID uuid) {

        return PostRepository.findById(uuid)
                .map(post -> {
                    post.setVehicleType(newPost.getVehicleType());
                    post.setMarque(newPost.getMarque());
                    return PostRepository.save(post);
                })
                .orElseGet(() -> {
                    newPost.setUuid(uuid);
                    return PostRepository.save(newPost);
                });
    }

    @GetMapping("/employees/{guid}")
    Post one(@PathVariable UUID uuid) {

        return PostRepository.findById(uuid)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
*/

    @GetMapping("/vehicle/")
    public String vehicle( Model model) {

        return "vehicle";
    }

    @GetMapping("/vehicle/search")
    public String search( Model model) {

        return "search";
    }

    @GetMapping("/vehicle/types")
    public String types( Model model) {
        // model.addAttribute("name", name);
        return "types";
    }

    //поиск по гуид
    // Iterable<Post> posts = postRepository.findAllById();
    //  model.addAttribute("posts", posts);

}