/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Graduate
 * This class creates a Graduate object, which is also a Affiliate and a Student, and then prints it's information.
 * @version 1.0
 */
public class Graduate extends Students {
  /** private member - Int number of published papers they have */
  private int m_numOfPapersPublished;
  /** private member - String for their thesis advisor */
  private String m_thesisAdvisor;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_studentID, m_major, m_minor, m_classStanding with super(), m_numOfPapersPublished to 0 , and m_thesisAdvisor with Stevens. */
  public Graduate() {
    super();
    m_numOfPapersPublished = 0;
    m_thesisAdvisor = "Stevens";
  }

  /**
    * Overloaded constuctor initializing String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_studentID to studentID, String m_major to major, String m_minor to minor, String m_classStanding to classStanding, Int m_numOfPapersPublished to numOfPapersPublished, and String m_thesisAdvisor to thesisAdvisor.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param studentID Long - unique student ID
    * @param major String - their major
    * @param minor String - their minor
    * @param classStanding String - their class standing
    * @param numOfPapersPublished Int - number of published papers bc they are a smart cookie
    * @param thesisAdvisor String - their thesis advisor
    */
  public Graduate(String name, int age, String address, long phoneNum, int yearCameToChapman, long studentID, String major, String minor, String classStanding, int numOfPapersPublished, String thesisAdvisor) {
    super(name, age, address, phoneNum, yearCameToChapman, studentID, major, minor, classStanding);
    m_numOfPapersPublished = numOfPapersPublished;
    m_thesisAdvisor = thesisAdvisor;
  }

  /**
    * Copy constuctor - initializes all attributes of this Graduate to the fields of the passed in Graduate
    * @param copycat the Graduate to copy
    */
  public Graduate(Graduate copycat) {
    super(copycat);
    this.m_numOfPapersPublished = copycat.m_numOfPapersPublished;
    this.m_thesisAdvisor = copycat.m_thesisAdvisor;
  }

  /**
    * Mutator (setter) that sets m_numOfPapersPublished to numOfPapersPublished.
    * @param numOfPapersPublished Int - number of published papers
    */
  public void setNumOfPapersPublished(int numOfPapersPublished) {
    m_numOfPapersPublished = numOfPapersPublished;
  }

  /**
    * Accessor (getter) that returns m_numOfPapersPublished.
    * @return Int m_numOfPapersPublished - number of papers published
    */
  public int getNumOfPapersPublished() {
    return m_numOfPapersPublished;
  }

  /**
    * Mutator (setter) that sets m_thesisAdvisor to thesisAdvisor.
    * @param thesisAdvisor String - their thesis advisor
    */
  public void setThesisAdvisor(String thesisAdvisor) {
    m_thesisAdvisor = thesisAdvisor;
  }

  /**
    * Accessor (getter) that returns m_thesisAdvisor.
    * @return String m_thesisAdvisor - their thesisAdvisor
    */
  public String getThesisAdvisor() {
    return m_thesisAdvisor;
  }

  /**
    * print method - prints all the information of the Graduate
    */
  public void print() {
    super.print();
    System.out.println("," + m_numOfPapersPublished + "," + m_thesisAdvisor);
  }
}
