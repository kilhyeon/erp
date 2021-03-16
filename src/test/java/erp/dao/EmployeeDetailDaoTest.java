package erp.dao;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp.dao.impl.EmployeeDetailDaoImpl;
import erp.dto.Department;
import erp.dto.Employee;
import erp.dto.EmployeeDetail;
import erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDetailDaoTest {

	private static EmployeeDetailDao dao = EmployeeDetailDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test02SelectEmployeeDetailByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeDetailByNo");

		EmployeeDetail employeeDetail = dao.selectEmployeeDetailByNo(new Employee(1003));

		Assert.assertNotNull(employeeDetail);
	}

	@Test
	public void test01InsertEmployeeDetail() {
		System.out.printf("%s()%n", "testInsertEmployeeDetail");

		EmployeeDetail empDetail = new EmployeeDetail(1003, true, new Date(), "1234", getImage("noimage.jpg"));
		int res = dao.insertEmployeeDetail(empDetail);

		Assert.assertEquals(1, res);
	}

	private byte[] getImage(String imgName) {
		byte[] pic = null;

		File file = new File(System.getProperty("user.dir") + File.separator + "images", imgName);
		try (InputStream is = new FileInputStream(file)) {
			pic = new byte[is.available()];
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pic;
	}

	@Test
	public void test03UpdateEmployeeDetail() {
		System.out.printf("%s()%n", "testUpdateEmployeeDetail");
		EmployeeDetail empDetail = new EmployeeDetail(1003, false, new Date(), "4321", getImage("2.jpg"));
		int res = dao.updateEmployeeDetail(empDetail);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04DeleteEmployeeDetail() {
		System.out.printf("%s()%n", "testDeleteEmployeeDetail");
		Employee employee = new Employee(1003);
		int res = dao.deleteEmployeeDetail(employee);
		Assert.assertEquals(1, res);
	}

}
