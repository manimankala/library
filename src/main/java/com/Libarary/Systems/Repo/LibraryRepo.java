package com.Libarary.Systems.Repo;

import com.Libarary.Systems.Models.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibraryRepo extends MongoRepository<Library, Integer> {
    @Query("{'libId':?0}")
    List<Library> findByLibId(int libId);
    @Query("{'libName':?0}")
    Optional<Library> findByLibName(String libName);
}
