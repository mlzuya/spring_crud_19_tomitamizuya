package jp.co.sss.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmpIdAndEmpPass(int empId, String empPass);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department ORDER BY e.empId")
    List<Employee> findAllWithDepartment();
    
    @Query("SELECT e FROM Employee e JOIN FETCH e.department WHERE empName LIKE '田中'")
    List<Employee> findByempNameLike();
    
}
