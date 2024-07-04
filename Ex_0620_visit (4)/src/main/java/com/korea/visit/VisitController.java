package com.korea.visit;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int idx, String pwd) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("idx",idx);
		map.put("pwd", pwd);
		int res = visitDAO.delete(map); 
		
		if(res == 1) {
			return "{\"res\":\"yes\"}";
		} else {
			return "{\"res\":\"no\"}";
		}
	}
	
	@RequestMapping("modify_form")
	public String modify_form(Model model, int idx) {
		//게시글 한건 조회하기
		VisitVO vo = visitDAO.selectOne(idx);
		model.addAttribute("vo",vo);
		return HomeClass.VIEW_PATH+"modify_form.jsp";
	}
	
	@RequestMapping("modify")
	public String modify(VisitVO vo) {
		System.out.println(vo.getIdx());
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		int res = visitDAO.update(vo);
		
		return "redirect:visit_list";
	}
}






