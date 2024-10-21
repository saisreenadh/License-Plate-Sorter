import java.util.*;
import java.io.*;
import java.util.Scanner;
/**
* Registration Methods class reads input files and prints to output files
* @author Saisreenadh Yandapalli, syandapalli89@gmail.com
* @version v1.0
* @since 12/14/22 
*/
public class RegistrationMethods implements RegistrationMethodsInterface{
public int REG_MONTH = 4;
public int REG_YEAR = 2022;
public String inputFileName;
public String outputFileName;
public String binFileName;
/**
     * Prompts the user to provide the location of the csv file to be processed 
     * (registration.csv), the location for where the user wants the output file 
     * saved (output.txt), and the location for the binary file 
(ltStateBinary.dat).
     */
public void setFileNames(){
Scanner scan = new Scanner(System.in);
System.out.println("Enter the path to the registration.csv file (ie registration.csv)");
inputFileName = scan.nextLine();
File newFile = new File(inputFileName);
while (!(newFile.exists())){
System.out.println("Enter the path to the registration.csv file (ie registration.csv)");
inputFileName = scan.nextLine();
newFile = new File(inputFileName);
}
System.out.println("Enter the path where output.txt should be saved (ie output.txt)");
outputFileName = scan.nextLine();
System.out.println("Enter the path where binFile.dat should be saved (ie binFile.dat)");
binFileName = scan.nextLine(); 
}
/**
     * Takes csv file (inputFileName) and parses out each record.  split() and 
nextLine() 
     * will be helpful.  For each line, create a CarOwner object and add to 
ArrayList <CarOwner>
     * collection
     */
public void processTextToArrayList(ArrayList<CarOwner> inList){
try{
File newFile = new File(inputFileName);
Scanner newStream = new Scanner(newFile);
String input = newStream.nextLine(); //clear
while (newStream.hasNextLine()) {
input = newStream.nextLine();
String[] tokens = input.split(",");
CarOwner temp = new CarOwner(tokens[1], tokens[0], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
inList.add(temp);
}
newStream.close();
}
catch (IOException e){
System.out.println("file error");
}
}
 /**
     * Prints out ArrayList passed in based on toString() along with passed in
     * message
     *
     * @param inList ArrayList<CarOwner> collection passed in to be written to
     * a text file
     * @param inMsg Message specific to the array being printed
     */
public void printArrayListToFile(ArrayList<CarOwner> inList, String inMsg){
try{
FileWriter newFileWriter = new FileWriter(outputFileName, true);
PrintWriter fileOut = new PrintWriter(newFileWriter);
fileOut.println(inMsg);
for (CarOwner var:inList){
fileOut.println(var);
}
fileOut.println("\n");
fileOut.close();
}
catch (IOException e){
System.out.println("file error");
}
}
 /**
     * Reads an ArrayList<CarOwner> collection from a binary file 
(ltStateBinary.dat).  
     * Then, each ArrayList object item is then written to a newly created 
CarOwner[], 
     * called temp.  temp is returned to the calling method.
     */
public CarOwner[] readListFromBinary(){
ArrayList<CarOwner> listTwo = new ArrayList<CarOwner>();
try{
FileInputStream fileIstream = new FileInputStream(binFileName);
ObjectInputStream fileInput = new ObjectInputStream(fileIstream);
listTwo = (ArrayList<CarOwner>) fileInput.readObject();
fileInput.close();
}
catch (FileNotFoundException e){
System.out.println("The file not was not found.");
}
catch (IOException e){
System.out.println("There was an error with the file.");
}
catch (ClassNotFoundException e){
System.out.println("The class was not found.");
}
CarOwner[] t = new CarOwner[listTwo.size()];
int i = 0;
for (CarOwner var:listTwo){
t[i] = var;
i++;
}
return t;
}
/**
     * Takes a ArrayList <CarOwner> collection as an input and creates a binary 
file output.  
     * The output file can later be read into the java program for processing.
     * 
     * @param inList ArrayList<CarOwner> collection
     */
public void writeListToBinary(ArrayList<CarOwner> inList){
try{
FileOutputStream streamOut = new FileOutputStream(binFileName);
ObjectOutputStream objectOutputFile = new ObjectOutputStream(streamOut);
objectOutputFile.writeObject(inList);
objectOutputFile.close();
}
catch (FileNotFoundException e){
System.out.println("There was no file found.");
}
catch (IOException e){
System.out.println("There was an error with the file.");
}
}
 /**
     * Prints out array passed in based on toString() along with passed in
     * message
     *
     * @param inArray CarOwner[] array to be written to a text file
     * @param inMsg Message specific to the array being printed
     */
public void printArrayToFile(CarOwner[] inArray, String inMsg){
try{
File fileOut = new File(outputFileName);
PrintWriter printWrite = new PrintWriter(new FileWriter(outputFileName, true));
printWrite.println(inMsg);
for(CarOwner var:inArray){
printWrite.println(var);
}
printWrite.println("\n");
printWrite.close();
}
catch(IOException e){
System.out.println("There was an error with the file.");
}}
/**
     * Method that generates and returns an array for vehicles whose
     * registration have expired defined as registration is over 12 months old
     * based on current REG_MONTH and REG_YEAR.
     *
     * @param inArray CarOwner[]
     */
public CarOwner[] flagOverdueOwners(CarOwner[] inArray){
int monthsTotal=(REG_YEAR*12)+REG_MONTH;
int count=0;
int s=0;
for (int i=0; i<inArray.length; i++){
int num = monthsTotal-((inArray[i].getYear()*12) + inArray[i].getMonth());
if (num>12)
count++;
}
CarOwner[] temp = new CarOwner[count];
for (int i=0; i<inArray.length; i++){
int num = monthsTotal - ((inArray[i].getYear()*12) + inArray[i].getMonth());
if(num>12){
temp[s] = inArray[i];
s++;
}
}
return temp;
}
 /**
     * Method that generates and returns an array for vehicles whose
     * registration will expire in three months or less. The state of Looney
     * Tunes sends a reminder three months out to the car owner.
     *
     * @param inArray CarOwner[]
     */
public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray){
int monthsTotal = (REG_YEAR*12) + REG_MONTH;
int s = 0;
int count =0;
for (int i=0; i<inArray.length; i++){
int num = monthsTotal - (inArray[i].getYear()*12 + inArray[i].getMonth());
if (num>9&&num<=12)
count++;
}
CarOwner[] temp = new CarOwner[count];
for (int i=0; i<inArray.length; i++){
int num = monthsTotal - ((inArray[i].getYear()*12) + inArray[i].getMonth());
if (num>9&&num<=12){
temp[s] = inArray[i];
s++;
}
}
return temp;
}  
}