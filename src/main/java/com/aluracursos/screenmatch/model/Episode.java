package com.aluracursos.screenmatch.model;

import java.time.LocalDate;

public class Episode {

    private Integer numSeason;
    private String episodeTitle;
    private Integer numEpisode;
    private Double rating;
    private LocalDate releaseDate;

    public Episode(Integer num, EpisodeData d) {
        this.numSeason = num;
        this.episodeTitle= d.episodeTitle();
        this.numEpisode=d.numEpisode();
        try{
            this.rating = Double.valueOf(d.rating());
        }catch(NumberFormatException e){
            this.rating = 0.0;
        }
        try {
            this.releaseDate = LocalDate.parse(d.releaseDate());
        }catch (Exception e){
            this.releaseDate = null; //LocalDate.now();

        }
    }


    public Integer getNumSeason() {
        return numSeason;
    }

    public void setNumSeason(Integer numSeason) {
        this.numSeason = numSeason;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public Integer getNumEpisode() {
        return numEpisode;
    }

    public void setNumEpisode(Integer numEpisode) {
        this.numEpisode = numEpisode;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return
                "numSeason=" + numSeason +
                ", episodeTitle='" + episodeTitle + '\'' +
                ", numEpisode=" + numEpisode +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate ;
    }
}
