package good.boy.jun.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import good.boy.jun.model.dao.yujunDAO;

@Service
public class yujunServiceImpl implements yujunService {

	@Inject
	yujunDAO yujundao;
	
	@Override
	public boolean logincheck(HashMap<String, String> forlogin) {
		return yujundao.logincheck(forlogin);
	}

	
}
