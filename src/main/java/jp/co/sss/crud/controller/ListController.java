package jp.co.sss.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class ListController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/list")
    public String list(Model model) {

        // セッションチェック
        EmployeeBean user = (EmployeeBean) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        // 社員一覧取得（部署名付き）
        List<Employee> employeeList = employeeRepository.findAllWithDepartment();

        model.addAttribute("employeeList", employeeList);

        return "list/list";
    }
    
    @GetMapping("/list/{name}")
    public String nameList(Model model) {
        List<Employee> employeeNameList = employeeRepository.findByempNameLike();

        model.addAttribute("employeeNameList", employeeNameList);

        return "list/list";
    
    }
}
