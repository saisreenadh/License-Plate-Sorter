/**
*the CarOwner interface has setters and getters to obtain information about the car owners
* @author Saisreenadh Yandapalli, syandapalli89@gmail.com
* @version v1.0
* @since 12/14/22 
*/
public interface CarOwnerInterface extends Comparable{
/*
* setLicense sets newLicense equal to license
*@param newLicense is the string set equal to license
*/
void setLicense(String inLicense);
/*
* getLicense returns license
*@return license returns the license
*/
String getLicense();
/*
*setMonth sets newMonth equal to month
*@param newMonth is the value set equal to month
*/
void setMonth(int inMonth);
/*
*getMonth returns month
*@return month returns the month
*/
int getMonth();
/*
*setYear sets newYear equal to year
@param newYear is set equal to year
*/
void setYear(int inYear);
/*
*getYear returns year
*@return year returns the year
*/
int getYear();
/** 
  * overrides compareTo to sort CarOwners based on chronological 
  * of month and year car was last.  If param is null or not CarOwner 
class, returns -1 
  * if object total months < param total months, temp is -1, object total 
months > param total months, temp is 1 
  * otherwise the same and temp is 0 
  * @return temp 
*/ 
int compareTo(Object o);
/*
*toString returns a string with the persons license month and year
*@return s is the string with the persons license month and year
*/
String toString();
}
