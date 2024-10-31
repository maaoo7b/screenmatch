package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeData(
        @JsonAlias("Title")
        String episodeTitle,
        @JsonAlias("Episode")
        Integer numEpisode,
        @JsonAlias("imdbRating")
        String rating,
        @JsonAlias("Released")
        String releaseDate
) {
}
