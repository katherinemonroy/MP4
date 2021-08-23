/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4  - Faculty
 * This class is abstract and contains variables that all Faculty have and then prints all it's information.
 * ps... abstract b/c you should never create a Faculty. thus preventing from having to repeat this code in every other class.
 * @version 1.0
 */
public abstract class Faculty extends Affiliates {
  /** private member - Long for their unique facultyID */
  private long m_facultyID;
  /** private member - String for their department they work in */
  private String m_department;
  /** private member - Int for their yearly salary */
  private int m_yearlySalary;
  /** private member - Int for the number of papers they have */
  private int m_numOfPapers;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman with super()
   * m_facultyID to 0, m_department to Clown Department, m_yearlySalary to 100000, and m_numOfPapers to 0 */
  public Faculty() {
    super();
    m_facultyID = 0;
    m_department = "Clown Department";
    m_yearlySalary = 100000;
    m_numOfPapers = 0;
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_facultyID to facultyID, String m_department to department, Int m_yearlySalary to yearlySalary, and Int m_numOfPapers to numOfPapers.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param facultyID Long - unique faculty ID
    * @param department String - department they work in
    * @param yearlySalary Int - yearly salary of the affiliate
    * @param numOfPapers Int - number of papers they have bc they are a genius
    */
  public Faculty(String name, int age, String address, long phoneNum, int yearCameToChapman, long facultyID, String department, int yearlySalary, int numOfPapers) {
    super(name, age, address, phoneNum, yearCameToChapman);
    m_facultyID = facultyID;
    m_department = department;
    m_yearlySalary = yearlySalary;
    m_numOfPapers = numOfPapers;
  }

  /**
    * Copy constuctor - initializes all attributes of this Faculty to the fields of the passed in Faculty
    * @param copycat the Faculty to copy
    */
  public Faculty(Faculty copycat) {
    super(copycat);
    this.m_facultyID = copycat.m_facultyID;
    this.m_department = copycat.m_department;
    this.m_yearlySalary = copycat.m_yearlySalary;
    this.m_numOfPapers = copycat.m_numOfPapers;
  }

  /**
    * Mutator (Setter) that sets m_facultyID to facultyID.
    * @param facultyID long - their unique faculty ID
    */
  public void setFacultyID(long facultyID) {
    m_facultyID = facultyID;
  }

  /**
    * Accessor (getter) that returns m_facultyID.
    * @return long m_facultyID - unique faculty ID
    */
  public long getFacultyID() {
    return m_facultyID;
  }

  /**
    * Mutator (setter) that sets m_department to department.
    * @param department String - department they work in
    */
  public void setDepartment(String department) {
    m_department = department;
  }

  /**
    * Accessor (getter) that returns m_department.
    * @return String m_department - department they work in
    */
  public String getDepartment() {
    return m_department;
  }

  /**
    * Mutator (setter) that sets m_yearlySalary to yearlySalary.
    * @param yearlySalary Int - yearly salary of the affiliate
    */
  public void setYearlySalary(int yearlySalary) {
    m_yearlySalary = yearlySalary;
  }

  /**
    * Accessor (getter) that returns m_yearlySalary.
    * @return Int m_yearlySalary - yearly salary of the affiliate
    */
  public int getYearlySalary() {
    return m_yearlySalary;
  }

  /**
    * Mutator (setter) that sets m_numOfPapers to numOfPapers.
    * @param numOfPapers Int - number of papers they have bc they are a genius haha
    */
  public void setNumOfPapers(int numOfPapers) {
    m_numOfPapers = numOfPapers;
  }

  /**
    * Accessor (getter) that returns m_numOfPapers.
    * @return Int m_numOfPapers -  number of papers they have bc big brain
    */
  public int getNumOfPapers() {
    return m_numOfPapers;
  }

  /**
    * print method - prints all the information of this Faculty
    */
  public void print() {
    super.print();
    System.out.print("," + m_facultyID + "," + m_department + "," + m_yearlySalary + "," + m_numOfPapers);
  }
}
