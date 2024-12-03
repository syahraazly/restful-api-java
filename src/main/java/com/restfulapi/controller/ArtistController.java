package com.restfulapi.controller;

import com.restfulapi.entity.ArtistEntity;
import com.restfulapi.model.request.ArtistRequest;
import com.restfulapi.model.response.ArtistResponse;
import com.restfulapi.service.ArtistServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    private final ArtistServiceImpl artistServiceImpl;

    public ArtistController(ArtistServiceImpl service) {
        this.artistServiceImpl = service;
    }

    @GetMapping(value = "/data")
    public List<ArtistResponse> getAll() {
        return artistServiceImpl.getAll();
    }

    @PostMapping(value = "/add")
    public ArtistEntity create(@RequestBody ArtistRequest request) {
        return artistServiceImpl.create(request);
    }
}
