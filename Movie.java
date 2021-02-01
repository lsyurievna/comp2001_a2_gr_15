import java.util.ArrayList;

/**
 * Write a description of class Movie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Movie
{
   private String movieTitle;
   private String screeningTime;
   private int durationInMinutes;
   private int theaterNumber;
   private String genre;
   private String directorName;
   private String leadPerformer;

   /**
     * Constructor for objects of class Movie
     */
   public Movie(String title, String time, int duration, int theater,  
                String genre, String director, String performer)
   {
       movieTitle = title;
       screeningTime = time;
       durationInMinutes = duration;
       theaterNumber = theater;
       this.genre = genre;
       directorName = director;
       leadPerformer = performer;
   }
   
   private boolean checkGenre(String genre)
   {
       return true;
   }
    
   private boolean checkTheaterNumber(int theater)
   {
       return true;
   }
    
   private boolean checkScreeningTime(String time)
   {
       return true;
   }
    
   private boolean checkDuration(int duration)
   {
       return true;
   }

   public void printInfo()
   {
       // print all the information about the movie
       // each field on a new line
   }
   
}
