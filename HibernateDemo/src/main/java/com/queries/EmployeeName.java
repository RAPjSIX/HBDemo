
package com.queries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Empl")
@NamedQueries({ @NamedQuery(name = "Emplo", query = "from EmployeeName e where e.empName=:name") })
public class EmployeeName {
	@Id
	private int empId;
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmployeeName [empId=" + empId + ", empName=" + empName + "]";
	}

}
