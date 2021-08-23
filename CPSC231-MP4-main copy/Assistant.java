/**
  DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Assistant
 * This class makes an Assistant object, which is also a Faculty and Affiliate.
 * @version 1.0
 */

public class Assistant extends Faculty {
  /** private member - Int for the years left til they get tenure */
  private int m_yearsUntilTenure;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_facultyID, m_department, m_yearlySalary, m_numOfPapers by using super()
   *  and then m_yearsUntilTenure to 1.
   */
  public Assistant() {
    super();
    m_yearsUntilTenure = 1;
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_facultyID to facultyID, String m_department to department, Int m_yearlySalary to yearlySalary, Int m_numOfPapers to numOfPapers, and Int m_yearsUntilTenure to yearsUntilTenure.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param facultyID Long - unique faculty ID
    * @param department String - department the affiliate works in
    * @param yearlySalary Int - yearly salary of the affiliate
    * @param numOfPapers Int - number of papers the affiliate has published caus they're a genius
    * @param yearsUntilTenure Int - years left until they get tenure
    */
  public Assistant(String name, int age, String address, long phoneNum, int yearCameToChapman, long facultyID, String department, int yearlySalary, int numOfPapers, int yearsUntilTenure) {
    super(name, age, address, phoneNum, yearCameToChapman, facultyID, department, yearlySalary, numOfPapers);
    m_yearsUntilTenure = yearsUntilTenure;
  }

  /**
    * Copy constuctor - initializes all member attributes of this Assistant to the fields of the passed in Assistant
    * @param copycat the Assistant to copy
    */
  public Assistant(Assistant copycat) {
    super(copycat);
    this.m_yearsUntilTenure = copycat.m_yearsUntilTenure;
  }

  /**
    * Mutator (Setter) that sets m_yearsUntilTenure to yearsUntilTenure.
    * @param yearsUntilTenure Int - years until they get tenure
    */
  public void setYearsUntilTenure(int yearsUntilTenure) {
    m_yearsUntilTenure = yearsUntilTenure;
  }

  /**
    * Accessor (Getter) that returns m_yearsUntilTenure.
    * @return Int m_yearsUntilTenure - years left until they get tenure
    */
  public int getYearsUntilTenure() {
    return m_yearsUntilTenure;
  }

  /**
    * print method -  prints all the information of the Assistant
    */
  public void print() {
    super.print();
    System.out.println("," + m_yearsUntilTenure);
  }
}
