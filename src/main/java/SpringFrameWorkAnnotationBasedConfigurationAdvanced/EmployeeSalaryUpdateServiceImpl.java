package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSalaryUpdateServiceImpl implements EmployeeSalaryUpdateService {

	private EmployeeSalaryUpdateDao employeeSalaryUpdateDao;

	//Now we have 2 implemented class of this EmployeeSalaryUpdateDao
	//So, Which one to inject. Spring will throw specific bean not found exception.
	//So by default pgadmin bean will be injected.
	//If you want to inject mongoDb then use @Qualifier.
	@Autowired
	//@Qualifier("mongoDb")
	public void setEmployeeSalaryUpdateDao(EmployeeSalaryUpdateDao employeeSalaryUpdateDao) {
		this.employeeSalaryUpdateDao = employeeSalaryUpdateDao;
	}

	@Override
	public void computeSalary(long salary, long empId) {
		employeeSalaryUpdateDao.updateSalary(salary, empId);

	}

}
