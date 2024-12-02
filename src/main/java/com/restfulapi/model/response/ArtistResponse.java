package com.restfulapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArtistResponse {

    private Long id;

    private String name;

    private Integer verifiedUser;

    private String genre;
}
