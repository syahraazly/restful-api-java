package com.restfulapi.util;

import com.restfulapi.entity.AlbumEntity;
import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.exception.BusinessException;
import com.restfulapi.model.request.AlbumRequest;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.repository.ArtistRepository;
import com.restfulapi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.restfulapi.util.ErrorMessage.ERROR_DUPLICATE_NAME;
import static com.restfulapi.util.ErrorMessage.ERROR_MANDATORY_FIELD;

@Component
public class ValidateUtil {

    @Autowired
    private ArtistRepository repositoryArtist;

    @Autowired
    private AlbumRepository repositoryAlbum;

    public void validateMandatoryField(ArtistRequest request) {
        if (null != request && (null == request.getName() || request.getName().isEmpty()) && (null == request.getGenre() || request.getGenre().isEmpty())) {
            throw new BusinessException(ERROR_MANDATORY_FIELD);
        }
    }

    public void validateMandatoryField(AlbumRequest request) {
        if (null != request && (null == request.getName() || request.getName().isEmpty()) && (null == request.getReleaseYear() || request.getReleaseYear().isEmpty())) {
            throw new BusinessException(ERROR_MANDATORY_FIELD);
        }
    }

    public void validateDuplicateName(ArtistRequest request) {
        ArtistEntity checkToDB = repositoryArtist.findByName(request.getName());
        if (null != checkToDB) {
            throw new BusinessException(ERROR_DUPLICATE_NAME);
        }
    }

    public void validateDuplicateName(AlbumRequest request) {
        AlbumEntity checkToDB = repositoryAlbum.findByName(request.getName());
        if (null != checkToDB) {
            throw new BusinessException(ERROR_DUPLICATE_NAME);
        }
    }
}
