package com.restfulapi.repository;

import com.restfulapi.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    String FIND_BY_NAME = "SELECT * FROM albums WHERE name = :name";

    @Query(value = FIND_BY_NAME, nativeQuery = true)
    AlbumEntity findByName(@Param("name") String name);
}
