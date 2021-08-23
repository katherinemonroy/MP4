/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Staff
 * This abstract class contains variables that all Staff have and then prints all it's information.
 * ps... abstract bc you should never create a Staff. thus prevents from having to repeat this code in every other class.
 * @version 1.0
 */
public abstract class Staff extends Affiliates {
  /** private member - Long for their staff ID */
  private long m_staffID;
  /** private member - String for their title */
  private String m_title;
  /** private member - String for their building */
  private String m_building;

  /** Default constructor - initializes m_name, m_age, m_address, m_phoneNum, and m_yearCameToChapman with super(), m_staffID to 0, m_title to Dean, and m_building to Keck. */
  public Staff() {
    super();
    m_staffID = 0;
    m_title = "Dean";
    m_building = "Keck";
  }

  /**
    * Overloaded constuctor - initializes String m_name to name, Int m_age to age, String m_address to address, Long m_phoneNum to phoneNum, Int m_yearCameToChapman to yearCameToChapman,
    * Long m_staffID to staffID, String m_title to title, and String m_building to building.
    * @param name String - name of the affiliate
    * @param age Int - age of the affiliate
    * @param address String - address of the affiliate
    * @param phoneNum Long - phone number of the affiliate
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    * @param staffID Long - their staff ID
    * @param title String - their title
    * @param building String - their building
    */
  public Staff(String name, int age, String address, long phoneNum, int yearCameToChapman, long staffID, String title, String building) {
    super(name, age, address, phoneNum, yearCameToChapman);
    m_staffID = staffID;
    m_title = title;
    m_building = building;
  }

  /**
    * Copy constuctor - initializes all attributes of this Staff to the fields of the passed in Staff
    * @param copycat the Staff to copy
    */
  public Staff(Staff copycat) {
    super(copycat);
    this.m_staffID = copycat.m_staffID;
    this.m_title = copycat.m_title;
    this.m_building = copycat.m_building;
  }

  /**
    * Mutator (settter) that sets m_staffID to staffID.
    * @param staffID Long - their staff ID
    */
  public void setStaffID(long staffID) {
    m_staffID = staffID;
  }

  /**
    * Accessor (getter) Long that returns m_staffID.
    * @return Long m_staffID - their staff ID
    */
  public long getStaffID() {
    return m_staffID;
  }

  /**
    * Mutator (setter) that sets m_title to title.
    * @param title String - their title
    */
  public void setTitle(String title) {
    m_title = title;
  }

  /**
    * Accessor (getter) that returns m_title.
    * @return String m_title - their title
    */
  public String getTitle() {
    return m_title;
  }

  /**
    * Mutator (setter) that sets m_building to building.
    * @param building String - their building
    */
  public void setBuilding(String building) {
    m_building = building;
  }

  /**
    * Accessor (getter) that returns m_building.
    * @return String m_building - their building
    */
  public String getBuilding() {
    return m_building;
  }

  /**
    * print method - prints all the information of the Staff
    */
  public void print() {
    super.print();
    System.out.print("," + m_staffID + "," + m_title + "," + m_building);
  }
}
