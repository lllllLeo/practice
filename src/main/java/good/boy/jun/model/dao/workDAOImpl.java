package good.boy.jun.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import good.boy.jun.model.dto.workDTO;

@Repository
public class workDAOImpl implements workDAO {

	@Inject
	SqlSession sqlsession;
	
	@Override
	public List<workDTO> worklist() {
		
		return sqlsession.selectList("work.allwork");
	}

	@Override
	public workDTO workDetail(String work_number) {
		
		return sqlsession.selectOne("work.workDetail",work_number);
	}

	@Override
	public void workviewcount(String work_number) {
		sqlsession.update("work.workviewcount",work_number);
	}

}
