package com.restfulapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistRequest {

    private Long id;

    private String name;

    private Integer verifiedUser;

    private String genre;
}
