package com.hcycom.ctginms.service;

import java.util.List;

import com.hcycom.ctginms.domain.TestTable;

/**
 *@author 小硕硕
 *@date 2018年5月14日 上午10:42:16
 *
 */
public interface TestTableService {

	public List<TestTable> getTestTableByTid(String tid);
}
