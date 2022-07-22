package com.biraneves.social_stickers;

import com.biraneves.service.ansi.AnsiTerminal;

/**
 *
 * Class that represents the content returned from the consumed API.
 *
 * @author biraneves
 *
 */
public class Content implements AnsiTerminal {

    private final String title;
    private final String imageUrl;

    public Content(String title, String imageUrl) {

        this.title = title;
        this.imageUrl = imageUrl;

    }

    public String getTitle() {

        return title;

    }

    public String getImageUrl() {

        return imageUrl;

    }

    @Override
    public String toString() {

        String s = YELLOW_BOLD_BRIGHT + getTitle() + RESET + "\n";
        s += WHITE_BOLD_BRIGHT + "Image: " + RESET + getImageUrl() + "\n";

        return s;

    }
}
