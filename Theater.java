import java.util.ArrayList;

/**
 * Write a description of class Theater here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Theater
{
    private ArrayList<Movie> screeningSchedule;

    /**
     * Constructor for objects of class Theater
     */
    public Theater()
    {
        // initialise instance variables
        
    }
    
    /**
     * Add the movies recorded in the given filename to the schedule (replacing previous movies).
     * @param filename A CSV file of Movie records.
     */
    public void addMoviesFromFile(String filename)
    {
        MovieReader reader = new MovieReader();
        screeningSchedule = new ArrayList<>();
        screeningSchedule.addAll(reader.getMovies(filename));
    }
    
    public void printAllMovies()
    {
        // prints for all movies the corresponding info
        // movies are separated by an empty line
    }
    
    public void printMoviesBefore(String time)
    {
        // prints all movies which play before the given time 
        // one movie per line
    }
    
    public void printMoviesInBefore(int theater, String time)
    {
        // prints all movies playing before the given time and in the given theater
        // one movie per line
    }
    
    public void moviesInTheater(int theater)
    {
        // prints all movies that play in the given theater 
        // one movie per line
    }
    
    public int numberOfMoviesInTimePeriod(String start, String end)
    {
        // returns number of movies that start screening between start and end time
        return 0;
    }
    
    public void cancelScreening(String movie, int theater)
    {
        // removes a given movie in a given theater from the screening schedule
    }
    
    public void closeTheater(int theater)
    {
        // removes all movies in a given theater from the the screening schedule
    }
    
    public int getPerformerMovieCount(String performer)
    {
        // calculates the number of screened movies in which a given performer plays (according to the screening schedule) 
        return 0;
    }
    
    public void printMoviesICanWatch(String start, String end)
    {
        // prints all movies that screen after the start time and finish screening before the end time 
    }
    
    public int totalDurationOfAllMovies()
    {
        // returns the combined duration of all movies played in all theaters
        return 0;
    }
    
    public String genreAfter(String time)
    {
        //returns a string which includes all genres playing after given time
        return "";
    }
    
    public String directorAndPerformer(String director, String performer)
    {
        //returns a string which includes the titles of movies directed by director and in which performer is acting
        return "";
    }
    
}
