package com.biraneves.social_stickers;

import com.biraneves.service.ansi.AnsiTerminal;

/**
 *
 * This class represents a movie from imDb.
 *
 * @author biraneves
 *
 */
public class Movie extends Content implements AnsiTerminal {

    private final double imDbRating;

    public Movie(String title, String imageUrl, double imDbRating) {

        super(title, imageUrl);
        this.imDbRating = imDbRating;

    }

    public double getImDbRating() {

        return imDbRating;

    }

    private String getStars() {

        int roundRating = (int) Math.round(getImDbRating());

        return "\uD83C\uDF1F".repeat(Math.max(0, roundRating));

    }

    @Override
    public String toString() {

        String m = YELLOW_BOLD_BRIGHT + this.getTitle() + RESET + "\n";
        m += WHITE_BOLD_BRIGHT + "Poster: " + RESET + this.getImageUrl() + "\n";
        m += WHITE_ON_MAGENTA + " Rating: " + this.getImDbRating() + " " + RESET + "\n";
        m += getStars() + "\n";

        return m;

    }
}
