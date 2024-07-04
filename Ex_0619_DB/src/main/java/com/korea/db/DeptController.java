package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import lombok.RequiredArgsConstructor;
import util.MyPath.HomeClass;
import vo.DeptVO;

@Controller
@RequiredArgsConstructor
public class DeptController {

	final DeptDAO deptDAO;
	
	@RequestMapping("dept_list")
	public String dept_list(Model model) {
		List<DeptVO> list = deptDAO.selectList();
		model.addAttribute("list",list);
		return HomeClass.VIEW_PATH+"dept_list.jsp";
	}
	
	
	
	
	
	
	
}
