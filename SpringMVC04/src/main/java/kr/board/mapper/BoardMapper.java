package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper
public interface BoardMapper {

	public List<Board> boardList();

	public void boardInsert(Board board);

	public Board boardContent(int idx);

	public void boardDelete(int idx);

	public void boardUpdate(Board board);

	// 이런 방법도 있음, 단, xml에 boardCount라는 중복된 메서드 있으면 안됨
	// 유지보수에서 XML은 한번에 처리가능하므로 웬만하면 XML에 한번에 처리하는것이 좋음
	@Update("UPDATE board SET count=count+1 WHERE idx=#{idx}")
	public void boardCount(int idx);

}
