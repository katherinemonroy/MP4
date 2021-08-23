/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4  - Students
 * This abstract class contains variables that all Students have and then prints all it's information.
 * ps... abstract class bcyou should never create a Students. thus prevents from having to repeat this code in every other class.
 * @version 1.0
 */
public abstract class Students extends Affiliates {
  /** private member - Long unique studentID */
  private long m_studentID;
  /** private member - String for their major */
  private String m_major;
  /** private member - String for their minor */
  private String m_minor;
  /** private member - String for class standing */
  private String m_classStanding;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman with super(), m_studentID to 0, m_major to Clown Degree, m_minor to Bird Whisperer, and m_classStanding to Freshman */
  public Students() {
    super();
    m_studentID = 0;
    m_major = "Clown Degree";
    m_minor = "Bird Whisperer";
    m_classStanding = "Freshman";
  }

  /**
    * Overloaded constuctor initializing String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_studentID to studentID, String m_major to major, String m_minor to minor, and String m_classStanding to classStanding.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param studentID Long - unique student ID
    * @param major String - their major
    * @param minor String - their minor
    * @param classStanding String - their class standing
    */
  public Students(String name, int age, String address, long phoneNum, int yearCameToChapman, long studentID, String major, String minor, String classStanding) {
    super(name, age, address, phoneNum, yearCameToChapman);
    m_studentID = studentID;
    m_major = major;
    m_minor = minor;
    m_classStanding = classStanding;
  }

  /**
    * Copy constuctor - initializes all attributes of this Students to the fields of the passed in Students
    * @param copycat the Students to copy
    */
  public Students(Students copycat) {
    super(copycat);
    this.m_studentID = copycat.m_studentID;
    this.m_major = copycat.m_major;
    this.m_minor = copycat.m_minor;
    this.m_classStanding = copycat.m_classStanding;
  }

  /**
    * Mutator (setter) that sets m_studentID to studentID.
    * @param studentID Long - student ID
    */
  public void setStudentID(long studentID) {
    m_studentID = studentID;
  }

  /**
    * Accessor (getter) that returns m_studentID.
    * @return Long m_studentID - unique student ID
    */
  public long getStudentID() {
    return m_studentID;
  }

  /**
    * Mutator (setter) that sets m_major to major.
    * @param major String - their major
    */
  public void setMajor(String major) {
    m_major = major;
  }

  /**
    * Accessor (getter) that returns m_major.
    * @return String m_major - their major
    */
  public String getMajor() {
    return m_major;
  }

  /**
    * Mutator(setter) that sets m_minor to minor.
    * @param minor String - their minor
    */
  public void setMinor(String minor) {
    m_minor = minor;
  }

  /**
    * Accessor (getter) that returns m_minor.
    * @return String m_minor - their minor
    */
  public String getMinor() {
    return m_minor;
  }

  /**
    * Mutator (setter) that sets m_classStanding to classStanding.
    * @param classStanding String - their class standing
    */
  public void setClassStanding(String classStanding) {
    m_classStanding = classStanding;
  }

  /**
    * Accessor (getter) that returns m_classStanding.
    * @return String m_classStanding - their class standing
    */
  public String getClassStanding() {
    return m_classStanding;
  }

  /**
    * print method - prints all the information of the Student
    */
  public void print() {
    super.print();
    System.out.print("," + m_studentID + "," + m_major + "," + m_minor + "," + m_classStanding);
  }
}
