package com.example.ttt.Controllers;

import com.example.ttt.Models.Post;
import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class MainController {

    //@Autowired для создания переменной которая ссылается на наш репозиторий
    @Autowired
    private final PostRepository postRepository;

    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;

    }



    /**
     * timeStamp передает в DateInsert время обновления записи.
     *
     * if(...){...} заполнение параметрами по умолчанию при их отсутствии.
     *
     * System.out.println Вывод информации о том какой метод использовался.
     */

    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

    //Назначение функции api: Добавить купленное ТС в БД сервиса
    @PostMapping("/vehicle")
    public Post newPost(@RequestBody Post newPost) {

        System.out.println("Enter Post");

        if(newPost.getStatus() == null){newPost.setStatus("in stock");}
        if(newPost.getVehicleType() == null){newPost.setVehicleType("default");}
        if(newPost.getMarque() == null){newPost.setMarque("default");}

        newPost.setDateInsert(timeStamp);

        return postRepository.save(newPost);
    }


    //Назначение функции api: Обновить ТС в БД сервиса
    @PutMapping("/vehicle")
    public ResponseEntity< Post > updatePost(@RequestBody Post newPost)  {
        System.out.println("Enter Put");

        if(newPost.getStatus() == null){newPost.setStatus("in stock");}

        newPost.setDateInsert(timeStamp);

        Post result = postRepository.save(newPost);
        return ResponseEntity.ok().body(result);
    }


    //Назначение функции api: Поиск ТС по заданным критериям в БД сервиса
    //необязательность параметров не реализована
    @GetMapping("/vehicle/search")
    public List<Post> getTechMembersNativeQuery(@RequestParam(name="vehicleType")String vehicleType,
                                                @RequestParam(name="marque", required = false) String marque,
                                                @RequestParam(name="model", required = false) String model,
                                                @RequestParam(name="engine", required = false) String engine,
                                                @RequestParam(name="status", required = false) String status ){

        System.out.println("Enter search");
        return postRepository.findTechMembersNativeQuery(vehicleType, marque, model, engine, status);

    }


    // Назначение функции api: Получение ТС из БД сервиса по guid ТС, присвоенному ему при создании записи
    @GetMapping("/vehicle/{uuid}")
    public Optional<Post> one(@PathVariable UUID uuid) {
        System.out.println("Enter doGet");
        return postRepository.findById(uuid);

    }




/*
    @GetMapping("/vehicle/types")
    public List<Post> two() {

        return postRepository.findWithCount();

    }

new StringBuilder(word).reverse().toString()
*/
}


