package com.korea.visit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value= {"/","visit_list"})
	public String visit_list(Model model) {
		List<VisitVO> list = visitDAO.selectList();
		model.addAttribute("list",list);
		return HomeClass.VIEW_PATH+"visit_list.jsp";
	}
	
	@RequestMapping("insert_form")
	public String insert_form() {
		return HomeClass.VIEW_PATH+"insert_form.jsp";
	}
	
	@RequestMapping("insert")
	public String insert(VisitVO vo) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		int res = visitDAO.insert(vo);
		
		if(res > 0) {
			return "redirect:visit_list";
		}
		return null;	
	}
}






