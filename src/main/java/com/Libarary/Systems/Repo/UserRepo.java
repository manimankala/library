package com.Libarary.Systems.Repo;

import com.Libarary.Systems.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, Integer> {
    @Query("{'userName':?0}")
    Optional<User> findByUserName(String userName);

    @Query("{'userPhone':?0}")
    Optional<User> findByUserPhone(String userPhone);
}
