/**

 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4  - Undergrad
 * This class creates an Undergrad object, which is also a Affiliates and a Students, and then prints it's information.
 * @version 1.0
 */
public class Undergrad extends Students {
  /** private member - Int number of courses they have taken */
  private int m_numOfCoursesTaken;
  /** private member - double for their scholarship amount */
  private double m_scholarshipAmount;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_studentID, m_major, m_minor, m_classStanding for super(), m_numOfCoursesTaken to 0, and m_scholarshipAmount to 0.0 */
  public Undergrad() {
    super();
    m_numOfCoursesTaken = 0;
    m_scholarshipAmount = 0.0;
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_studentID to studentID, String m_major to major, String m_minor to minor, String m_classStanding to classStanding, Int m_numOfCoursesTaken to numOfCoursesTaken, and double m_scholarshipAmount to scholarshipAmount.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param studentID Long - unique student ID
    * @param major String - their major
    * @param minor String - their minor
    * @param classStanding String - their class standing
    * @param numOfCoursesTaken Int - number of courses they have taken
    * @param scholarshipAmount Double - scholarship amount
    */
  public Undergrad(String name, int age, String address, long phoneNum, int yearCameToChapman, long studentID, String major, String minor, String classStanding, int numOfCoursesTaken, double scholarshipAmount) {
    super(name, age, address, phoneNum, yearCameToChapman, studentID, major, minor, classStanding);
    m_numOfCoursesTaken = numOfCoursesTaken;
    m_scholarshipAmount = scholarshipAmount;
  }

  /**
    * Copy constuctor - initializes all attributes of this Undergrad to the fields of the passed in Undergrad
    * @param copycat the Undergrad to copy
    */
  public Undergrad(Undergrad copycat) {
    super(copycat);
    this.m_numOfCoursesTaken = copycat.m_numOfCoursesTaken;
    this.m_scholarshipAmount = copycat.m_scholarshipAmount;
  }

  /**
    * Mutator (setter) that sets m_numOfCoursesTaken to numOfCoursesTaken.
    * @param numOfCoursesTaken Int - number of courses taken
    */
  public void setNumOfCoursesTaken(int numOfCoursesTaken) {
    m_numOfCoursesTaken = numOfCoursesTaken;
  }

  /**
    * Accessor (getter) that returns m_numOfCoursesTaken.
    * @return Int m_numOfCoursesTaken - number of courses taken
    */
  public int getNumOfCoursesTaken() {
    return m_numOfCoursesTaken;
  }

  /**
    * Mutator (setter) that sets m_scholarshipAmount to scholarshipAmount.
    * @param scholarshipAmount Double - their scholarship amount
    */
  public void setScholarshipAmount(double scholarshipAmount) {
    m_scholarshipAmount = scholarshipAmount;
  }

  /**
    * Accessor (getter) that returns m_scholarshipAmount.
    * @return Double m_scholarshipAmount - scholarship amount
    */
  public double getScholarshipAmount() {
    return m_scholarshipAmount;
  }

  /**
    * print method - prints all the information of the Undergrad
    */
  public void print() {
    super.print();
    System.out.println("," + m_numOfCoursesTaken + "," + m_scholarshipAmount);
  }
}
