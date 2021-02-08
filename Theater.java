import java.util.ArrayList;

/**
 * Write a description of class Theater here.
 *
 * @author Liudmila Strelnikova, Kailesh Sugumar
 * @version 08.02.2021
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
        screeningSchedule = new ArrayList<>();
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
    
    /**
     * Prints all movie titles, one movie per line.
     */
    public void printAllMovies()
    {
        screeningSchedule.stream()
            .map(ss -> ss.getTitle())
            .forEach(titles -> System.out.println(titles));
    }
    
    /**
     *Prints all movies which play before the given time, one movie per line.
     *@param time time before which screening should be checked
    */
    public void printMoviesBefore(String time)
    {
        // prints all movies which play before the given time 
        // one movie per line
        String[] timeHoursMinute = time.split(":");
        int hours = Integer.parseInt(timeHoursMinute[0]);
        int minutes = Integer.parseInt(timeHoursMinute[1]);
        int screenTimeInMinutes = (hours * 60) + minutes;
  
        screeningSchedule.stream()
            .filter(movies -> movies.getScreeningTimeInMinutes() < screenTimeInMinutes)
            .map(movies -> movies.getTitle())
            .forEach(movie -> System.out.println(movie));
        //quick test with "movies.csv": prints Eddie the Eagle (screening time 10:15) if you enter "10:20", and nothing if you enter "10:10"
    }
    
    /**
     *Prints all movies playing before the given time and in the given theater, one movie per line.
     *Same as printMoviesBefore methos, except a filter for theater number is added.
     *@param theater theater number of interest
     *@param time time before which screening should be checked
    */
    public void printMoviesInBefore(int theater, String time)
    {   
        screeningSchedule.stream()
            .filter(ss -> ss.getTheaterNumber() == theater)
            .filter(
                (ss)->
                {
                    boolean pass = false;//filter returns a boolean pass
                    //first check if the hour of screening is less than the given hour
                    if (Integer.parseInt(ss.getTime().substring(0,2)) < Integer.parseInt(time.substring(0,2)))
                    {
                        pass = true;
                    }
                    //if the hours are the same, check minutes
                    else if (Integer.parseInt(ss.getTime().substring(0,2)) == Integer.parseInt(time.substring(0,2)))
                    {
                        if (Integer.parseInt(ss.getTime().substring(3,5)) < Integer.parseInt(time.substring(3,5)))
                        {
                            pass = true;
                        }
                    }
                    return pass;
                }
             )
            .map(ss -> ss.getTitle())
            .forEach(films -> System.out.println(films));
            
    }
    
    /**
     * Prints the titles of all movies that play in a given theatre (one movie per line)
     * @param theater the number of theater of interest
     */
    public void moviesInTheater(int theater)
    {
        screeningSchedule.stream()
            .filter(ss -> ss.getTheaterNumber() == theater)
            .map(ss -> ss.getTitle())
            .forEach(movieInTheatre -> System.out.println(movieInTheatre));
    }
    
    /**
     * Returns number of movies that start screening between start and end time. 
     * @param start start time
     * @param end end time
     * @return numberOfMovies number of movies screening between start time and end time
     */
    public int numberOfMoviesInTimePeriod(String start, String end)
    {
        int numberOfMovies = (int) screeningSchedule.stream()
            .filter(
                (ss)->
                {
                    boolean pass = false;//filter returns a boolean pass
                    //first check if the hour of screening is less than the given hour
                    if (Integer.parseInt(ss.getTime().substring(0,2)) < Integer.parseInt(end.substring(0,2)) &&
                    Integer.parseInt(ss.getTime().substring(0,2)) > Integer.parseInt(start.substring(0,2)))
                    {
                        pass = true;
                    }
                    //if the hours are the same for start  time, check that minutes of the movie are greater
                    else if (Integer.parseInt(ss.getTime().substring(0,2)) == Integer.parseInt(start.substring(0,2)))
                    {
                        if (Integer.parseInt(ss.getTime().substring(3,5)) > Integer.parseInt(start.substring(3,5)))
                        {
                            pass = true;
                        }
                    }
                    //if the hours are the same for end  time, check that minutes of the movie are smaller
                    else if (Integer.parseInt(ss.getTime().substring(0,2)) == Integer.parseInt(end.substring(0,2)))
                    {
                        if (Integer.parseInt(ss.getTime().substring(3,5)) < Integer.parseInt(end.substring(3,5)))
                        {
                            pass = true;
                        }
                    }
                    return pass;
                }
             )
             .count();
        return numberOfMovies;
        //quick check: there are supposed to be 2 movies beween 17:00 and 18:30
    }
    
    /**
     *Removes a given movie in a given theater from the screening schedule.
     *@param movie movie to be removed
     *@param theater number of theater from which a movie is to be removed
     */
    public void cancelScreening(String movie, int theater)
    {
        screeningSchedule.removeIf(ss -> ss.getTitle().equals(movie) && ss.getTheaterNumber()==theater);
    }
   
    /**
     *Removes all movies in a given theater from the the screening schedule.
     *@param theater number of theater to be closed
     */
    public void closeTheater(int theater)
    {
        screeningSchedule.removeIf(ss -> ss.getTheaterNumber()==theater);
    }
    
    /**
     *Calculates the number of screened movies in
     *which a given performer plays (according to the screening schedule).
     *@param performer the performer for whom movies should be counted
     *@return moviesWithPerformer number of movies with a specific performer
     */
    public int getPerformerMovieCount(String performer)
    {   //Since method count returns values of type long,(int) should be used for integer value to be returned
        int moviesWithPerformer = (int)screeningSchedule.stream()
            .filter(ss -> ss.getPerformer().equals(performer))
            .count();
        return moviesWithPerformer;
    }
    
    /**
     * Prints all movies that screen after the start time and finish screening before the end time.
     * @param start start time
     * @param end end time
     * @return movies screening between start time and end time
     * 
    */
    public void printMoviesICanWatch(String start, String end)
    {
        screeningSchedule.stream()
            .filter(
                (ss)->
                {
                    boolean pass = false;//filter returns a boolean pass
                    //first check if the hour of screening is less than the given hour
                    if (Integer.parseInt(ss.getTime().substring(0,2)) < Integer.parseInt(end.substring(0,2)) &&
                    Integer.parseInt(ss.getTime().substring(0,2)) > Integer.parseInt(start.substring(0,2)))
                    {
                        pass = true;
                    }
                    //if the hours are the same for start  time, check that minutes of the movie are greater
                    else if (Integer.parseInt(ss.getTime().substring(0,2)) == Integer.parseInt(start.substring(0,2)))
                    {
                        if (Integer.parseInt(ss.getTime().substring(3,5)) > Integer.parseInt(start.substring(3,5)))
                        {
                            pass = true;
                        }
                    }
                    //if the hours are the same for end  time, check that minutes of the movie are smaller
                    else if (Integer.parseInt(ss.getTime().substring(0,2)) == Integer.parseInt(end.substring(0,2)))
                    {
                        if (Integer.parseInt(ss.getTime().substring(3,5)) < Integer.parseInt(end.substring(3,5)))
                        {
                            pass = true;
                        }
                    }
                    return pass;
                }
             )
             .map(ss->ss.getTitle())
             .forEach(movie->System.out.println(movie));
             //quick check: between 17:00 and 18:30 there is "The Queen's Gambit"and "Black Widow"
    }
    
    /**
     * Returns the combined duration of all movies played in all theaters.
     */
    public int totalDurationOfAllMovies()
    {
        //1615 min expected from the movies.csv provided
        return screeningSchedule.stream()
            .map(ss -> ss.getDuration())
            .reduce(0,(acc,duration)->acc+duration);
    }
    
    /**
     * Returns genres of movies shown after a given time, in one string.
     * @param time time after which genres are to be returned
     * @return string with genres
     */
    public String genreAfter(String time)
    {
        return screeningSchedule.stream()
            .filter(
                (ss)->
                {
                    boolean pass = false;//filter returns a boolean pass
                    //first check if the hour of screening is less than the given hour
                    if (Integer.parseInt(ss.getTime().substring(0,2)) > Integer.parseInt(time.substring(0,2)))
                    {
                        pass = true;
                    }
                    //if the hours are the same, check minutes
                    else if (Integer.parseInt(ss.getTime().substring(0,2)) == Integer.parseInt(time.substring(0,2)))
                    {
                        if (Integer.parseInt(ss.getTime().substring(3,5)) > Integer.parseInt(time.substring(3,5)))
                        {
                            pass = true;
                        }
                    }
                    return pass;
                }
             )
            .map(ss -> ss.getGenre())
            .reduce("",(acc,genre) -> acc + genre + " ");//includes all in one string

    }
    
    /**
     * Returns a string which includes the titles of movies directed by director and in which a given performer is acting.
     * @param director director of the movie
     * @param performer lead performer in the movie
     * @return a string with the titles of films by the director with the performer
     */
    public String directorAndPerformer(String director, String performer)
    {
        return screeningSchedule.stream()
            .filter(ss->ss.getDirector().equals(director))
            .filter(ss->ss.getPerformer().equals(performer))
            .map(ss->ss.getTitle())
            .reduce(("Movies directed by "+director+" with "+performer+" as a lead performer: "), (acc,title) -> acc+title);
    }
    //quick test: when entered "Ridley Scott", "Matt Damon", the string shoud include "The Martian" two times
} 
