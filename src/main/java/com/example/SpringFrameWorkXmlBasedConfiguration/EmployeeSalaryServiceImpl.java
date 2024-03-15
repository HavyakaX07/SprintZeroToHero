package com.example.SpringFrameWorkXmlBasedConfiguration;

public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

	private EmployeeSalaryDao empSalaryDao;
	
	//Setter injection happens if setter is commented then wont work.
	public void setEmpSalaryDao(EmployeeSalaryDao empSalaryDao) {
		this.empSalaryDao = empSalaryDao;
	}

	@Override
	public void computeSalary(long grossSalary,long empId) {
		// Compute intesive calucaltion depending on business logic and update the salary in the DB.
		//This is only example
		long netSalary = grossSalary - 100;
		empSalaryDao.updateSalary(netSalary, empId);

	}

}
