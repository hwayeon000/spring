package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.BookVO;
import kr.book.bshop.BookMapper;

@Controller
public class BookController {
	
	@Autowired
	private BookMapper mapper;
	
	@RequestMapping("/bookList.do")
	public void bookList(Model model) {
		List<BookVO> list = mapper.bookList();
		
		model.addAttribute("list", list);
//		return "boardList";
	}
	
	@RequestMapping("/bookInsert.do")
	public String bookInsert(BookVO vo) {
		System.out.println(vo.toString());
		mapper.bookInsert(vo);
		return "redirect:/bookList.do";
	}
	
	
	
	
}
