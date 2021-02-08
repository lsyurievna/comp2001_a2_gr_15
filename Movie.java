
/**
 * class Movie contains all the information about a movie 
 * such as its title, duration, genre, etc..
 * The class also contains accessor methods and 
 * verification methods that check correctness of some entries. 
 * @author Liudmila Strelnikova, Kailesh Sugumar
 * @version 08.02.2021
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
       directorName = director;
       leadPerformer = performer;
       
       //Verification of correctness is required for some of the variables before value assignment.
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
       Iterator<String> it = allowedGenres.iterator();
       boolean match = false;//at the beginning I assume that there is no match
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
    * separates hours and minutes, and if the length of entered string is 5 characters long.
    * @param time screening time to be checked
    * @return correct true if the time is entered correctly, false otherwise
    */

   private boolean checkScreeningTime(String time)
   {   
       boolean correct = false;//assime in the begining that the format is wrong
       
       if (time.length()==5){ //first check if the stirng is of lenth 5
           String[] timeHoursMinute = time.split(":");//splits time into {"hours", "minutes"}
           int hours = Integer.parseInt(timeHoursMinute[0]);
           int minutes = Integer.parseInt(timeHoursMinute[1]);
           int screenTimeInMinutes = (hours * 60) + minutes;//conversion to minutes
           int screenTimeLowerBound = 600;//10*60
           int screenTimeUpperBound = 1425; //23*60+45
       
           correct = screenTimeInMinutes >= screenTimeLowerBound && screenTimeInMinutes <= screenTimeUpperBound;
       }
       
       return correct;
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
    * Prints all the info about a movie, each feature on a separate line.
    */
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
   
   //Accessor methods for the class. 
   
   public String getTitle(){return movieTitle;}
   
   public String getTime(){return screeningTime;}
   
   public int getDuration(){return durationInMinutes;}
   
   public String getGenre(){return this.genre;}
   
   public String getDirector(){return directorName;}
   
   public int getTheaterNumber(){return theaterNumber;}
   
   public String getPerformer(){return leadPerformer;}
   
   /**
    * Gets screening time in minutes.
    * @return screenTimeInMinutes 
    */
   public int getScreeningTimeInMinutes(){
      String[] timeHoursMinute = screeningTime.split(":");
      int hours = Integer.parseInt(timeHoursMinute[0]);
      int minutes = Integer.parseInt(timeHoursMinute[1]);
      int screenTimeInMinutes = (hours * 60) + minutes;

      return screenTimeInMinutes;
   }
}
