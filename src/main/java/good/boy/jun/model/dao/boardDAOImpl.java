package good.boy.jun.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import good.boy.jun.model.dto.boardDTO;

@Repository
public class boardDAOImpl implements boardDAO {

	@Autowired
	private SqlSession session;

	@Override
	public void register(boardDTO dto) throws Exception {
		session.insert("board.register", dto);
	}
	
	@Override
	public void update(boardDTO dto) throws Exception {
		session.update("board.update", dto);
	}

	@Override
	public boolean delete(int board_num) throws Exception {
		int result = session.delete("board.delete", board_num);
		
		return result == 1 ? true : false;
	}

	@Override
	public boardDTO read(int board_num) throws Exception {
		return session.selectOne("board.read", board_num);
	}

	@Override
	public List<boardDTO> readall() throws Exception {
		return session.selectList("board.readall");
	}

	@Override
	public void viewcount(int board_num) throws Exception {
		session.update("board.viewcount", board_num);
	}

	@Override
	public List<boardDTO> readPage(int page) throws Exception {
		return session.selectList("board.readPage", page);
	}

	@Override
	public int pageCount() throws Exception {
		return session.selectOne("board.pageCount");
	}

}
