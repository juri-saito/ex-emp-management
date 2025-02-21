package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員関連機能の処理の制御を行うコントローラ.
 * @author juri.saito
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 従業員一覧を出力する.
	 * @param model リクエストスコープ
	 * @return 従業員一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> List = employeeService.showList();
		model.addAttribute("employeeList", List);
		
		return "employee/list.html";
	}
	
	/**
	 * 従業員情報更新時に使用するフォームオブジェクトをModelオブジェクト(リクエストスコープ)に格納.
	 * @return　従業員情報更新時に使用するフォームオブジェクト
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpdateEmployeeForm() {
		UpdateEmployeeForm employeeForm = new UpdateEmployeeForm();
		return employeeForm;
	}

	/**
	 * リクエストスコープに従業員情報を格納して従業員詳細画面へフォワード.
	 * @param id 従業員ID
	 * @param model　リクエストスコープ
	 * @return　従業員詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail.html";
	}
}
