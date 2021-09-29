package com.example.ttt;

import com.example.ttt.Models.Post;
import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@SpringBootApplication
public class TttApplication {
	@Autowired
	private final PostRepository postRepository;

	public TttApplication(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TttApplication.class, args);

	}
/*
	@Scheduled(fixedRate = 1000)
	public void Pooist (@RequestBody Post newPost, @PathVariable UUID uuid) {
		Post newPost = postRepository.findById(uuid.randomUUID());
		newPost.setPrice(0);

		System.out.println(
				"Fixed rate task - " + System.currentTimeMillis() / 1000);
		 postRepository.save(newPost);
	}

*/


	/*
	@PostMapping()
	public List<Post> onApplicationEvent(@RequestBody Post user , ApplicationEvent event) {

		user.setVehicleType("test");
		user.setMarque("test");
		user.setModell("test@test.com");
		user.setEngine("1234567890");
		user.setEnginePowerBhp(23);
		user.setTopSpeedMph(444);
		user.setDatePurchase("test@test.com");
		user.setCostUsd(1111);
		user.setPrice(2222);
		user.setStatus("1234567890");

		postRepository.save(user);
	}
*/






}
