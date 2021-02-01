import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class to read CSV-style records of movies .
 * 
 */
public class MovieReader
{
    // How many fields are expected.
    private static final int NUMBER_OF_FIELDS = 7;
    // Index values for the fields in each record.
    private static final int TITLE = 0,
                             TIME = 1,
                             DURATION = 2,
                             THEATER = 3,
                             GENRE = 4,
                             DIRECTOR = 5,
                             PERFORMER = 6;
                             
    /**
     * Create a FlightReader.
     */
    public MovieReader()
    {
    }
    
    /**
     * Read flights in CSV format from the given file.
     * Return an ArrayList of Flight objects created from
     * the information in the file.
     * 
     * @param filename The file to be read - should be in CSV format.
     * @return A list of Movies.
     */
    public ArrayList<Movie> getMovies(String filename)
    {
        // Create a Flight from a CSV input line.
        Function<String, Movie> createMovie = 
            record -> {
                           String[] parts = record.split(",");
                           if(parts.length == NUMBER_OF_FIELDS) {
                               try {
                                   String title = parts[TITLE].trim();
                                   String time = parts[TIME].trim();
                                   int duration = Integer.parseInt(parts[DURATION].trim());
                                   int theater = Integer.parseInt(parts[THEATER].trim());
                                   String genre = parts[GENRE].trim();
                                   String director = parts[DIRECTOR].trim();
                                   String performer = parts[PERFORMER].trim();
                                   return new Movie(title, time, duration, theater, 
                                                     genre, director, performer);
                               }
                               catch(NumberFormatException e) {
                                   System.out.println("Movie record has a malformed integer: " + record);
                                   return null;
                               }
                           }
                           else {
                               System.out.println("Movie record has the wrong number of fields: " + record);
                               return null;
                           }
                       };
        ArrayList<Movie> movies;
        try {
            movies = Files.lines(Paths.get(filename))
                             .filter(record -> record.length() > 0 && record.charAt(0) != '#')
                             .map(createMovie)
                             .filter(movie -> movie != null)
                             .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + filename);
            movies = new ArrayList<>();
        }
        return movies;
    }
    
}
