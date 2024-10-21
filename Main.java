import java.util.*;
/**
*The main class calls methods to process data and rewrite it twice and then read them from a binary file.
* @author Saisreenadh Yandapalli, syandapalli89@gmail.com
* @version v1.0
* @since 12/14/22 
*/

public class Main {
  public static void main(String[] args) {
    RegistrationMethods dmv = new RegistrationMethods();
    dmv.setFileNames();
    ArrayList<CarOwner> ltState = new ArrayList<CarOwner>();
    dmv.processTextToArrayList(ltState);
    dmv.printArrayListToFile(ltState, "Initial Set of Car Owners - Unsorted:");
    dmv.writeListToBinary(ltState);
    CarOwner[] ltStateCopy = dmv.readListFromBinary();
    Arrays.sort(ltStateCopy);
    dmv.printArrayToFile(ltStateCopy, "Sorted list based on Registration date:");
    CarOwner[] overdue = dmv.flagOverdueOwners(ltStateCopy);
    dmv.printArrayToFile(overdue, "Owners with Expired Registration:");
    CarOwner[] almostDue = dmv.flagAlmostDueOwners(ltStateCopy);
    dmv.printArrayToFile(almostDue, "Owners with registration expiring in three months or less:");
}}