/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Staff
 * The purpose of this class is to create a Staff object, which is also an Affiliates and Staff, and print all it's info.
 * @version 1.0
 */
public class PartTime extends Staff {
  /** private member - double for their hourly salary */
  private double m_hourlySalary;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman, m_staffID, m_title, m_building with super(), and hourlySalary with 14.0 which im pretty sure is minimum wage */
  public PartTime() {
    super();
    m_hourlySalary = 14.0;
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_staffID to staffID, String m_title to title, String m_building to building, and Double m_hourlySalary to hourlySalary.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param staffID Long - unique staff ID
    * @param title String - their title
    * @param building String - their building
    * @param hourlySalary Double - their hourly salary
    */
  public PartTime(String name, int age, String address, long phoneNum, int yearCameToChapman, long staffID, String title, String building, double hourlySalary) {
    super(name, age, address, phoneNum, yearCameToChapman, staffID, title, building);
    m_hourlySalary = hourlySalary;
  }

  /**
    * Copy constuctor - initializes all attributes of this PartTime to the fields of the passed in PartTime
    * @param copycat the PartTime to copy
    */
  public PartTime(PartTime copycat) {
    super(copycat);
    this.m_hourlySalary = copycat.m_hourlySalary;
  }

  /**
    * Mutator (setter) that sets m_hourlySalary to hourlySalary.
    * @param hourlySalary double - their hourly salary
    */
  public void setHourlySalary(double hourlySalary) {
    m_hourlySalary = hourlySalary;
  }

  /**
    * Accessor (getter) that returns m_hourlySalary.
    * @return double m_hourlySalary - their hourly salary
    */
  public double getHourlySalary() {
    return m_hourlySalary;
  }

  /**
    * print method - prints all the information of this PartTime
    */
  public void print() {
    super.print();
    System.out.println("," + m_hourlySalary);
  }
}
