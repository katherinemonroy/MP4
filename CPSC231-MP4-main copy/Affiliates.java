/**
DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * Programming Mastery Project 4 - Affiliates
 * This is an abstract class that contains private variables that all affiliates have
 * Also, compares two Affiliates to see who came to Chapman first, and print all their information
 * ps... it's an abstract bc you should never create an affiliate. so this just prevents from having to repeat this code in every other class.
 * @version 1.0
 */
public abstract class Affiliates implements Comparable<Affiliates>, Printable {
  /** private member - String for the name of the affiliate */
  private String m_name;
  /** private member -  Int for the age of the affiliate */
  private int m_age;
  /** private member - String for the address of the affiliate */
  private String m_address;
  /** private member - Long for the phone number of the affiliate */
  private long m_phoneNum;
  /** private member - Int for the year that the affiliate came/was accepted into Chapman University */
  private int m_yearCameToChapman;

  /** Default constructor - initializes the member variables m_name to affiliate, m_age to 18 ~caus that felt like a good default~ , m_address to 1 University Dr, Orange, m_phoneNum to 9976815 ~chapmans phone#~, and m_yearCameToChapman to 2000 */
  public Affiliates() {
    m_name = "Affiliate";
    m_age = 18;
    m_address = "1 University Dr, Orange";
    m_phoneNum = 9976815;
    m_yearCameToChapman = 2000;
  }

  /**
    * Overloaded constuctor that takes in parameters: m_name and sets to name, m_age and sets to age, m_address and sets to address, m_phoneNum and sets to phoneNum, and m_yearCameToChapman and sets to yearCameToChapman
    * @param name String - for the name of the affiliate
    * @param age Int - for the age of the affiliate
    * @param address String - for the address of the affiliate
    * @param phoneNum Long - for the phone number of the affiliate
    * @param yearCameToChapman Int - for the year the affiliate came/was addmited to Chapman University
    */
  public Affiliates(String name, int age, String address, long phoneNum, int yearCameToChapman) {
    m_name = name;
    m_age = age;
    m_address = address;
    m_phoneNum = phoneNum;
    m_yearCameToChapman = yearCameToChapman;
  }

  /**
    * Copy constuctor - initilizes all fields of this Affiliates to the fields of the passed in Affiliates
    * @param other the Affiliates to copy
    */
  public Affiliates(Affiliates other) {
    this.m_name = other.m_name;
    this.m_age = other.m_age;
    this.m_address = other.m_address;
    this.m_phoneNum = other.m_phoneNum;
    this.m_yearCameToChapman = other.m_yearCameToChapman;
  }

  /**
    * Mutator (Setter) that sets m_name to name.
    * @param name String - name of the affiliate
    */
  public void setName(String name) {
    m_name = name;
  }

  /**
    * Accessor (getter) that returns m_name.
    * @return String m_name - the name of the affiliate
    */
  public String getName() {
    return m_name;
  }

  /**
    * Mutator (Setter) that sets m_age to age.
    * @param age Int - age of the affiliate
    */
  public void setAge(int age) {
    m_age = age;
  }

  /**
    * Accessor (Getter) that returns m_age.
    * @return Int m_age - age of the affiliate
    */
  public int getAge() {
    return m_age;
  }

  /**
    * Mutator (Setter) that sets m_address to address.
    * @param address String -  address of the affiliate
    */
  public void setAddress(String address) {
    m_address = address;
  }

  /**
    * Accessor (Getter) that returns m_address.
    * @return Int m_address - address of the affiliate
    */
  public String getAddress() {
    return m_address;
  }

  /**
    * Mutator (Setter) that sets m_phoneNum to phoneNum.
    * @param phoneNum Long - phone number of the affiliate
    */
  public void setPhoneNum(long phoneNum) {
    m_phoneNum = phoneNum;
  }

  /**
    * Accessor (Getter) that returns m_phoneNum.
    * @return Long m_phoneNum - phone number of the affiliate
    */
  public long getPhoneNum() {
    return m_phoneNum;
  }

  /**
    * Mutator (Setter) that sets m_yearCameToChapman to yearCameToChapman.
    * @param yearCameToChapman Int - year the affiliate came to Chapman
    */
  public void setYearCameToChapman(int yearCameToChapman) {
    m_yearCameToChapman = yearCameToChapman;
  }

  /**
    * Accessor (Getter) that returns m_yearCameToChapman.
    * @return Int m_yearCameToChapman - year the affiliate came to Chapman
    */
  public int getYearCameToChapman() {
    return m_yearCameToChapman;
  }

  /**
    * CompareTo method - Compares the m_yearCameToChapman of two Affiliates.
    * @return Int value - 0 for when both affiliates came to chapman the same year, 1 if the passed Affiliates came before this one, -1 otherwise.
    */
  public int compareTo(Affiliates other) {
    if(this.m_yearCameToChapman == other.m_yearCameToChapman){
      return 0;
    }
    else if (this.m_yearCameToChapman > other.m_yearCameToChapman) {
      return 1;
    }
    else {
      return -1;
    }
  }

  /**
    * print method - prints all the information of an Affiliate
    */
  public void print() {
    System.out.print(m_name + "," + m_age + "," + m_address + "," + m_phoneNum + "," + m_yearCameToChapman);
  }
}
