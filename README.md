# License-Plate-Sorter

This Java-based application manages and processes car owner registration data. The system allows users to view, sort, and analyze car owner information based on their registration dates. Key functionalities include:

- Display Initial Data: Lists all car owners and their vehicle registration details.
- Sort by Registration Date: Automatically sorts car owners based on their registration date.
- Identify Expired Registrations: Flags car owners whose vehicle registrations have expired.
- Upcoming Expirations: Identifies and lists car owners whose registrations will expire within the next three months.
  
## Features:
- Java Interfaces and Classes: The project includes multiple interfaces and classes to manage car owner details, registration processing, and sorting functionalities.
- CSV Data Integration: Registration data is read from a CSV file, processed, and output in a user-friendly format.
- Output Summary: The results are presented in a text format that includes unsorted, sorted, and filtered lists based on expiration status.

## Example Output:
- Sorted car owner list based on registration date.
- Owners with expired registrations.
- Owners whose registrations will expire soon.

## Files Included:
- CarOwner.java, Citizen.java, RegistrationMethods.java for handling object creation and data processing.
- Compiled .class files for running the program.
- registration.csv: Contains initial car owner registration data.
- output.txt: Sample output showing sorted and filtered car owner data.
