package com.restfulapi.service;

import com.restfulapi.entity.AlbumEntity;
import com.restfulapi.exception.BusinessException;
import com.restfulapi.model.request.AlbumRequest;
import com.restfulapi.model.response.AlbumResponse;
import com.restfulapi.repository.AlbumRepository;
import com.restfulapi.util.MapperUtil;
import com.restfulapi.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.restfulapi.util.ErrorMessage.ERROR_NOT_FOUND;
import static com.restfulapi.util.MapperUtil.mapperToDTO;
import static com.restfulapi.util.MapperUtil.mapperToEntity;

@Service
public class AlbumService implements AlbumServiceImpl {

    private static final String SUCCESS_PROCESS = "Success";

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private ValidateUtil validateUtil;

    @Override
    public List<AlbumResponse> getAll() {
        List<AlbumEntity> findAll = repository
                .findAll().stream()
                .sorted(Comparator.comparing(AlbumEntity::getCreatedAt))
                .toList();

        return findAll.stream().map(MapperUtil::mapperToDTO).toList();
    }

    @Override
    public AlbumResponse getById(Long id) {
        AlbumEntity fromDB = findById(id);
        return mapperToDTO(fromDB);
    }

    @Override
    public AlbumEntity create(AlbumRequest request) {
        validateRequest(request);

        // Save toDB
        AlbumEntity albumEntity = mapperToEntity(new AlbumEntity(), request);
        repository.saveAndFlush(albumEntity);

        return albumEntity;
    }

    @Override
    public AlbumEntity update(AlbumRequest request) {
        AlbumEntity entity = findById(request.getId());

        validateRequest(entity, request);

        // Save to DB
        AlbumEntity albumEntity = mapperToEntity(entity, request);
        repository.saveAndFlush(albumEntity);

        return albumEntity;
    }

    @Override
    public String delete(Long id) {
        AlbumEntity entity = findById(id);
        repository.delete(entity);

        return SUCCESS_PROCESS;
    }

    private AlbumEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(ERROR_NOT_FOUND));
    }

    public void validateRequest(AlbumRequest request) {
        validateUtil.validateMandatoryField(request);
    }

    public void validateRequest(AlbumEntity entity, AlbumRequest request) {
        validateUtil.validateMandatoryField(request);
    }
}
