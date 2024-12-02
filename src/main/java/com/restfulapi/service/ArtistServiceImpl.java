package com.restfulapi.service;

import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.model.response.ArtistResponse;

import java.util.List;

public interface ArtistServiceImpl {

    List<ArtistResponse> getAll();

    ArtistResponse getById(Long id);

    ArtistEntity create(ArtistRequest request);

    ArtistEntity update(ArtistRequest request);

    String delete(Long id);
}
