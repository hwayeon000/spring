package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")  // get, post 모두 받을 수 있는 request
@RestController  // 비동기 통신 방식 선언
public class BoardRestController {

	@Autowired
	private BoardMapper boardMapper;

	// 게시글 전체보기 요청 /boardList.do
	// @ResponseBody 비동기를 명시하는 방법 
	@GetMapping("/all")
	public List<Board> boardList(){
		List<Board> list = boardMapper.boardList();
		return list;
	}
	
	// Board data : input의 name이 Board의 필드명과 일치하면 알아서 묶어줌!!
	@PostMapping("/new")
	public void boardInsert(Board data) {
		boardMapper.boardInsert(data);
	}
	
	// 게시글 삭제 /boardDelete.do
	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx")int idx) {
		boardMapper.boardDelete(idx);
	}
	
	// 게시글 수정
	@PutMapping("/update")
	public void boardUpdate(@RequestBody Board data) {
		boardMapper.boardUpdate(data);
	}
	
	// 게시글 상세보기 /boardDelete.do
	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx")int idx) {
		Board data = boardMapper.boardContent(idx);
		return data;
	}
	
	// 게시글 조회수 올리기 /boardCount.do
	@PutMapping("/count/{idx}")
	public void boardCount(@PathVariable("idx")int idx) {
		boardMapper.boardCount(idx);
	}
	
	
	
}
