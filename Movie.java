
/**
 * class Movie contains all the information about a movie as well as some
 * verification methods that check correctness of entries. 
 *
 * @author Liudmila Strelnikova
 * @version 05.02.2021
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
   
   /**
     * A private method that checks correctness of input for the movie genre
     * @param genre the genre entered by the user
     * @return match true if the genre belongs to the catalogue of genres, false otherwise
    */
   private boolean checkGenre(String genre)
       //Creation of an array that is later converted to an ArrayList object, 
       //so that the values are assigned without repeatedly applying the .add() method.
   {   ArrayList<String> allowedGenres = new ArrayList<>(Arrays.asList("drama", "comedy", "thriller", "horror", "family", "action", "adventure"));
       //A non-lambda implementation until I haven't come up with the more efficient one
       Iterator<String> it = allowedGenres.iterator();
       boolean match = false;//at the beginning I assume that the is no match
       while(it.hasNext())
       {
           String g = it.next();
           if (g.equals(genre))
           {
               match = true; //change to true if there is a match
           }
       }
       return match;
   }
    
   private boolean checkTheaterNumber(int theater)
   {
       return true;
   }
   
   //Haven't come up with any decent code for this one yet. 
   private boolean checkScreeningTime(String time)
   {
       return true;
   }
    
   private boolean checkDuration(int duration)
   {
       return true;
   }
   
   /**
    * Print all the info about a movie.
    */
   //should probably add the all the info about the film to an array
   //and then reduce int to one string but that way I would lose 
   //description of what means what
   public void printInfo()
   {
       System.out.println("Title: " + movieTitle);
       System.out.println("Screening time: " + screeningTime);
       System.out.println("Duration: " + durationInMinutes);
       System.out.println("Theater number: " + theaterNumber);
       System.out.println("Genre: " + genre);
       System.out.println("Director: " + directorName);
       System.out.println("Lead performer: " + leadPerformer);
   }
   
}
