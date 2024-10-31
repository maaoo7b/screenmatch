package com.aluracursos.screenmatch.model;

import javax.swing.*;

public enum Genre {

    ACTION("Action"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DRAMA("Drama");

    private String genreOMDB;

    Genre(String genreOMDB){
        this.genreOMDB = genreOMDB;
    }

    public static Genre fromString(String text) {
        for (Genre genre : Genre.values()) {
            if (genre.genreOMDB.equalsIgnoreCase(text)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Genre: " + text+" not found!");
    }
}
