package com.restfulapi.repository;

import com.restfulapi.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    String FIND_BY_NAME = "SELECT * FROM artists WHERE name = :name";

    @Query(value = FIND_BY_NAME, nativeQuery = true)
    ArtistEntity findByName(@Param("name") String name);
}
