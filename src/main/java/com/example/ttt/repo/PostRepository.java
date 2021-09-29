package com.example.ttt.repo;

import com.example.ttt.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

}