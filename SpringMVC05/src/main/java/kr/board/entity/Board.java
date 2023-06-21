package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString // 없어도 되나 필드 정보 빠르게 확인하기 좋으나 추가 해보쟈,  object 메소드 오버라이딩 한 것

// 안의 필드값을 문자열로 만들어 반환해 주는 메소드
public class Board {
	// 캡슐화, 정보 은닉
	// 번호, 제목, 내용, 작성자, 작성일, 조회수
	private int idx;
	private String memID;
	private String title;
	private String content;
	private String writer;
	private String indate;
	private int count;
	

	
}
