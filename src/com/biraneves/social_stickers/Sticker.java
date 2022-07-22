package com.biraneves.social_stickers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

/**
 *
 * Class to create a sticker.
 *
 * @author biraneves
 *
 */
public class Sticker {

    private final InputStream inputStream;
    private final String title;
    private final String message;
    private final String outputDirectory;

    public Sticker(InputStream inputStream, String title, String message, String outputDirectory) {

        this.inputStream = inputStream;
        this.title = title.trim();
        this.message = message.trim();
        this.outputDirectory = outputDirectory.trim();

    }

    private String getCleanTitle() {

        return this.title.replace(" ", "_");

    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public String getStickerFile() {

        return getOutputDirectory() + getCleanTitle() + ".png";

    }

    public void create() throws Exception {

        // Read an image from a URL
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Create a new image on memory
        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();
        int newImageHeight = (int) (imageHeight * 1.20);

        BufferedImage newImage = new BufferedImage(imageWidth, newImageHeight, BufferedImage.TRANSLUCENT);

        // Copy original image to the new image
        Graphics2D graphic = (Graphics2D) newImage.getGraphics();
        graphic.drawImage(originalImage, 0, 0, null);

        // Write a string on the new image
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        graphic.setFont(font);
        graphic.setColor(Color.ORANGE);

        int stringHeight = graphic.getFontMetrics().getHeight();
        int stringWidth = graphic.getFontMetrics().stringWidth(message);

        int textX = (imageWidth - stringWidth) / 2;
        int textY = (imageHeight + stringHeight);

        graphic.drawString(message, textX, textY);

        // Write new image to file
        ImageIO.write(newImage, "png", new File(getStickerFile()));

    }
}
