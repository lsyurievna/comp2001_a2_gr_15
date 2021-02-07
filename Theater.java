import java.util.ArrayList;

/**
 * Write a description of class Theater here.
 *
 * @author Liudmila Strelnikova
 * @author kailesh sugumar 
 * @version 05.02.2021
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
     * Prints all movie titles using a map, one movie per line.
     */
    public void printAllMovies()
    {
        screeningSchedule.stream()
            .map(ss -> ss.getTitle())
            .forEach(titles -> System.out.println(titles));
    }
    
    public int getScreeningTimeInMinutes() 
   {
      String[] timeHoursMinute = this.screeningTime.split(":");
      int hours = Integer.parseInt(timeHoursMinute[0]);
      int minutes = Integer.parseInt(timeHoursMinute[1]);
      int screenTimeInMinutes = (hours * 60) + minutes;

      return screenTimeInMinutes;
   }
    
    public void printMoviesBefore(String time)
    {
        // prints all movies which play before the given time 
        // one movie per line
        String[] timeHoursMinute = time.split(":");
        int hours = Integer.parseInt(timeHoursMinute[0]);
        int minutes = Integer.parseInt(timeHoursMinute[1]);
        int screenTimeInMinutes = (hours * 60) + minutes;
  
        screeningSchedule.stream().filter(movies -> movies.getScreeningTimeInMinutes()< screenTimeInMinutes).forEach(movies -> movies.printInfoSimple());
 
    }
    
    
    public void printMoviesInBefore(int theater, String time)
    {
       // prints all movies playing before the given time and in the given theater
       // one movie per line
        String[] timeHoursMinute = time.split(":");
        int hours = Integer.parseInt(timeHoursMinute[0]);
        int minutes = Integer.parseInt(timeHoursMinute[1]);
        int screenTimeInMinutes = (hours * 60) + minutes;
  
        screeningSchedule.stream().filter(movies -> movies.getScreeningTimeInMinutes()< screenTimeInMinutes).filter(movies -> (movies.getTheaterNumber() == theater)).forEach(movies -> movies.printInfoSimple());
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
    
    public int numberOfMoviesInTimePeriod(String start, String end)
    {
        // returns number of movies that start screening between start and end time
        return 0;
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
     */
    public int getPerformerMovieCount(String performer)
    {   //won't work
        //return Stream.of(screeningSchedule)
            //.filter(ss -> ss.getPerformer().equals(performer))
            //.count();
         int count = (int) this.screeningSchedule.stream().filter(movie -> ((Movie) movie).getLeadPerformer() == performer).count();
        return count;
    }
    
    public void printMoviesICanWatch(String start, String end)
    {
        // prints all movies that screen after the start time and finish screening before the end time 
         this.screeningSchedule.stream().filter(movie -> ((Movie) movie).getScreeningTime().compareTo(start) >= 0).filter(movie -> ((Movie) movie)
                                                          .getScreeningTimeInMinutes()<=((Integer.parseInt(end.split(":")[0])*60)+Integer
                                                            .parseInt(end.split(":")[1]))).forEach(movie -> ((Movie) movie).printInfoSimple());
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
    
    public String genreAfter(String time)
    {
        //returns a string which includes all genres playing after given time
         String stringToReturn = (String) this.screeningSchedule.stream().filter(movie -> ((Movie) movie).getScreeningTime().compareTo(time) >= 0)
                        .reduce((movie1, movie2) -> ((Movie) movie1).getGenre() + ", " + ((Movie) movie2).getGenre()).get();
        return stringToReturn;
        
    }
    
    public String directorAndPerformer(String director, String performer)
    {
        //returns a string which includes the titles of movies directed by director and in which performer is acting
        String stringToReturn = (String) this.screeningSchedule.stream().filter(movie -> ((Movie) movie).getDirectorName().compareToIgnoreCase(director) == 0)
                        .filter(movie -> ((Movie) movie).getLeadPerformer().compareToIgnoreCase(performer) == 0).reduce((movie1, movie2) -> ((Movie) movie1)
                                                                              .getMovieTitle() + ", " + ((Movie) movie2).getMovieTitle()).get();
        return stringToReturn;
    }
    
}
