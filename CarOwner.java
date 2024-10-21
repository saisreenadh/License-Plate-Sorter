import java.io.Serializable;

/**
* Car owner has all of the information about the car owner and also is the subclass of Citizen
* @author Saisreenadh Yandapalli, syandapalli89@gmail.com
* @version v1.0
* @since 12/14/22 
*/

public class CarOwner extends Citizen implements CarOwnerInterface, Serializable{
private String license;
private int month;
private int year;

/*
* This constructor sets the month and year to 0 and the license to not assigned yet and uses the super class
*/

public CarOwner(){
super();
license = "Not Assigned";
month = 0;
year = 0;
}

/*
* This constructor uses the super class, and also sets newLicense newMonth and newYear equal to their non new counterparts
*@param firstName is the first name
*@param lastName is the last name
*@param newLicense is set equal to license
*@param newYear is set equal to year
*@param newMonth is set equal to month
*/
public CarOwner(String firstName, String lastName, String newLicense, int newMonth, int newYear){
super(firstName, lastName);
license = newLicense;
month = newMonth;
year = newYear;
    }
/*
* setLicense sets newLicense equal to license
*@param newLicense is the string set equal to license
*/
public void setLicense(String newLicense){
license = newLicense;
  }
/*
* getLicense returns license
*@return license returns the license
*/
public String getLicense(){
return license;
  }
/*
*setMonth sets newMonth equal to month
*@param newMonth is the value set equal to month
*/
public void setMonth(int newMonth){
month = newMonth;
  }
/*
*getMonth returns month
*@return month returns the month
*/
public int getMonth(){
return month;
  }
/*
*setYear sets newYear equal to year
@param newYear is set equal to year
*/
public void setYear(int newYear){
year = newYear;
  }
/*
*getYear returns year
*@return year returns the year
*/
public int getYear(){
return year;
  }

@Override 
/** 
  * overrides compareTo to sort CarOwners based on chronological 
  * of month and year car was last.  If param is null or not CarOwner 
class, returns -1 
  * if object total months < param total months, temp is -1, object total 
months > param total months, temp is 1 
  * otherwise the same and temp is 0 
  * @return temp 
*/ 
public int compareTo(Object o){ 
int temp = -1; 
if(o != null && getClass() == o.getClass()){ 
CarOwner copy = (CarOwner)o; 
if((year*12+month) < (copy.year*12+copy.month)) 
temp = -1; 
else if ((year*12+month) > (copy.year*12+copy.month)) 
temp = 1; 
else
temp = 0; 
} 
return temp; 
}
/*
*toString returns a string with the persons license month and year
*@return s is the string with the persons license month and year
*/
public String toString(){
  String s = super.toString() + "\t" + license + "\t" + month + "/" + year;
      return s;
    }

    
  }