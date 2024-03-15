package com.example.SpringFrameWorkXmlBasedConfiguration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanConfigurationViaXMLFile {

	/*
	 * This is first look into spring Framework
	 * 
	 * In this file we will go though basic idea of IoC ( Inversion of Control ) and
	 * DI (Dependancy Injection).
	 * 
	 * IOC -> Inversion of Control.
	 * 
	 * In traditional way of programming object creation is done by programmer and
	 * that is given to the run-time environment like JVM.
	 * 
	 * i.e In traditional way caller will determine the flow or execution of
	 * object's life cycle
	 * 
	 * But in IoC object required to execute the sequence is given by another
	 * external entity called ApplicationContext. That will manage the life cycle of
	 * the object.
	 * 
	 * In enterprise level application object life cycle is very hard to manage so,
	 * this job will be delegated to external application context that will give the
	 * object to runtime environment like JVM.
	 * 
	 * This can be achived is 2 ways.
	 * 
	 * 1. Dependency Injection (DI): In DI, the framework or container injects
	 * dependencies (i.e., objects or resources) into a component rather than the
	 * component itself creating or looking up its dependencies. This allows the
	 * components to be more reusable and easier to test, as they are not tightly
	 * coupled to their dependencies.
	 * 
	 * 2. Event-driven Programming: In event-driven programming, the flow of control
	 * is determined by events that are triggered by user actions, system events, or
	 * other external stimuli. Components register event handlers with the framework
	 * or container, and the framework invokes these handlers when the corresponding
	 * events occur. This allows for more flexible and loosely coupled
	 * architectures, as components can interact indirectly through events rather
	 * than directly calling each other's methods.
	 * 
	 * Here in this example we will be injecting Data-source that is used to execute
	 * the Data-base related queries in the application. Same Data source can be
	 * used accross the application and life cycle of that can be managed by spring.
	 * 
	 * As a first step bean will be configured through XML based file and that XML
	 * file will be in ClassPath(Path in which JVM will look for executables)
	 * 
	 * USE - CASE
	 * 
	 * Salary of employee should be calculated and same should be update to DB.
	 * Assume employeeId and basic salary will be given to compute the tax
	 * calculation.
	 * 
	 * EmployeeSalaryDaoImpl will be bean responsible for updating the Salary This
	 * requires Jdbc-Template that inturns requires Data-source object(Composed of
	 * data base URL,username,password etc).
	 * 
	 * In this example we will see both constructor injection as well as setter injection.
	 * 
	 * Lets, begin.
	 */
	
	public static void main(String args[]) {
		// Arrange Mock Data as if we are getting from User.
		long empId = 1L;
		long empGrossSalary = 10000;
		
		//Get the application context.
		var applicationContext = new ClassPathXmlApplicationContext("configurationBean.xml");
		EmployeeSalaryService employeeSalaryService = (EmployeeSalaryServiceImpl) applicationContext.getBean("empSalaryService");
		employeeSalaryService.computeSalary(empGrossSalary,empId);
	}
}
