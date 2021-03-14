package erp.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp.dao.impl.EmployeeDaoImpl;
import erp.dto.Department;
import erp.dto.Employee;
import erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {

	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> employeeList = dao.selectEmployeeByAll();
		Assert.assertNotNull(employeeList);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}

	@Test
	public void test05SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee employee = new Employee(2106);
		Employee searchEmployee = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(searchEmployee);
		System.out.println(searchEmployee);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Employee newEmployee = new Employee(1004, "천사", new Title(5), new Employee(4377), 2000000, new Department(1));
		int res = dao.insertEmployee(newEmployee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmployee));
	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee newEmployee = new Employee(1004, "천사", new Title(2), new Employee(4377), 2500000, new Department(2));
		int res = dao.updateEmployee(newEmployee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmployee));
	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee");
		int res = dao.deleteEmployee(1004);
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test06selectEmployeeByTitle() {
		System.out.printf("%s()%n", "testSelectEmployeeByTitle");

		List<Employee> empList = dao.selectEmployeeByTitle(new Title(3));
		Assert.assertNotNull(empList);

		empList.stream().forEach(System.out::println);
	}
	
	@Test
	public void test07selectEmployeeByDepartment() {
		System.out.printf("%s()%n", "testSelectEmployeeByDepartment");

		List<Employee> empList = dao.selectEmployeeByDepartment(new Department(1));
		Assert.assertNotNull(empList);

		empList.stream().forEach(System.out::println);
	}

}
