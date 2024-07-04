package com.korea.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BoardDAO;
import dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import util.Common.Board;
import util.Common.Member;
import util.Paging;
import vo.BoardVO;
import vo.MemberVO;

@Controller
@RequiredArgsConstructor
public class BoardController {

	final BoardDAO boardDAO;
	final MemberDAO memberDAO;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value= {"/","board_list"})
	public String list(Model model, @RequestParam(required=false, defaultValue="1")String page) {
		
		int nowPage = 1;
		nowPage = Integer.parseInt(page);
		
		int start = (nowPage -1) * Board.BLOCKLIST+1;
		int end = start + Board.BLOCKLIST-1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//전체 게시물 수 조회
		int rowTotal = boardDAO.getRowTotal();
		
		//페이지 번호에 따른 전체 게시글 조회
		List<BoardVO> list = boardDAO.selectList(map);
		
		//페이지 메뉴 모양 생성하기
		String pageMenu = Paging.getPaging("board_list",
											nowPage,
											rowTotal,
											Board.BLOCKLIST,
											Board.BLOCKPAGE);
		
		session.removeAttribute("show");
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return Board.VIEW_PATH+"board_list.jsp?page="+nowPage;
	}
	
	@RequestMapping("view")
	public String view(Model model, int idx, @RequestParam(required=false, defaultValue="1")int page) {
		BoardVO vo = boardDAO.selectOne(idx);
		
		//조회수 증가
		//단, 새로고침을 마구 눌러도 증가되지 않도록 만들기
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			boardDAO.update_readhit(idx);
			session.setAttribute("show", "1");
		}
		
		
		
		model.addAttribute("vo",vo);
		return Board.VIEW_PATH+"board_view.jsp?page="+page;
	}
	
	@RequestMapping("insert_form")
	public String insert_form() {
		MemberVO vo = (MemberVO)session.getAttribute("id");
		//로그인이 되어있다면 글쓰기 페이지로 이동
		//로그인이 되어있지 않다면 로그인페이지로 이동
		if(vo == null) {
			return Member.VIEW_PATH+"login_form.jsp";
		}
		return Board.VIEW_PATH+"insert_form.jsp";
	}
	
	@RequestMapping("insert")
	public String insert(BoardVO vo) {
		String ip = request.getRemoteAddr();
		
		vo.setIp(ip);
		
		int res = boardDAO.insert(vo);
		return "redirect:board_list";
	}
	
	@RequestMapping("del")
	@ResponseBody
	public String delete(int idx) {
		BoardVO baseVO = boardDAO.selectOne(idx);
		
		baseVO.setSubject("이미 삭제된 글입니다.");
		baseVO.setName("unknown");
		
		int res = boardDAO.del_update(baseVO);
		
		if(res == 1) {
			return "{\"param\":\"yes\"}";
		}
		return "{\"param\":\"no\"}";
		
	}
	
	@RequestMapping("reply_form")
	public String reply_form(int idx, int page) {
		return Board.VIEW_PATH+"reply_form.jsp?idx="+idx+"&page="+page;
	}
	
	@RequestMapping("reply")
	public String reply(BoardVO vo, int idx, int page) {
		String ip = request.getRemoteAddr();
		
		BoardVO baseVO = boardDAO.selectOne(idx); 
		
		int res = boardDAO.update_step(baseVO);
		
		vo.setIp(ip);
		
		vo.setRef(baseVO.getRef());
		vo.setStep(baseVO.getStep()+1);
		vo.setDepth(baseVO.getDepth()+1);
		
		res = boardDAO.reply(vo);
		
		if(res > 0) {
			return "redirect:board_list?page="+page;
		}
		return null;
		
	}
	
	@RequestMapping("login_form")
	public String login_form() {
		return Member.VIEW_PATH+"login_form.jsp";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String login(String id, String pwd) {
		
		MemberVO vo = memberDAO.loginCheck(id);
		
		//id자체가 존재하지 않는 경우 || 비밀번호가 다른 경우
		if(vo == null || !vo.getPwd().equals(pwd)) {
			return "{\"param\":\"no\"}";
		}
		
		//아이디와 비밀번호에 문제가 없다면 세션에 바인딩한다.
		session.setAttribute("id", vo);
		
		return "{\"param\":\"yes\"}";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.removeAttribute("id");
		return "redirect:board_list";
	}
	
	@RequestMapping("member_insert_form")
	public String member_insert_form() {
		return Member.VIEW_PATH+"member_insert_form.jsp";
	}
	
	@RequestMapping("check_id")
	@ResponseBody
	public String chech_id(String id) {
		MemberVO vo = memberDAO.selectOne(id);
		
		if(vo == null) {
			return "{\"res\":\"yes\"}";
		}
		return "{\"res\":\"no\"}";
	}
}





