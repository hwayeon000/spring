package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	/*
	 * public void index() { }
	 */
	// 함수명과 뷰네임이 같음 = void -> index.jsp로 이동함
	//하지만 return에 index 명시 추천!
	
	
}
