//This class is from the Lecture Slides
package project1;
public class Date {
 
 protected int year;
 protected int month;
 protected int day;
 public static final int min_year = 1583;
 protected int age;
 
 // Constructor
 public Date(int newDay, int newMonth, int newYear){
     month = newMonth;
     day = newDay;
     year = newYear;
 }
 
 public int getYear(){      // return year
     return year;
 }
 
 public int getMonth(){     // return month
     return month;
 }

 public int getDay(){    // return day
     return day;
 }
 
 public int getAge(int day, int month, int year){
     Date date = new Date(day, month, year);
     
     age = date.lilian() % 365;
     
     return age;
 }
 
 public int lilian(){
     final int SUBDAYS = 578100;
     int numDays = 0;
     numDays = year * 365; // add days in a year
     
     if(month <=2) // add days in a month
         numDays = numDays + (month - 1)*31;
     else
         numDays = numDays + (month + 1)*31 - ((4 * (month - 1) + 27) / 10);
     
     // add days in the days (making day 1 be day 1 and so on)
     numDays = numDays + day;
     
     // take care of leap years
     numDays = numDays + (year / 4) - (year / 100) + (year/ 400);
     
     // handle special case of leap year, but not leap year day
     if(month < 3){
         if ((year % 4) == 0)
             numDays = numDays - 1;
         if ((year % 100) == 0)
             numDays = numDays + 1;
         if ((year % 400) == 0)
             numDays = numDays - 1;            
     }
     
     numDays = numDays - SUBDAYS; // subtract extra days up to 10/14/1582
     
     return numDays;
     
 }
 
 public String ToString(){        // return the date as a string in a nice format
     return (month + "/" + day + "/" + year);
 }
}