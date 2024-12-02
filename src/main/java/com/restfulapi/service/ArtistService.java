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
    public ArtistResponse getById(Long id) {
        ArtistEntity fromDB = findById(id);
        return mapperToDTO(fromDB);
    }

    @Override
    public ArtistEntity create(ArtistRequest request) {
        validateRequest(request);

        // Save to DB
        ArtistEntity artistEntity = mapperToEntity(new ArtistEntity(), request);
        repository.saveAndFlush(artistEntity);

        return artistEntity;
    }

    @Override
    public ArtistEntity update(ArtistRequest request) {
        ArtistEntity entity = findById(request.getId());

        validateRequest(request, entity);

        // Save to DB
        ArtistEntity artistEntity = mapperToEntity(entity, request);
        repository.saveAndFlush(artistEntity);

        return artistEntity;
    }

    @Override
    public String delete(Long id) {
        ArtistEntity entity = findById(id);
        repository.delete(entity);

        return SUCCESS_PROCESS;
    }

    public void validateRequest(ArtistRequest request) {
        validateUtil.validateMandatoryField(request);
    }

    public void validateRequest(ArtistRequest request, ArtistEntity entity) {
        validateUtil.validateMandatoryField(request);
    }

    private ArtistEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(ERROR_NOT_FOUND));
    }

}
