package good.boy.jun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import good.boy.jun.model.dao.boardDAO;
import good.boy.jun.model.dto.boardDTO;

@Service
public class boardServiceImpl implements boardService {

	@Autowired
	private boardDAO dao;
	
	@Override
	public void register(boardDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public void update(boardDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public boolean delete(int board_num) throws Exception {
		return dao.delete(board_num);
	}

	@Override
	public boardDTO read(int board_num) throws Exception {
		return dao.read(board_num);
	}

	@Override
	public List<boardDTO> readall() throws Exception {
		return dao.readall();
	}

	@Override
	public void viewcount(int board_num) throws Exception {
		dao.viewcount(board_num);
	}

}
