package jp.co.sss.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    private Integer dept_id;

    @Column
    private String dept_name;

    // --- getter/setter ---

    public Integer getDeptId() { return dept_id; }
    public void setDeptId(Integer deptId) { this.dept_id = deptId; }

    public String getDeptName() { return dept_name; }
    public void setDeptName(String deptName) { this.dept_name = deptName; }
}
