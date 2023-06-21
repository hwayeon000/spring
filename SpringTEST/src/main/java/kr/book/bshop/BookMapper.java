package kr.book.bshop;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.BookVO;

@Mapper
public interface BookMapper {

	public List<BookVO> bookList();

	public void bookInsert(BookVO vo);

}
