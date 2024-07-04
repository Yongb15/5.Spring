package com.korea.visit;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import lombok.RequiredArgsConstructor;
import util.MyPath.HomeClass;
import vo.VisitVO;

@Controller
@RequiredArgsConstructor
public class VisitController {

	final VisitDAO visitDAO;
	
	@RequestMapping(value= {"/","visit_list"})
	public String visit_list(Model model) {
		List<VisitVO> list = visitDAO.selectList();
		model.addAttribute("list",list);
		return HomeClass.VIEW_PATH+"visit_list.jsp";
	}
}






