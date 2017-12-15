package com.andrewahn.booksearch.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by andrewahn on 12/1/17.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class BookSearchResponse {

    @JsonProperty("totalItems")
    public int total_count;

    @JsonProperty("items")
    public List<BookResponse> books;
}
