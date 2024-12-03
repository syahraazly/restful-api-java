package com.restfulapi.util;

import com.restfulapi.exception.BusinessException;
import com.restfulapi.model.request.AlbumRequest;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.restfulapi.util.ErrorMessage.ERROR_MANDATORY_FIELD;

@Component
public class ValidateUtil {

    @Autowired
    private ArtistRepository repository;

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
}
