package good.boy.jun.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import good.boy.jun.model.dao.workDAO;
import good.boy.jun.model.dto.workDTO;

@Service
public class workServiceImpl implements workService {

	@Inject
	workDAO workdao;
	
	@Override
	public List<workDTO> worklist() {
		return workdao.worklist();
	}

	@Override
	public workDTO workDetail(String work_number) {
		return workdao.workDetail(work_number);
	}

	@Override
	public void workviewcount(String work_number) {
		workdao.workviewcount(work_number);
	}
	
}
