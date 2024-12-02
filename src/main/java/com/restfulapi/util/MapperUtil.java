package com.restfulapi.util;

import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.model.request.ArtistRequest;
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
}
