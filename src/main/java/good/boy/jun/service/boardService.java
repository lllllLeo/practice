package good.boy.jun.service;

import java.util.List;

import good.boy.jun.model.dto.boardDTO;

public interface boardService {

	public void register(boardDTO dto) throws Exception;
	
	public void update(boardDTO dto) throws Exception;
	
	public boolean delete(int board_num) throws Exception;
	
	public boardDTO read(int board_num) throws Exception;
	
	public List<boardDTO> readall() throws Exception;
	
	public void viewcount(int board_num) throws Exception;

    public int pageCount() throws Exception;
}
