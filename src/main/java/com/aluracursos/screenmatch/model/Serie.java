package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ChatGPTService;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "Series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(unique = true)
    private String title;
    private Integer seasons;
    private Double rating;
    private String language;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String poster;
    private String plot;
    private String actors;
    @Transient
    private List<Episode> episodes;


    public Serie(){}

    public Serie(SeriesData seriesData) {
        this.title = seriesData.title();
        this.seasons = seriesData.seasons();
        this.rating = OptionalDouble.of(Double.valueOf(seriesData.rating())).orElse(0);
        this.language = seriesData.language();
        this.genre = Genre.fromString(seriesData.genre().split(",")[0].trim());
        this.poster = seriesData.poster();
        this.plot = seriesData.plot(); //ChatGPTService.obtenerTraduccion(seriesData.plot()); Doesn't work because out of credits.
        this.actors = seriesData.actors();
    }

    @Override
    public String toString() {
        return "genre=" + genre +
                ", title='" + title + '\'' +
                ", seasons=" + seasons +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                ", poster='" + poster + '\'' +
                ", plot='" + plot + '\'' +
                ", actors='" + actors;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
