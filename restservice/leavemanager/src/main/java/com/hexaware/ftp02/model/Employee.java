package com.hexaware.ftp02.model;

import com.hexaware.ftp02.persistence.DbConnection;
import com.hexaware.ftp02.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee name.
   * empPhone to store employee phone number.
   * empEmail to store employee mail address.
   * empDept to store employee department name.
   * empJoinDate to store employee joining date.
   * empMgrId to store manager Id.
   * empLeaveBal to store employee leave balance.
   */
  private int empId;
  private String empName;
  private long empPhone;
  private String empEmail;
  private String empDept;
  private String empJoinDate;
  private int empMgrId;
  private int empLeaveBal;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpPhone to initialize employee phone.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpDept to initialize employee department.
   * @param argEmpJoinDate to initialize employee joining date.
   * @param argEmpMgrId to initialize manager id.
   * @param argEmpLeaveBal to initialize leave balance.
   */
  public Employee(final int argEmpId, final String argEmpName, final long argEmpPhone,
                 final String argEmpEmail, final String argEmpDept, final String argEmpJoinDate,
                 final int argEmpMgrId, final int argEmpLeaveBal) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empPhone = argEmpPhone;
    this.empEmail = argEmpEmail;
    this.empDept = argEmpDept;
    this.empJoinDate = argEmpJoinDate;
    this.empMgrId = argEmpMgrId;
    this.empLeaveBal = argEmpLeaveBal;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone Number.
   */
  public final long getEmpPhone() {
    return empPhone;
  }

  /**
   *
   * @param argEmpPhone to set employee phone number.
   */
  public final void setEmpPhone(final long argEmpPhone) {
    this.empPhone = argEmpPhone;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's email ID.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee email number.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   * Gets the EmployeeDepartment.
   * @return this Employee's department name.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @param argEmpDept to set employee department name.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   * Gets the EmployeeJoinDate.
   * @return this Employee's joining date.
   */
  public final String getEmpJoinDate() {
    return empJoinDate;
  }

  /**
   *
   * @param argEmpJoinDate to set employee joining date.
   */
  public final void setEmpJoinDate(final String argEmpJoinDate) {
    this.empJoinDate = argEmpJoinDate;
  }

  /**
   * Gets the ManagerID.
   * @return this ManagerID.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set ManagerID.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

   /**
   * Gets the Employee leave balance.
   * @return this Employee leave balance.
   */
  public final int getEmpLeaveBal() {
    return empLeaveBal;
  }

  /**
   *
   * @param argEmpLeaveBal to set employee leave balance.
   */
  public final void setEmpLeaveBal(final int argEmpLeaveBal) {
    this.empLeaveBal = argEmpLeaveBal;
  }
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

}
