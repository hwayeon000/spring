package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {
	
	private int user_seq;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nick;
	private String user_address;
	private String user_phone;
	private String user_date;
	private String user_status;
	
	
}
