package com.example.ttt;

import com.example.ttt.Models.Post;
import com.example.ttt.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;



@SpringBootApplication
public class TttApplication {
	@Autowired
	private final PostRepository postRepository;

	public TttApplication(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

	public static void main(String[] args) {
		SpringApplication.run(TttApplication.class, args);

	}


//При запуске сервиса в случае, если в БД нет ни одного типа ТС, добавить следующие типы ТС
	@Bean
	public CommandLineRunner run(PostRepository postRepository) throws Exception {
		return (String[] args) -> {

			if (postRepository.findAll().isEmpty()) {

				Post post1 = new Post("jet", "bmw", "a8", "bm2", 380, 144, "2019-02-03 10:08:02",timeStamp, 150000, 200000, "stock");
				Post post2 = new Post("ship", "bmw2", "a82", "bm22", 380, 144, "2019-02-03 10:08:02",timeStamp, 150000, 200000, "sold");
				Post post3 = new Post("helicopter", "bmw2", "a82", "bm22", 380, 144, "2019-02-03 10:08:02",timeStamp, 150000, 200000, "sold");
				Post post4 = new Post("supercar", "Kawasaki", "R2", "bm22", 380, 144, "2019-02-03 10:08:02",timeStamp, 150000, 200000, "sold");
				postRepository.save(post1);
				postRepository.save(post2);
				postRepository.save(post3);
				postRepository.save(post4);
				System.out.println("Первичные записи созданы: " + timeStamp);
			}
		};
	}



}
