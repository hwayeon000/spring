package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

// Handler MApping이 Controller(POJO)를 찾기 위해
// @(어노테이션)으로 Controller이라고 명시해야 함
@Controller
public class BoardController {
	@Autowired // 스프링 컨테이너에 객체가 생성되어 올라간 boardMapper(인터페이스) 객체를 주입받아 사용하겠다
	private BoardMapper boardMapper;
	
	// 게시글 전체 보기  /boardList.do
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		// DB로부터 게시글 정보를 불러오기
		// 게시글 - 번호, 제목, 내용, 작성자, 날짜, 조회수
		// 하나의 게시글 작성
		List<Board> list = boardMapper.boardList();
		
		// ✨✨✨ 객체 바인딩 ( 동적 바인딩 ) ✨✨✨
		model.addAttribute("list", list);
		
		// boardList.jsp로 이동 -> 포워딩 방식
		return "boardList";
	}
	
	// 게시글 입력 페이지 이동  /boardForm.do
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm";
	}
	
	// 게시글 작성  /boardInsert.do -> requestMapping보다 보안적 측면에서 안전..(?)
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board board) {
		// title, content, writer
		System.out.println(board.toString());
		boardMapper.boardInsert(board);
		
		return "redirect:/boardList.do";
	}
	
	// 게시글 상세보기  /boardContent.do?idx=?
	@GetMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx")int idx, Model model) {
		boardMapper.boardCount(idx);
		Board vo = boardMapper.boardContent(idx);		
		model.addAttribute("vo", vo);
		
		return "boardContent";
	}
	
	// 게시글 삭제  /boardDelete.do?idx=?
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx")int idx) {
		boardMapper.boardDelete(idx);
		
		return "redirect:/boardList.do";
	}
	
	//게시글 수정화면 이동 /boardUpdateForm.do
	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx")int idx, Model model) {
		Board vo = boardMapper.boardContent(idx);
		model.addAttribute("vo", vo);
		
		return "boardUpdateForm";
	}
	
	// 게시글 수정  /boardUpdate.do
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board board) {
		// title, content, writer
		System.out.println(board.toString());
		boardMapper.boardUpdate(board);
		
		return "redirect:/boardList.do";
	}
	
	
}



