package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GogekDAO;
import lombok.RequiredArgsConstructor;
import util.MyPath.HomeClass;
import vo.GogekVO;

@Controller
@RequiredArgsConstructor
public class GogekController {

	final GogekDAO gogekDAO;
	
	@RequestMapping("gogek_list")
	public String gogek_list(Model model) {
		List<GogekVO> list = gogekDAO.selectList();
		model.addAttribute("list",list);
		
		return HomeClass.VIEW_PATH+"gogek_list.jsp";
	}
	
	
	
	
	
	
	
	
}
