package com.restfulapi.controller;


import com.restfulapi.entity.AlbumEntity;
import com.restfulapi.model.request.AlbumRequest;
import com.restfulapi.model.response.AlbumResponse;
import com.restfulapi.service.AlbumServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    private final AlbumServiceImpl albumServiceImpl;

    public AlbumController(AlbumServiceImpl service) {
        this.albumServiceImpl = service;
    }

    @GetMapping(value = "/data")
    public List<AlbumResponse> getAll() {
        return albumServiceImpl.getAll();
    }

    @GetMapping(value = "/data/{id}")
    public AlbumResponse getById(@PathVariable Long id) {
        return albumServiceImpl.getById(id);
    }

    @PostMapping(value = "/add")
    public AlbumEntity create(@RequestBody AlbumRequest request) {
        return albumServiceImpl.create(request);
    }

    @PutMapping(value = "/update")
    public AlbumEntity update(@RequestBody AlbumRequest request) {
        return albumServiceImpl.update(request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        return albumServiceImpl.delete(id);
    }
}
