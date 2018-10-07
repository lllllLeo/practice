package good.boy.jun.service;

import java.util.List;

import good.boy.jun.model.dto.workDTO;

public interface workService {

	public List<workDTO> worklist();

	public workDTO workDetail(String work_number);

	public void workviewcount(String work_number);

}
