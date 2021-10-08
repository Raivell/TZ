package com.example.ttt.repo;

import com.example.ttt.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID>, CrudRepository<Post, UUID> {


    @Query(value="select * from POST  where vehicle_Type = :vehicleType AND Marque = :marque and Model = :model and Engine = :engine and Status = :status",nativeQuery=true)
    List<Post> findTechMembersNativeQuery(@Param("vehicleType")String vehicleType,
                                          @Param("marque")String marque,
                                          @Param("model")String model,
                                          @Param("engine")String engine,
                                          @Param("status")String status );

/*
    @Query(value="SELECT uuid FROM POST ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    List<Post> findWithCount();
*/
}
