package com.restfulapi.service;

import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.model.response.ArtistResponse;

import java.util.List;

public interface ArtistServiceImpl {

    List<ArtistResponse> getAll();

    ArtistEntity create(ArtistRequest request);
}
