package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString 
// ToString이란? vo안에 있는 모든 요소를 나열시켜준다
public class Board {

	private int idx; // 번호
	private String memID; // 회원아이디
	private String title; //제목
	private String content; // 내용
	private String writer; // 작성자
	private String indate; // 작성일
	private int count; // 조회수
	
	
}
