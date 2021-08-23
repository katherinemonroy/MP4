/**
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4  - AffiliatesDriver
 * This class runs the entire program in order to create and manipulate a database of inputted Affiliates at Chapman University.
 * The user is given the following options:
 * 1) will create an affiliate record
 * 2) will print information for an Affiliate given the id
 * 3) will list all affiliates in order of seniority
 * 4) will delete a record given the id
 * 5) will save your database to a file
 * 6) will restore your database from a file
 * 7) will exit
 * @version 1.0
 */

import java.io.*;
import java.util.*;
public class AffiliatesDriver {
  /** private member - HashMap which contains the database and maps IDs to Affiliates */
  private static HashMap<Long, Affiliates> database = new HashMap<Long, Affiliates>();
  /** private member - declares scanner so all methods can access it */
  private static Scanner scan = new Scanner(System.in);

  /**
    * The printOptions() method gives user options (1-7). If anything else is entered, they'll be reminded to choose from 1-7.
    * If they choose 1, they will be asked to choose an Affiliates type and call a method to enter all the info to create it, and it'll be stored in the database.
    * They'll be reminded that they can only input one of the given options if they enter anything else.
    * If they choose 2, the printInfo() method is used to prompt for an ID and the information for that Affiliates will print if it exists, or else they'll be told it doesn't exist.
    * If they choose 3, the listInOrder() method is uesed to sort the Affiliates from the database by the year they came to Chapman and print them.
    * If they choose 4, the deleteRecord() method prompts for an ID and deletes the Affiliates from the database that has that ID.
    * If they choose 5, the method deleteRecord() has the user chooses a file to write the database into and writes the Affiliates from the database into the file,
    * one per line, printing by level of class hierarchy and alphabetizing within each level by using the getVariables() method.
    * If they choose 6, the database will be cleared and filled with the Affiliates from the chosen file by using the restoreDatabase() method.
    * If they choose 7, the program will end.
    * @param args command-line arguments
    */
  public static void main (String [] args) {

    String choice;
    do {
      printOptions();
      choice = scan.nextLine();
      switch (choice) {
        case "1":
          System.out.println("What kind of Affiliate would you like to create? (Assistant, Associate, Full, Graduate, Undergrad, FullTime, PartTime)");
          String creation = scan.nextLine();
          switch (creation) {
            case "Assistant":
              createAssistant();
              break;
            case "Associate":
              createAssociate();
              break;
            case "Full":
              createFull();
              break;
            case "Graduate":
              createGraduate();
              break;
            case "Undergrad":
              createUndergrad();
              break;
            case "FullTime":
              createFullTime();
              break;
            case "PartTime":
              createPartTime();
              break;
            default:
              System.out.println("Invalid choice, you can only enter one of the classes listed");
          }
          break;
        case "2":
          printInfo();
          break;
        case "3":
          listInOrder();
          break;
        case "4":
          deleteRecord();
          break;
        case "5":
          System.out.println("Enter the desired file name to write the database onto: ");
          String fileName = scan.nextLine();
          String write = "";
          for (Affiliates value: database.values()) {
            write += getVariables(value) + "\n";
          }
          try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            pw.println(write);
            pw.close();
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            break;
          }
        case "6":
          restoreDatabase();
          break;
        case "7":
          System.out.println("Program terminated.");
          break;
        default:
          System.out.println("Invalid choice, please enter an integer 1-7");
          break;
      }
    } while (!choice.equals("7"));
  }

  /** printoptions method - gives the starting menu the user has to choose from */
  public static void printOptions() {
    System.out.println("Choose one of the following options (1-7)");
    System.out.println("1) Create an affiliate record");
    System.out.println("2) Print information for an Affiliate given the id");
    System.out.println("3) List all affiliates in order of seniority");
    System.out.println("4) Delete a record given the id");
    System.out.println("5) Save your database to a file");
    System.out.println("6) Restore your database from a file");
    System.out.println("7) Exit");
  }

  /** printInfo method -  asks for an ID and prints the Affiliates' info by using it's print() method if it exists in the database and then tells you if it isn't in database */
  public static void printInfo() {
    System.out.println("Enter an ID to print the information of that Affiliate: ");
    long id = scan.nextLong();
    scan.nextLine(); //devours newline after int
    if (database.containsKey(id)) {
      Affiliates info = database.get(id);
    info.print();
    } else {
      System.out.println("There are no affiliates with that ID");
    }
  }

  /**
    * listInOrder method - sorts affiliates in database by seniority and prints them in that order.
    */
  public static void listInOrder() {
    ArrayList<Affiliates> orderedBySeniority = new ArrayList<Affiliates>(); //puts all Affiliates from database into an ArrayList,
    for (Affiliates value: database.values()) {
      orderedBySeniority.add(value);
    }
    for (int i = orderedBySeniority.size()-1; i >= 0; --i) {
      for (int j = 0; j < i; ++j) { //Uses bubble sort algorithm to sort ArrayList by using getYearCameToChapman() method,
        if (orderedBySeniority.get(j).getYearCameToChapman() > orderedBySeniority.get(j+1).getYearCameToChapman()) {
          Collections.swap(orderedBySeniority, j, j+1);
        }
      }
    }
    for (Affiliates ordered: orderedBySeniority) {
      ordered.print(); //Prints Affiliates from ArrayList in order.
    }
  }

  /** deleteRecord method - asks for ID and then deletes that Affiliate from the database */
  public static void deleteRecord() {
    System.out.println("Enter the ID of the Affiliate you want to delete from the database: ");
    long deleteID = scan.nextLong();
    scan.nextLine(); //devours newline after int
    database.remove(deleteID);
  }

  /**
    * getVariables method -  checks what class type this Affiliates is
    * then adds all of it's instance variables to a String by using it's getter methods, and returns that String
    * @param aff the Affiliates to print to the file
    * @return String - a whole line that gets printed to the file
    */
  public static String getVariables(Affiliates aff) {
    String ret = "";
    if (aff instanceof Assistant) {
      Assistant a = (Assistant)aff;
      ret += "Assistant,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getDepartment() + ",";
      ret += String.valueOf(a.getFacultyID()) + ",";
      ret += String.valueOf(a.getYearlySalary()) + ",";
      ret += String.valueOf(a.getNumOfPapers()) + ",";
      ret += String.valueOf(a.getYearsUntilTenure());
    } else if (aff instanceof Associate) {
      Associate a = (Associate)aff;
      ret += "Associate,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getDepartment() + ",";
      ret += String.valueOf(a.getFacultyID()) + ",";
      ret += String.valueOf(a.getYearlySalary()) + ",";
      ret += String.valueOf(a.getNumOfPapers()) + ",";
      ret += String.valueOf(a.getYearsSinceTenure());
    } else if (aff instanceof Full) {
      Full a = (Full)aff;
      ret += "Full,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getDepartment() + ",";
      ret += String.valueOf(a.getFacultyID()) + ",";
      ret += String.valueOf(a.getYearlySalary()) + ",";
      ret += String.valueOf(a.getNumOfPapers()) + ",";
      ret += String.valueOf(a.getYearsUntilRetirement());
    } else if (aff instanceof Graduate) {
      Graduate a = (Graduate)aff;
      ret += "Graduate,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getClassStanding() + ",";
      ret += String.valueOf(a.getStudentID()) + ",";
      ret += a.getMajor() + ",";
      ret += a.getMinor() + ",";
      ret += String.valueOf(a.getNumOfPapersPublished()) + ",";
      ret += a.getThesisAdvisor();
    } else if (aff instanceof Undergrad) {
      Undergrad a = (Undergrad)aff;
      ret += "Undergrad,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getClassStanding() + ",";
      ret += String.valueOf(a.getStudentID()) + ",";
      ret += a.getMajor() + ",";
      ret += a.getMinor() + ",";
      ret += String.valueOf(a.getNumOfCoursesTaken()) + ",";
      ret += a.getScholarshipAmount();
    } else if (aff instanceof FullTime) {
      FullTime a = (FullTime)aff;
      ret += "FullTime,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getBuilding() + ",";
      ret += String.valueOf(a.getStaffID()) + ",";
      ret += a.getTitle() + ",";
      ret += String.valueOf(a.getYearlySalary()) + ",";
    } else { // PartTime
      PartTime a = (PartTime)aff;
      ret += "PartTime,";
      ret += a.getAddress() + ",";
      ret += String.valueOf(a.getAge()) + ",";
      ret += a.getName() + ",";
      ret += String.valueOf(a.getPhoneNum()) + ",";
      ret += String.valueOf(a.getYearCameToChapman()) + ",";
      ret += a.getBuilding() + ",";
      ret += String.valueOf(a.getStaffID()) + ",";
      ret += a.getTitle() + ",";
      ret += String.valueOf(a.getHourlySalary()) + ",";
    }
    return ret;
  }

  /** restoreDatabase method - clears database and restores it by reading the contents of a file of the user's choosing by creating a new Affiliates from the line using the Overloaded constructors. */
  public static void restoreDatabase() {
    database.clear();
    System.out.println("Enter the disired file name to read from and restore the database from");
    String readFrom = scan.nextLine();
    try {
      BufferedReader br = new BufferedReader(new FileReader(readFrom));
      String line = "";
      while ((line=br.readLine()) != null) { //gets whole line from file
        String[] arrOfStr = line.split(","); //arr of each string from an affiliate from file
        if (arrOfStr[0].equals("Assistant")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int facultyID, String department, int yearlySalary, int numOfPapers, int yearsUntilTenure
          Assistant asi = new Assistant(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[6], Integer.parseInt(arrOfStr[8]), Integer.parseInt(arrOfStr[9]), Integer.parseInt(arrOfStr[10]));
          database.put(Long.parseLong(arrOfStr[7]), asi);
        } else if (arrOfStr[0].equals("Associate")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int facultyID, String department, int yearlySalary, int numOfPapers, int yearsSinceTenure
          Associate aso = new Associate(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[6], Integer.parseInt(arrOfStr[8]), Integer.parseInt(arrOfStr[9]), Integer.parseInt(arrOfStr[10]));
          database.put(Long.parseLong(arrOfStr[7]), aso);
        } else if (arrOfStr[0].equals("Full")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int facultyID, String department, int yearlySalary, int numOfPapers, int yearsUntilRetirement
          Full fu = new Full(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[6], Integer.parseInt(arrOfStr[8]), Integer.parseInt(arrOfStr[9]), Integer.parseInt(arrOfStr[10]));
          database.put(Long.parseLong(arrOfStr[7]), fu);
        } else if (arrOfStr[0].equals("Graduate")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int studentID, String major, String minor, String classStanding, int numOfPapersPublished, String thesisAdvisor
          Graduate gr = new Graduate(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[8], arrOfStr[9], arrOfStr[6], Integer.parseInt(arrOfStr[10]), arrOfStr[11]);
          database.put(Long.parseLong(arrOfStr[7]), gr);
        } else if (arrOfStr[0].equals("Undergrad")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int studentID, String major, String minor, String classStanding, int numOfCoursesTaken, double scholarshipAmount
          Undergrad ug = new Undergrad(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[8], arrOfStr[9], arrOfStr[6], Integer.parseInt(arrOfStr[10]), Double.parseDouble(arrOfStr[11]));
          database.put(Long.parseLong(arrOfStr[7]), ug);
        } else if (arrOfStr[0].equals("FullTime")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int staffID, String title, String building, double yearlySalary
          FullTime ft = new FullTime(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[8], arrOfStr[6], Double.parseDouble(arrOfStr[9]));
          database.put(Long.parseLong(arrOfStr[7]), ft);
        } else if (arrOfStr[0].equals("PartTime")) { //order of arguments below: String name, int age, String address, int phoneNum, int yearCameToChapman, int staffID, String title, String building, double hourlySalary
          PartTime pt = new PartTime(arrOfStr[3], Integer.parseInt(arrOfStr[2]), arrOfStr[1], Long.parseLong(arrOfStr[4]), Integer.parseInt(arrOfStr[5]), Long.parseLong(arrOfStr[7]), arrOfStr[8], arrOfStr[6], Double.parseDouble(arrOfStr[9]));
          database.put(Long.parseLong(arrOfStr[7]), pt);
        } else {
          break;
        }
      }
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println("Database restored!");
    }
  }

  /** createAssistant method - creates an Assistant and puts it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createAssistant() {
    try {
      System.out.println("Enter their name: ");
      String name = scan.nextLine();
      System.out.println("Enter their age: ");
      int age = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their address: ");
      String address = scan.nextLine();
      System.out.println("Enter their phone number: ");
      long phoneNum = scan.nextLong();
      scan.nextLine(); //devours new line after int
      System.out.println("Enter the year they came to chapman: ");
      int yearCameToChapman = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their faculty ID: ");
      long facultyID = scan.nextLong();
      scan.nextLine();
      System.out.println("Enter their department: ");
      String department = scan.nextLine();
      System.out.println("Enter their yearly salary: ");
      int yearlySalary = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter the number of papers they have: ");
      int numOfPapers = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter the years they have until tenure");
      int yearsUntilTenure = scan.nextInt();
      scan.nextLine(); //devours newline after int
      Assistant a = new Assistant(name, age, address, phoneNum, yearCameToChapman, facultyID, department, yearlySalary, numOfPapers, yearsUntilTenure);
      database.put(facultyID, a);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** createAssociate method - creates an Associate and puts it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createAssociate() {
    try {
    System.out.println("Enter their name: ");
    String name = scan.nextLine();
    System.out.println("Enter their age: ");
    int age = scan.nextInt();
    scan.nextLine(); //devours newline after int
    System.out.println("Enter their address: ");
    String address = scan.nextLine();
    System.out.println("Enter their phone number: ");
    long phoneNum = scan.nextLong();
    scan.nextLine(); //devours new line after int
    System.out.println("Enter the year they came to chapman: ");
    int yearCameToChapman = scan.nextInt();
    scan.nextLine(); //devours newline after int
    System.out.println("Enter their faculty ID: ");
    long facultyID = scan.nextLong();
    scan.nextLine();
    System.out.println("Enter their department: ");
    String department = scan.nextLine();
    System.out.println("Enter their yearly salary: ");
    int yearlySalary = scan.nextInt();
    scan.nextLine(); //devours newline after int
    System.out.println("Enter the number of papers they have: ");
    int numOfPapers = scan.nextInt();
    scan.nextLine(); //devours newline after int
    System.out.println("Enter the years they have since tenure");
    int yearsSinceTenure = scan.nextInt();
    scan.nextLine(); //devours newline after int
    Associate b = new Associate(name, age, address, phoneNum, yearCameToChapman, facultyID, department, yearlySalary, numOfPapers, yearsSinceTenure);
    database.put(facultyID, b);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** createFull method - creates a Full and putting it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createFull() {
    try {
      System.out.println("Enter their name: ");
      String name = scan.nextLine();
      System.out.println("Enter their age: ");
      int age = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their address: ");
      String address = scan.nextLine();
      System.out.println("Enter their phone number: ");
      long phoneNum = scan.nextLong();
      scan.nextLine(); //devours new line after int
      System.out.println("Enter the year they came to chapman: ");
      int yearCameToChapman = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their faculty ID: ");
      long facultyID = scan.nextLong();
      scan.nextLine();
      System.out.println("Enter their department: ");
      String department = scan.nextLine();
      System.out.println("Enter their yearly salary: ");
      int yearlySalary = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter the number of papers they have: ");
      int numOfPapers = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter the years they have until retirement");
      int yearsUntilRetirement = scan.nextInt();
      scan.nextLine(); //devours newline after int
      Full c = new Full(name, age, address, phoneNum, yearCameToChapman, facultyID, department, yearlySalary, numOfPapers, yearsUntilRetirement);
      database.put(facultyID, c);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** createGraduate method - creates a Graduate and puts it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createGraduate() {
    try {
      System.out.println("Enter their name: ");
      String name = scan.nextLine();
      System.out.println("Enter their age: ");
      int age = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their address: ");
      String address = scan.nextLine();
      System.out.println("Enter their phone number: ");
      long phoneNum = scan.nextLong();
      scan.nextLine(); //devours new line after int
      System.out.println("Enter the year they came to chapman: ");
      int yearCameToChapman = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their student ID: ");
      long studentID = scan.nextLong();
      scan.nextLine();
      System.out.println("Enter their major: ");
      String major = scan.nextLine();
      System.out.println("Enter their minor: ");
      String minor = scan.nextLine();
      System.out.println("Enter their class standing: ");
      String classStanding = scan.nextLine();
      System.out.println("Enter their number of papers published: ");
      int numOfPapersPublished = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their thesis advisor: ");
      String thesisAdvisor = scan.nextLine();
      Graduate d = new Graduate(name, age, address, phoneNum, yearCameToChapman, studentID, major, minor, classStanding, numOfPapersPublished, thesisAdvisor);
      database.put(studentID, d);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** createUndergrad method - creates an Undergrad and putting it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createUndergrad() {
    try {
      System.out.println("Enter their name: ");
      String name = scan.nextLine();
      System.out.println("Enter their age: ");
      int age = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their address: ");
      String address = scan.nextLine();
      System.out.println("Enter their phone number: ");
      long phoneNum = scan.nextLong();
      scan.nextLine(); //devours new line after int
      System.out.println("Enter the year they came to chapman: ");
      int yearCameToChapman = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their student ID: ");
      long studentID = scan.nextLong();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their major: ");
      String major = scan.nextLine();
      System.out.println("Enter their minor: ");
      String minor = scan.nextLine();
      System.out.println("Enter their class standing: ");
      String classStanding = scan.nextLine();
      System.out.println("Enter their number of courses taken: ");
      int numOfCoursesTaken = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their scholarship amount: ");
      double scholarshipAmount = scan.nextDouble();
      scan.nextLine(); //devours newline after int
      Undergrad e = new Undergrad(name, age, address, phoneNum, yearCameToChapman, studentID, major, minor, classStanding, numOfCoursesTaken, scholarshipAmount);
      database.put(studentID, e);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** createFullTime method - creates FullTime and puts it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createFullTime() {
    try {
      System.out.println("Enter their name: ");
      String name = scan.nextLine();
      System.out.println("Enter their age: ");
      int age = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their address: ");
      String address = scan.nextLine();
      System.out.println("Enter their phone number: ");
      long phoneNum = scan.nextLong();
      scan.nextLine(); //devours new line after int
      System.out.println("Enter the year they came to chapman: ");
      int yearCameToChapman = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their staff ID: ");
      long staffID = scan.nextLong();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their title: ");
      String title = scan.nextLine();
      System.out.println("Enter their building: ");
      String building = scan.nextLine();
      System.out.println("Enter their yearly salary: ");
      int yearlySalary = scan.nextInt();
      scan.nextLine(); //devours newline after int
      FullTime f = new FullTime(name, age, address, phoneNum, yearCameToChapman, staffID, title, building, yearlySalary);
      database.put(staffID, f);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** createPartTime method - creates PartTime and puts it into the database by asking the user for all of its information - catches/prints Exception if invalid type is entered and returns to main menu options (1-7). */
  public static void createPartTime() {
    try {
      System.out.println("Enter their name: ");
      String name = scan.nextLine();
      System.out.println("Enter their age: ");
      int age = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their address: ");
      String address = scan.nextLine();
      System.out.println("Enter their phone number: ");
      long phoneNum = scan.nextLong();
      scan.nextLine(); //devours new line after int
      System.out.println("Enter the year they came to chapman: ");
      int yearCameToChapman = scan.nextInt();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their staff ID: ");
      long staffID = scan.nextLong();
      scan.nextLine(); //devours newline after int
      System.out.println("Enter their title: ");
      String title = scan.nextLine();
      System.out.println("Enter their building: ");
      String building = scan.nextLine();
      System.out.println("Enter their hourly salary: ");
      int hourlySalary = scan.nextInt();
      scan.nextLine(); //devours newline after int
      FullTime f = new FullTime(name, age, address, phoneNum, yearCameToChapman, staffID, title, building, hourlySalary);
      database.put(staffID, f);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
