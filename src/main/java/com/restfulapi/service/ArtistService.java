package com.restfulapi.service;

import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.exception.BusinessException;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.model.response.ArtistResponse;
import com.restfulapi.repository.ArtistRepository;
import com.restfulapi.util.MapperUtil;
import com.restfulapi.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.restfulapi.util.ErrorMessage.ERROR_NOT_FOUND;
import static com.restfulapi.util.ErrorMessage.ERROR_REQUIRED_ID;
import static com.restfulapi.util.MapperUtil.mapperToDTO;
import static com.restfulapi.util.MapperUtil.mapperToEntity;

@Service
public class ArtistService implements ArtistServiceImpl {

    private static final String SUCCESS_PROCESS = "Success";

    @Autowired
    private ArtistRepository repository;

    @Autowired
    private ValidateUtil validateUtil;

    @Override
    public List<ArtistResponse> getAll() {
        List<ArtistEntity> findAll = repository
                .findAll().stream()
                .sorted(Comparator.comparing(ArtistEntity::getCreatedAt))
                .toList();

        return findAll.stream().map(MapperUtil::mapperToDTO).toList();
    }

    @Override
    public ArtistEntity create(ArtistRequest request) {
        validateRequest(request);

        // Save to DB
        ArtistEntity artistEntity = mapperToEntity(new ArtistEntity(), request);
        repository.saveAndFlush(artistEntity);

        return artistEntity;
    }

    public void validateRequest(ArtistRequest request) {
        validateUtil.validateMandatoryField(request);
    }

}
