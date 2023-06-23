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

@RequestMapping("/board") // 처음에 무조건 보드로 들어와야 기능을 할거다
@RestController
public class BoardRestController {

	@Autowired
	private BoardMapper boardMapper; //Ioc 컨테이너에서 injection받아오겠다
	
	// 게시글 전체보기 /boardList.do
	@GetMapping("/all")
	public List<Board> boardList(){
		List<Board> list = boardMapper.boardList();
		return list;
	}
	
	// 게시글 등록 /boardInsert.do
	@PostMapping("/new")
	public void boardInsert(Board board){ // 비동기방식으로 응답하려면 @ResponseBody가 반드시 필요하다 하지만 RestController에서는 필요 없다
		boardMapper.boardInsert(board);
		System.out.println("insert 성공");
	}
	
	
	// 게시글 삭제 /boardDelete.do
	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx") int idx) { // 각각 다른 개체를 가져올때는 @RequestParam을 여러개 적어도 된다
		boardMapper.boardDelete(idx);
	}
	
	// 게시글 수정 /boardUpdate.do
	@PutMapping("/update") //post 계열의 putmapping을 써보자
	public void boardUpdate(@RequestBody Board board) { //put방식은 @requestbody를 꼭 명시해줘야한다
		boardMapper.boardUpdate(board);
		System.out.println(board);
	}
	
	// 게시글 상세보기 /boardContent.do
	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx") int idx) {
		Board vo = boardMapper.boardContent(idx);
		return vo;
	}
	
	// 게시글 조회수 올리기 /boardCount.do
	@PutMapping("/count/{idx}")
	public void boardCount(@PathVariable("idx") int idx) {
		boardMapper.boardCount(idx);
		System.out.println(idx);
	}
	
}
