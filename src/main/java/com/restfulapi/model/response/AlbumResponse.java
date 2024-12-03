package com.restfulapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumResponse {

    private Long id;

    private String name;

    private String release_year;

    private Integer artistId;
}
