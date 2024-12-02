package com.restfulapi.service;

import com.restfulapi.model.response.ArtistResponse;

import java.util.List;

public interface ArtistServiceImpl {

    List<ArtistResponse> getAll();
}
