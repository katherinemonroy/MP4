/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4  - Affiliates
 * This class creates a FullTime object, which is also an Affiliates and Staff, and then prints all it's information.
 * @version 1.0
 */
public class FullTime extends Staff {
  /** private member - Double for yearly salary */
  private double m_yearlySalary;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_staffID, m_title, m_building with super(), and yearlySalary to 100000 */
  public FullTime() {
    super();
    m_yearlySalary = 100000;
  }

  /**
    * Overloaded constuctor - initializing String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_staffID to staffID, String m_title to title, String m_building to building, and Double m_yearlySalary to yearlySalary.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param staffID Long - unique staff ID
    * @param title String - their title
    * @param building String - building
    * @param yearlySalary double - their yearly salary
    */
  public FullTime(String name, int age, String address, long phoneNum, int yearCameToChapman, long staffID, String title, String building, double yearlySalary) {
    super(name, age, address, phoneNum, yearCameToChapman, staffID, title, building);
    m_yearlySalary = yearlySalary;
  }

  /**
    * Copy constuctor - initializes all attributes of this FullTime to the fields of the passed in FullTime
    * @param copycat the FullTime to copy
    */
  public FullTime(FullTime copycat) {
    super(copycat);
    this.m_yearlySalary = copycat.m_yearlySalary;
  }

  /**
    * Mutator (setter) that sets m_yearlySalary to yearlySalary.
    * @param yearlySalary Double - their yearly salary
    */
  public void setYearlySalary(double yearlySalary) {
    m_yearlySalary = yearlySalary;
  }

  /**
    * Accessor (getter) that returns m_yearlySalary.
    * @return double m_yearlySalary - their yearly salary
    */
  public double getYearlySalary() {
    return m_yearlySalary;
  }

  /**
    * print method - prints all the information of this FullTime
    */
  public void print() {
    super.print();
    System.out.println("," + m_yearlySalary);
  }
}
