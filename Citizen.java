import java.io.Serializable;
/**
* the citizen class implements CitizenInterface and Serializable and has the first and last name of the citizen.
* @author Saisreenadh Yandapalli, syandapalli89@gmail.com
* @version v1.0
* @since 12/14/22 
*/
public class Citizen implements CitizenInterface, Serializable {
private String firstName;
private String lastName;

/*
* This constructor sets the first and last name equal to no name
*/

public Citizen(){
firstName = "No Name";
lastName = "No Name";
}
/*
* This constructor sets newFirstName and newLastName equal to their non new counterparts
*@param newFirstName is the string set equal to firstName
*@param newLastName is the string set equal to lastName
*/
public Citizen(String newFirstName, String newLastName){
firstName = newFirstName;
lastName = newLastName;
}
/*
*setFirstName sets newFirstName equal to firstName
*@param newFirstName is the stirng set equal to firstName
*/
public void setFirstName(String newFirstName){
firstName = newFirstName;
}
/*
*getFirstName returns first name
*@return firstName returns the persn's first name 
*/
public String getFirstName(){
return firstName;
}
/*
*setLastName sets newLastName equal to lastName
*@param newLastName is set equal to lastName
*/
public void setLastName(String newLastName){
lastName = newLastName;
}
/*
*getLastName returns lastName
*@return lastName returns the person's last name
*/
public String getLastName(){
return lastName;
}
/*
*toString returns the person's first and last name
*return name returns the persons full name
*/
public String toString(){
String name = firstName + " " + lastName;
return name;
    }
}