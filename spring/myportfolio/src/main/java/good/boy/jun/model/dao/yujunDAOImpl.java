package good.boy.jun.model.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class yujunDAOImpl implements yujunDAO {

	@Inject
	SqlSession sqlsession;

	@Override
	public boolean logincheck(HashMap<String, String> forlogin) {
		System.out.println(forlogin.get("yj_id"));
		System.out.println(forlogin.get("yj_password"));
		String result = sqlsession.selectOne("yujun.logincheck",forlogin);
		return result == null ? false : true; 
	}

}
