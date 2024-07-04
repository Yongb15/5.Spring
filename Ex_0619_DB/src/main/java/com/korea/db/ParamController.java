package com.korea.db;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MyPath.HomeClass;
import vo.PersonVO;

@Controller
public class ParamController {

	@RequestMapping(value= {"/","/insert_form"})
	public String insert_form() {
		return HomeClass.VIEW_PATH+"insert_form.jsp";
	}
	
	@RequestMapping("insert1")
	public String result(String name, int age, Model model) {
		PersonVO vo = new PersonVO();
		
		vo.setName(name);
		vo.setAge(age);
		model.addAttribute("vo",vo);
		return HomeClass.VIEW_PATH+"insert_result.jsp";
	}
	
	
	@RequestMapping("insert2")
	public String result2(@ModelAttribute("vo") PersonVO vo) {
		return HomeClass.VIEW_PATH+"insert_result.jsp";
	}
	
	
	
	
	
	
}
