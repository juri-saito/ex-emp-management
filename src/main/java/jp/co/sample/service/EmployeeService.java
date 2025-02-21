package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員関連機能の業務処理を行うクラス.
 * @author juri.saito
 *
 */
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * 従業員情報を全件取得する.
	 * @return 従業員情報全件リスト
	 */
	public List<Employee> showList(){
		return employeeRepository.findAll();
	}
	
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
		
	}
}