package erp.service;

import java.util.List;

import erp.dao.DepartmentDao;
import erp.dao.EmployeeDao;
import erp.dao.impl.DepartmentDaoImpl;
import erp.dao.impl.EmployeeDaoImpl;
import erp.dto.Department;
import erp.dto.Employee;

public class DepartmentService {
	private DepartmentDao dao = DepartmentDaoImpl.getInstance();
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();

	public List<Department> showTitles() {
		return dao.selectDepartmentByAll();
	}

	public void addDept(Department department) {
		dao.insertDepartment(department);
	}

	public void removeDept(Department department) {
		dao.deleteDepartment(department.getDeptNo());
	}

	public void modifyDept(Department department) {
		dao.updateDepartment(department);
	}
	
	public List<Employee> showEmployeeGroupByDept(Department department){
		return empDao.selectEmployeeByDept(department);
	}
}
