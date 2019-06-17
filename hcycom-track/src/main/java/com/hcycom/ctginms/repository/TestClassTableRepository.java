package com.hcycom.ctginms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcycom.ctginms.domain.TestClassTable;

/**
 *@author 小硕硕
 *@date 2018年3月13日 下午3:16:34
 *
 */
@Repository
public interface TestClassTableRepository extends JpaRepository<TestClassTable,String>{

	//, nativeQuery = true
	@Query(value = "select * from hcy_test_calsstable where t_c_name=?1", nativeQuery = true)
	TestClassTable findByTcname(String tcname);
	
}
