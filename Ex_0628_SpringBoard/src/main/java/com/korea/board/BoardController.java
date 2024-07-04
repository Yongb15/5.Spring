package com.korea.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BoardDAO;
import lombok.RequiredArgsConstructor;
import util.Common.Board;
import util.Paging;
import vo.BoardVO;

@Controller
@RequiredArgsConstructor
public class BoardController {

	final BoardDAO boardDAO;
	
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
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return Board.VIEW_PATH+"board_list.jsp?page="+nowPage;
	}
	
	@RequestMapping("view")
	public String view(Model model, int idx, @RequestParam(required=false, defaultValue="1")int page) {
		BoardVO vo = boardDAO.selectOne(idx);
		
		model.addAttribute("vo",vo);
		return Board.VIEW_PATH+"board_view.jsp?page="+page;
	}
	
}





