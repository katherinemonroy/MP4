/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Associate
 * This class makes an Associate object, which is also a Faculty and Affiliates, and then prints it's information.
 * @version 1.0
 */
public class Associate extends Faculty {
  /** private member - Int for the years since they get tenure */
  private int m_yearsSinceTenure;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_facultyID, m_department, m_yearlySalary, m_numOfPapers with super(),
   *  and m_yearsSinceTenure to 0.
   */
  public Associate() {
    super();
    m_yearsSinceTenure = 0;
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Longm_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_facultyID to facultyID, String m_department to department, Int m_yearlySalary to yearlySalary, Int m_numOfPapers to numOfPapers, and Int m_yearsSinceTenure to yearsSinceTenure.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param facultyID Long - unique faculty ID
    * @param department String - department the affiliate worked in
    * @param yearlySalary Int - yearly salary of the affiliate
    * @param numOfPapers Int - number of papers they have bc theyre a genius
    * @param yearsSinceTenure Int - years since they get tenure
    */
  public Associate(String name, int age, String address, long phoneNum, int yearCameToChapman, long facultyID, String department, int yearlySalary, int numOfPapers, int yearsSinceTenure) {
    super(name, age, address, phoneNum, yearCameToChapman, facultyID, department, yearlySalary, numOfPapers);
    m_yearsSinceTenure = yearsSinceTenure;
  }

  /**
    * Copy constuctor - initializes all fields of this Associate to the fields of the passed in Associate
    * @param copycat the Associate to copy
    */
  public Associate(Associate copycat) {
    super(copycat);
    this.m_yearsSinceTenure = copycat.m_yearsSinceTenure;
  }

  /**
    * Mutator (setter) that sets m_yearsSinceTenure to yearsSinceTenure.
    * @param yearsSinceTenure Int - years since they get tenure
    */
  public void setYearsSinceTenure(int yearsSinceTenure) {
    m_yearsSinceTenure = yearsSinceTenure;
  }

  /**
    * Accessor(Getter) that returns m_yearsSinceTenure.
    * @return Int m_yearsSinceTenure - years since they get tenure
    */
  public int getYearsSinceTenure() {
    return m_yearsSinceTenure;
  }

  /**
    * print method - prints all the information of this Associate
    */
  public void print() {
    super.print();
    System.out.println("," + m_yearsSinceTenure);
  }
}
