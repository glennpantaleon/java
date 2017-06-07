//Glenn Pantaleon 0789547
package project1;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Patient<T>
{
  protected String NAME; // patient's name 
  protected String ID; // patient's id 
  protected String ADDRESS;
  protected int HEIGHT;
  protected double WEIGHT;
  protected Date BIRTHDATE;
  protected Date INTIALVISIT;
  protected Date LASTVISIT;

  public Patient(String patientname, String patientid, String patientaddress, int patientheight, double patientweight, String patientDOB, String patientIV, String patientLV) 
  {
	  
  SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy"); // Formats Patient Info 
  this.NAME = patientname;
  this.ID = patientid;
  this.ADDRESS = patientaddress;
  this.HEIGHT= patientheight;
  this.WEIGHT = patientweight;
  try {
	  this.BIRTHDATE = format.parse(BIRTHDATE);
	  this.INTIALVISIT = format.parse(INTIALVISIT);
	  this.LASTVISIT = format.parse(LASTVISIT);
  	  } catch (ParseException e) 
  {

	e.printStackTrace();
  }
 }


  public String getName() 
  { 
  return NAME; 
  }

  public String getPatientid() 
  { 
  return ID; 
  }

  public String getaddress() 
  { 
  return ADDRESS; 
  }

   

  public int feet() // Height had to represented as a string in order
  {					// to show the patient's height in feet/inches
  return HEIGHT/12;
  }
  public int inches()
  {
  return HEIGHT%12;
  }
  public String getHeight()
  {
  return feet()+"ft"+" "+inches() + "in";
  }

 
  public Double getWeight() 
  { 
  return WEIGHT; 
  }

 
  public Date getBirthDate() 
  { 
  return BIRTHDATE; 
  }

 

  public Date getintialVisit() 
  { 
  return INTIALVISIT; 
  }

 

  public Date getlastVisit() 
  { 
  return LASTVISIT; 
  }

 

  @SuppressWarnings("deprecation")
public int get_age() //getting the age with Date class
  //Computes and returns a patient’s age in years ( in int)
  {
  Calendar c = Calendar.getInstance();
  int month= c.get(Calendar.MONTH)+1; //Since January is default 0
  int date= c.get(Calendar.DATE);
  int year= c.get(Calendar.YEAR);
  System.out.println(month+" "+year+" "+date);
  if(month >= BIRTHDATE.getMonth()&& date >= BIRTHDATE.getDay()){
  return year-BIRTHDATE.getYear()-1900;
  }
  else 
  return year-BIRTHDATE.getYear()-1901;
} 

 

  @SuppressWarnings("deprecation")

public int get_time_as_patient()

  //Compute the number of years ( in int) since the patient’s initial visit. 
  //Note: intial visit value can be 0.
  {
  Calendar c = Calendar.getInstance();
  int month= c.get(Calendar.MONTH)+1; //Since January is default 0
  int date= c.get(Calendar.DATE);
  int year= c.get(Calendar.YEAR);
  System.out.println(month+" "+year+" "+date);
  if(month >= INTIALVISIT.getMonth() && date >= INTIALVISIT.getDay()){// So if the value is a month is the same as the month of the initial visit but a day earlier than the initial visit date, it will realize it's still a year less than the anniversary.  
  return year-INTIALVISIT.getYear();
  }
  else 
  return year-INTIALVISIT.getYear()-1;
}

 

  @SuppressWarnings("deprecation")

public int get_time_since_last_visit()
  // Compute the number of years (in int) since the patient’s last visit.
  // Note: last visit value can be 0.
  {
  Calendar c = Calendar.getInstance();
  int month= c.get(Calendar.MONTH)+1; //Since January is default 0
  int date= c.get(Calendar.DATE);
  int year= c.get(Calendar.YEAR);
  System.out.println(month+" "+year+" "+date);
  if(month >= LASTVISIT.getMonth() && date >= LASTVISIT.getDay()){
  return year-LASTVISIT.getYear()-1900;
  }
  else 
  return year-LASTVISIT.getYear()-1901;
}


public String toStringsave() //returns string in a format. 
{
	return NAME + "\n" +ID + "\n" +ADDRESS+ "\n" + getHeight() + "\n" +WEIGHT+"lb"+ "\n" + BIRTHDATE+ "\n" + INTIALVISIT+ "\n" + LASTVISIT;
}
public String toString() // Returns a string version of this entry
  { 

  return "(" + NAME + ", " + ID + ")"; 

  }

}
