package com.hcycom.ctginms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hcycom.ctginms.domain.TestTable;

/**
 *@author 小硕硕
 *@date 2018年3月13日 上午11:38:38
 *
 */
@Repository

public interface TestTableRepository extends JpaRepository<TestTable,String>{
//User findByNameAndPassword(String name, String password);
	
	public List<TestTable> findByTid(String tid);
	
	
	public List<TestTable> findByTidLikeAndTnameLikeAndTageAndTsexLike(String tid,String tname,int tage,String tsex);
	public List<TestTable> findByTnameLikeAndTsexLike(String tname,String tsex);
	
	
	//public void deleteMany(List<TestTable> list);
	
	/*异步查询	
	@Async
	Future<User> findByFirstname(String firstname);               

	@Async
	CompletableFuture<User> findOneByFirstname(String firstname); 

	@Async
	ListenableFuture<User> findOneByLastname(String lastname); */
	//public void batchInsert(List<TestTable> list);
	
	//public Page<TestTable> findByTestclasstable_Tcname(Pageable pageable);
	
}
