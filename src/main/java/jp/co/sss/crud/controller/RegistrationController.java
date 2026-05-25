package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class RegistrationController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HttpSession session;

    /** 入力画面表示 */
    @GetMapping("/regist/input")
    public String input(@ModelAttribute EmployeeForm employeeForm, Model model) {

        // セッションチェック（ログインしていない場合はトップへ）
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        return "regist/regist_input";
    }

    /** 確認画面へ */
    @PostMapping("/regist/check")
    public String check(@Valid @ModelAttribute EmployeeForm employeeForm,
                        BindingResult result,
                        Model model) {

        // バリデーションエラーがあれば入力画面へ戻す
        if (result.hasErrors()) {
            return "regist/regist_input";
        }

        return "regist/regist_check";
    }

    /** 完了画面（DB登録） */
    @PostMapping("/regist/complete")
    public String complete(@ModelAttribute EmployeeForm employeeForm) {

        // Employee エンティティへ詰め替え
        Employee employee = new Employee();
        employee.setEmpPass(employeeForm.getEmpPass());
        employee.setEmpName(employeeForm.getEmpName());
        employee.setGender(employeeForm.getGender());
        employee.setAddress(employeeForm.getAddress());
        employee.setBirthday(employeeForm.getBirthday());
        employee.setAuthority(employeeForm.getAuthority());
 
        // 部署（Department）をセット
        Department dept = new Department();
        dept.setDeptId(employeeForm.getDeptId());
        employee.setDepartment(dept);

        // DB登録
        employeeRepository.save(employee);

        return "regist/regist_complete";
    }
}
