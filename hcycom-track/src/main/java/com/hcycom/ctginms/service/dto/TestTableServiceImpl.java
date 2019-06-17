package com.hcycom.ctginms.service.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.TestTable;
import com.hcycom.ctginms.repository.TestTableRepository;
import com.hcycom.ctginms.service.TestTableService;

/**
 *@author 小硕硕
 *@date 2018年5月14日 上午10:44:47
 *
 */
@Service
public class TestTableServiceImpl implements TestTableService{

	
	
	@Autowired
	private TestTableRepository ttr;
	
	
	@Override
	public List<TestTable> getTestTableByTid(String tid) {
		// TODO Auto-generated method stub
		
		List<TestTable> list=ttr.findByTid(tid);
		
		return list;
	}

}
