package com.restfulapi.service;

import com.restfulapi.entity.AlbumEntity;
import com.restfulapi.model.request.AlbumRequest;
import com.restfulapi.model.response.AlbumResponse;

import java.util.List;

public interface AlbumServiceImpl {

    List<AlbumResponse> getAll();

    AlbumResponse getById(Long id);

    AlbumEntity create(AlbumRequest request);

    AlbumEntity update(AlbumRequest request);

    String delete(Long id);
}
