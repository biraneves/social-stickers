import com.biraneves.service.json.JsonParser;
import com.biraneves.service.net.HttpClient;
import com.biraneves.social_stickers.Movie;
import com.biraneves.social_stickers.Sticker;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
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
//        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

        HttpClient http = new HttpClient();
        String json = http.getData(url);

        // Parse JSON to extract interesting data: title, poster and rating.
        List<Map<String, String>> contentsList = JsonParser.parse(json);

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
        for (Map<String, String> movie : contentsList) {

            Movie mv = new Movie(movie.get("title"), movie.get("image"), Double.parseDouble(movie.get("imDbRating")));

            System.out.print("Generating sticker for " + mv.getTitle() + "... ");

            try {

                Sticker st = new Sticker(new URL(mv.getImageUrl()).openStream(), mv.getTitle(), "BORAVÊ!!!",
                        directoryPath);
                st.create();
                System.out.println("Done!");

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

    }

}
