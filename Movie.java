
/**
 * class Movie contains all the information about a movie as well as some
 * verification methods that check correctness of entries. 
 *
 * @author Liudmila Strelnikova
 * @author kailesh sugumar
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
      if(checkGenre(genre)) {
         if(checkTheaterNumber(theater)) {
            if(checkScreeningTime(time)) {
               if(checkDuration(duration)) {
                     
               }
               else {
                  System.out.println("Invalid genre format");
               }
            }
            else {
               System.out.println("Invalid theater number");
            }               
          }
          else {
            System.out.println("Invalid time format");
          }
       }
       else {
         System.out.println("Invalid duration number");
       }   
   }
   
   {
      movieTitle = title;
      screeningTime = time;
      durationInMinutes = duration;
      theaterNumber = theater;
      this.genre = genre;
      directorName = director;
      leadPerformer = performer;
   
   }                                     
  
   public int getScreeningTimeInMinutes() 
   {
      String[] timeHoursMinute = this.screeningTime.split(":");
      int hours = Integer.parseInt(timeHoursMinute[0]);
      int minutes = Integer.parseInt(timeHoursMinute[1]);
      int screenTimeInMinutes = (hours * 60) + minutes;

      return screenTimeInMinutes;
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
      if (TheaterNumber > 0 && TheaterNumber <17) {
         return true;
      }
      return false;
   }
   public int getTheaterNumber() 
   {
      return this.theaterNumber
   }
  
   
   //Haven't come up with any decent code for this one yet. 
   private boolean checkScreeningTime(String time;)
   {
      int screenTimeUpperBound = 1425; // 23:45 converted into time minutes
      int screenTimeLowerBound = 600; // 10:00 converted into time minutes

// Convert 24hr time format to minutes
      String[] timeHoursMinute = time.split(":");
      int hours = Integer.parseInt(timeHoursMinute[0]);
      int minutes = Integer.parseInt(timeHoursMinute[1]);
      int screenTimeInMinutes = (hours * 60) + minutes;

// Checks if screen Time is with bounds.
      return screenTimeInMinutes >= screenTimeLowerBound && screenTimeInMinutes <= screenTimeUpperBound;
   }
    
   private boolean checkDuration(int duration)
   {
       if (Duration > 44 && Duration <211) {
         return true;
      }
      return false;
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
   
   public String getTitle(){return movieTitle;}
   
   public String getTime(){return screeningTime;}
   
   public int getDuration(){return durationInMinutes;}
   
   public String getGenre(){return genre;}
   
   public String getDirector(){return directorName;}
   
   public int getTheaterNumber(){return theaterNumber;}
   
   public String getPerformer(){return leadPerformer;}
}
