import com.biraneves.service.net.HttpClient;
import com.biraneves.social_stickers.Content;
import com.biraneves.social_stickers.ImdbContentExtractor;
import com.biraneves.social_stickers.NasaContentExtractor;
import com.biraneves.social_stickers.Sticker;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Consumes an API and generates stickers to use on social networks, like WhatsApp.
 *
 * @author biraneves
 *
 */
public class SocialSticker {

    public static String getOutputDirectory() {

        Scanner input = new Scanner(System.in);

        System.out.print("Please inform output directory name [default: output]: ");
        String rawName = input.nextLine();

        input.close();

        if (rawName.trim().length() == 0)
            return "output/";

        String outputDirectory = rawName.trim().replace(" ", "_");

        if (outputDirectory.endsWith("/"))
            return outputDirectory;

        return outputDirectory + "/";

    }

    public static void main(String[] args) {

        // Get a JSON with movies
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        ImdbContentExtractor extractor = new ImdbContentExtractor();

//        String url = "https://api.nasa.gov/planetary/apod?count=3&api_key=DEMO_KEY";
//        NasaContentExtractor extractor = new NasaContentExtractor();

        HttpClient http = new HttpClient();
        String json = http.getData(url);

        List<Content> contents = extractor.extractContents(json);

        // Check the output directory
        String directoryPath = getOutputDirectory();
        File directory = new File(directoryPath);

        if (!directory.exists()) {

            if (!directory.mkdirs()) {

                System.out.println("Directory creation error!");
                System.exit(1);

            }

        }

        // Display data
        for (Content content : contents) {

            Content cont = new Content(content.getTitle(), content.getImageUrl());

            System.out.print("Generating sticker for " + cont.getTitle() + "... ");

            try {

                Sticker st = new Sticker(new URL(cont.getImageUrl()).openStream(), cont.getTitle(), "BORAVÊ!!!",
                        directoryPath);
                st.create();
                System.out.println("Done!");

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

    }

}
