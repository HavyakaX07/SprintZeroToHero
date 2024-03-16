package SpringFrameworkAnnotationBasedConfiguration;

public class EmployeeSalaryUpdateServiceImpl implements EmployeeSalaryUpdateService {

	private EmployeeSalaryUpdateDao employeeSalaryUpdateDao;
	
	public EmployeeSalaryUpdateServiceImpl(EmployeeSalaryUpdateDao employeeSalaryUpdateDao2) {
		employeeSalaryUpdateDao = employeeSalaryUpdateDao2;
	}


	public void setEmployeeSalaryUpdateDao(EmployeeSalaryUpdateDao employeeSalaryUpdateDao) {
		this.employeeSalaryUpdateDao = employeeSalaryUpdateDao;
	}
	
	
	@Override
	public void computeSalary(long grossSalary, long empId) {
		//Lets assume some intensive computation is calculated here.
		//after that update the calculated info into db.
		System.out.println("Calculating salary");
		long netSalary = grossSalary-100;
		employeeSalaryUpdateDao.updateSalary(netSalary , empId);

	}


}
