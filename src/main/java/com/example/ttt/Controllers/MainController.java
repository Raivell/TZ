package com.example.ttt.Controllers;

import com.example.ttt.Models.Post;
import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {

    //переменная которая ссылается на наш репозиторий
    @Autowired
    private final PostRepository postRepository;

    MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    //добавить купленное тс в бд сервиса
    @PostMapping("/vehicle")
    Post newPost(@RequestBody Post newPost) {
        return postRepository.save(newPost);
    }

    @PutMapping("/vehicle")
    Post newPost(@RequestBody Post newPost, @PathVariable UUID uuid) {

        return postRepository.findById(uuid)
                .map(post -> {
                    post.setVehicleType(newPost.getVehicleType());
                    post.setMarque(newPost.getMarque());
                    post.setModell(newPost.getModell());
                    post.setEngine(newPost.getEngine());
                    post.setEnginePowerBhp(newPost.getEnginePowerBhp());
                    post.setTopSpeedMph(newPost.getTopSpeedMph());
                    post.setDatePurchase(newPost.getDatePurchase());
                    post.setCostUsd(newPost.getCostUsd());
                    post.setPrice(newPost.getPrice());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
                    newPost.setUuid(uuid);
                    return postRepository.save(newPost);
                });
    }

    @GetMapping("/vehicle/search")
    List<Post> all() {
        return postRepository.findAll();
    }

// работает
    @GetMapping("/vehicle/{uuid}")
    Post one(@PathVariable UUID uuid) {
        return postRepository.findById(uuid).get();
    }



    @GetMapping("/vehicle/types")
    public String types( Model model) {
        // model.addAttribute("name", name);
        return "types";
    }


}