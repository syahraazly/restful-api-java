package com.restfulapi.util;

import com.restfulapi.entity.AlbumEntity;
import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.model.request.AlbumRequest;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.model.response.AlbumResponse;
import com.restfulapi.model.response.ArtistResponse;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public static ArtistEntity mapperToEntity(ArtistEntity entity, ArtistRequest request) {
        if (isNewProduct(request)) {
            entity = new ArtistEntity();
        }

        entity.setName(request.getName());
        entity.setVerifiedUser(String.valueOf(request.getVerifiedUser()));
        entity.setGenre(request.getGenre());

        return entity;
    }

    public static ArtistResponse mapperToDTO(ArtistEntity fromDB) {
        return ArtistResponse.builder()
                .id(fromDB.getId())
                .name(fromDB.getName())
                .verifiedUser(Integer.valueOf(fromDB.getVerifiedUser()))
                .genre(fromDB.getGenre())
                .build();
    }

    private static boolean isNewProduct(ArtistRequest request) {
        return null == request.getId();
    }

    public static AlbumEntity mapperToEntity(AlbumEntity entity, AlbumRequest request) {
        if (isNewProduct(request)) {
            entity = new AlbumEntity();
        }

        entity.setName(request.getName());
        entity.setReleaseYear(request.getReleaseYear());
        entity.setArtistId(request.getArtistId());

        return entity;
    }

    public static AlbumResponse mapperToDTO(AlbumEntity fromDB) {
        return AlbumResponse.builder()
                .id(fromDB.getId())
                .name(fromDB.getName())
                .release_year(fromDB.getReleaseYear())
                .artistId(fromDB.getArtistId())
                .build();
    }

    private static boolean isNewProduct(AlbumRequest request) {
        return null == request.getId();
    }
}
