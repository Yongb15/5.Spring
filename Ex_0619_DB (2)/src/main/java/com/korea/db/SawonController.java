package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SawonDAO;
import lombok.RequiredArgsConstructor;
import util.MyPath.HomeClass;
import vo.SawonVO;

@Controller
@RequiredArgsConstructor
public class SawonController {

	final SawonDAO sawonDAO;
	
	@RequestMapping("sawon_list")
	public String sawon_list(Model model) {
		List<SawonVO> list = sawonDAO.selectList();
		model.addAttribute("list",list);
		return HomeClass.VIEW_PATH+"sawon_list.jsp";
	}
	
	
	
	
	
	
}
