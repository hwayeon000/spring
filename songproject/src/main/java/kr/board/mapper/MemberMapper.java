package kr.board.mapper;


import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Member;


@Mapper
public interface MemberMapper {

	public Member registerCheck(String memID);

	public int join(Member m);

	public Member login(Member m);

	public int update(Member m);

	public Member getMember(String memID);

	public void profileUpdate(Member vo);
	
	
	

}
