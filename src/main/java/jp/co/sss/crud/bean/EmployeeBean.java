package jp.co.sss.crud.bean;

import jakarta.persistence.Column;

public class EmployeeBean {

    private Integer empId;
    
    @Column(name = "EMP_NAME")
    private String empName;
    private Integer authority;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}
