package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class TestController {
	
	@Autowired
	DeptDAO deptDAO;

	public TestController() {
		System.out.println("---TestController의 생성자---");
	}
	
	@RequestMapping(value= {"/","dept_list"})
	public String dept_list(Model model) {
		List<DeptVO> list = deptDAO.selectList();
		model.addAttribute("list",list);
		return "/WEB-INF/views/dept_list.jsp";
	}
}
