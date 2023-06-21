package kr.board.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // getter, setter (EL식 필수, private 이므로..)
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전체를 받는 생성자
@ToString
public class Member {
	
	private int memIdx;
   	private String memID;
   	private String memPassword;
   	private String memName;
   	private int memAge;
   	private String memGender;
   	private String memEmail;
   	private String memProfile;
   	// 회원의 권한을 저장할 필드
   	// 한 사람의 권한이 하나, 혹은 두개, 세개 일 수도 있으므로 List
   	private List<Auth> authList;
}
