package com.andrewahn.booksearch.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by andrewahn on 12/1/17.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class BookResponse {

    public String id;

    @JsonProperty("volumeInfo")
    public VolumeInfo volumeInfo;

    @JsonIgnoreProperties(ignoreUnknown=true)
    public class VolumeInfo {

        public String title;
        public String subtitle;
        public List<String> authors;
        public String description;

        @JsonProperty("imageLinks")
        public ImageLinks imageLinks;

        @JsonIgnoreProperties(ignoreUnknown=true)
        public class ImageLinks {
            public String smallThumbnail;
            public String thumbnail;
        }
    }


}
