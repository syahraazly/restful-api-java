package com.restfulapi.controller;

import com.restfulapi.model.response.ArtistResponse;
import com.restfulapi.service.ArtistServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistController {

    private final ArtistServiceImpl artistServiceImpl;

    public ArtistController(ArtistServiceImpl service) {
        this.artistServiceImpl = service;
    }

    @GetMapping(value = "/artist")
    public List<ArtistResponse> getAll() {
        return artistServiceImpl.getAll();
    }
}
