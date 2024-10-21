/**
*CitizenInterface uses different methods to set and get both the first and last name of the Citizen.
* @author Saisreenadh Yandapalli, syandapalli89@gmail.com
* @version v1.0
* @since 12/14/22 
*/
public interface CitizenInterface {
/*
*getFirstName returns first name
*@return firstName returns the persn's first name 
*/
String getFirstName();
/*
*setFirstName sets newFirstName equal to firstName
*@param newFirstName is the stirng set equal to firstName
*/
void setFirstName(String newFirstName);
/*
*getFirstName returns first name
*@return firstName returns the persn's first name 
*/
String getLastName();
/*
*setLastName sets newLastName equal to lastName
*@param newLastName is set equal to lastName
*/
void setLastName(String newLastName);
/*
*toString returns the person's first and last name
*return name returns the persons full name
*/
String toString();
}