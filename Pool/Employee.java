package Pool;

public class Employee implements Poolable {

	int empId;
	String empName = "";

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpname() {
		return this.empName;
	}

	public void setEmpname(String empName1) {
		this.empName = empName1;
	}

	void processEmployee() {
		String tempName = "";
		tempName = this.getEmpname() + "-Processed";
		this.setEmpname(tempName);
	}

	@Override
	public void returnThisObjectIntoPool() {
		EmployeePool.getMyInstance().returnThisObjectIntoPool(this); 
		
	}

	
	
}
