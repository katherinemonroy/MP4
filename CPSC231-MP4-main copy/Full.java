/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Full
 * This class makes a Full object, which is also a Faculty and Affiliates, and tben prints it's information.
 * @version 1.0
 */
public class Full extends Faculty {
  /** private member - Int years left until they retire */
  private int m_yearsUntilRetirement;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_facultyID, m_department, m_yearlySalary, m_numOfPapers with super(),
   *  and m_yearsUntilRetirement to 1.
   */
  public Full() {
    super();
    m_yearsUntilRetirement = 1;
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_facultyID to facultyID, String m_department to department, Int m_yearlySalary to yearlySalary, Int m_numOfPapers to numOfPapers, and Int m_yearsUntilRetirement to yearsUntilRetirement.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param facultyID Long - unique faculty ID
    * @param department String - department they work in
    * @param yearlySalary Int - yearly salary of the affiliate
    * @param numOfPapers Int - number of papers they have bc they are a genius
    * @param yearsUntilRetirement Int - years until the affiliate retire
    */
  public Full(String name, int age, String address, long phoneNum, int yearCameToChapman, long facultyID, String department, int yearlySalary, int numOfPapers, int yearsUntilRetirement) {
    super(name, age, address, phoneNum, yearCameToChapman, facultyID, department, yearlySalary, numOfPapers);
    m_yearsUntilRetirement = yearsUntilRetirement;
  }

  /**
    * Copy constuctor - initializes all attributes of this Full to the fields of the passed in Full
    * @param copycat the Full to copy
    */
  public Full(Full copycat) {
    super(copycat);
    this.m_yearsUntilRetirement = copycat.m_yearsUntilRetirement;
  }

  /**
    * Mutator (setter) that sets m_yearsUntilRetirement to yearsUntilRetirement.
    * @param yearsUntilRetirement Int - years until they retire
    */
  public void setYearsUntilRetirement(int yearsUntilRetirement) {
    m_yearsUntilRetirement = yearsUntilRetirement;
  }

  /**
    * Accessor (getter) that returns m_yearsUntilRetirement.
    * @return Int m_yearsUntilRetirement - years until they retire
    */
  public int getYearsUntilRetirement() {
    return m_yearsUntilRetirement;
  }

  /**
    * print method - that prints all the information of this Full
    */
  public void print() {
    super.print();
    System.out.println("," + m_yearsUntilRetirement);
  }
}
