package com.example.ttt.Controllers;


import com.example.ttt.Models.Post;
import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
public class MainController {

    //переменная которая ссылается на наш репозиторий
    @Autowired
    private final PostRepository postRepository;

    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }



    //Назначение функции api: Добавить купленное ТС в БД сервиса
    @PostMapping("/vehicle")
    Post newPost(@RequestBody Post newPost) {
        System.out.println("Enter Post");
        if(newPost.getStatus() == null){newPost.setStatus("in stock");}
        if(newPost.getVehicleType() == null){newPost.setVehicleType("default");}
        if(newPost.getMarque() == null){newPost.setMarque("default");}

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        newPost.setDateInsert(timeStamp);

        return postRepository.save(newPost);
    }

    //Назначение функции api: Обновить ТС в БД сервиса
    @PutMapping("/vehicle")
    public ResponseEntity< Post > updatePost(@RequestBody Post post) throws
            URISyntaxException {
        System.out.println("Enter Put");
        if (post.getUuid() == null) {
            throw new ResourceNotFoundException("User id should not be null ");
        }

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        post.setDateInsert(timeStamp);

        Post result = postRepository.save(post);
        return ResponseEntity.ok().body(result);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }

        public ResourceNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /*
    @GetMapping("/vehicle/search")
    @ResponseBody
    public ResponseEntity<Post> sea(@RequestBody Post newEmployee,@RequestParam(value = "/vehicle/search", required = false) String vehicleType,
                                    @RequestParam(value = "marque", required = false) String marque,
                                    @RequestParam(value = "modell", required = false) String modell,
                                    @RequestParam(value = "engine", required = false) String engine,
                                    @RequestParam(value = "status", required = false) String status) {
        System.out.println("Enter Get");
        return postRepository.findAll()
                .get(post -> {
                    post.setVehicleType(newEmployee.getVehicleType());
                   // post.setRole(newEmployee.getRole());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return postRepository.findAll((Pageable) newEmployee);
                });
    }

    @GetMapping("/vehicle/search")
    Post two(@PathVariable String vehicleType,
             @PathVariable String marque,
             @PathVariable String modell,
             @PathVariable String engine,
             @PathVariable String status) {
        System.out.println("Enter doGet");
        return postRepository.findAll(vehicleType);.get();

    }
*/

    // Назначение функции api: Получение ТС из БД сервиса по guid ТС, присвоенному ему при создании записи
    @GetMapping("/vehicle/{uuid}")
    Optional<Post> one(@PathVariable UUID uuid) {
        System.out.println("Enter doGet");
        return postRepository.findById(uuid);

    }


}