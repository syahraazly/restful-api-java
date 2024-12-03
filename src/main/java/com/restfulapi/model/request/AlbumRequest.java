package com.restfulapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumRequest {

    private Long id;

    private String name;

    private String releaseYear;

    private Integer artistId;
}
