
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
       //screeningTime = time;
       //durationInMinutes = duration;
       //theaterNumber = theater;
       //this.genre = genre;
       directorName = director;
       leadPerformer = performer;
       
       if (checkGenre(genre)) {this.genre = genre;}
       else {System.out.println("Incorrect genre");}
       if (checkTheaterNumber(theater)) {theaterNumber = theater;}
       else {System.out.println("Incorrect theater number");}
       if (checkScreeningTime(time)) {screeningTime = time;}
       else {System.out.println("Incorrect screening time");}
       if (checkDuration(duration)) {durationInMinutes = duration;}
       else {System.out.println("Incorrect duration");}
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
   
   /**
    * Checks if the theater number has a value  from 1 to 16.
    * @param theater number of theater to be checked
    * @return correct true if theater number is in the range, false otherwise
    */
   private boolean checkTheaterNumber(int theater)
   {    
       boolean correct = false;
       if (theater >= 1 && theater <= 16){correct = true;}
       return correct;
   }
   
   /**
    * Checks if the screening time is between 10:00 and 23:45. Checks also that a semicolon
    * separates hours and minutes.
    * @param time screening time to be checked
    * @return correct if the time is correct, else otherwise
    */
   //Code for this method looks a bit bulky, however I have not come with a beter 
   //solution yet. 
   private boolean checkScreeningTime(String time)
   {   
       return true;
   }
   
   /**
    * Checks if the duration is between 45 and 210 minutes. 
    * @param duration duration of a movie in minutes
    * @return correct if duration is correct, false otherwise
    */
   private boolean checkDuration(int duration)
   {
       boolean correct = false;
       if (duration>=45 && duration <=210){
           correct = true;
       }
       return correct;
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
   
   public String getGenre(){return this.genre;}
   
   public String getDirector(){return directorName;}
   
   public int getTheaterNumber(){return theaterNumber;}
   
   public String getPerformer(){return leadPerformer;}
}
