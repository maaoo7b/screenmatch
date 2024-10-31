package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(
        @JsonAlias("Title")
        String title,
        @JsonAlias("totalSeasons")
        Integer seasons,
        @JsonAlias("imdbRating")
        String rating,
        @JsonAlias("Language")
        String language,
        @JsonAlias("Genre")
        String genre,
        @JsonAlias("Poster")
        String poster,
        @JsonAlias("Plot")
        String plot,
        @JsonAlias("Actors")
        String actors){
}
