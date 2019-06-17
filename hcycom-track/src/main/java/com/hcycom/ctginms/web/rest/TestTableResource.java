package com.hcycom.ctginms.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.codahale.metrics.annotation.Timed;

import com.hcycom.ctginms.domain.TestTable;
import com.hcycom.ctginms.repository.TestTableRepository;
import com.hcycom.ctginms.service.TestTableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 *@author 小硕硕
 *@date 2018年3月13日 上午11:41:44
 *测试表
 */
@RestController
//@RequestMapping(value="/api/testtable"),加/api就会过token验证，不加不需要token验证
@RequestMapping(value="/testtable")
@Api(tags={"测试表"},description="测试表的相关操作")
public class TestTableResource {
	
	@Autowired
	private TestTableRepository ttrep;
	
	@Autowired
	private TestTableService tts;
	
	
	private static long _TEN_THOUSAND=10000;
	
	@GetMapping("/getTestTableAll")
	@Timed
	@ApiOperation(value="获取表中所有的内容", notes="获取表中所有的内容")
	
	public ResponseEntity<List<TestTable>> getTestTableAll(){
		long times=1000*_TEN_THOUSAND;
        long t1=System.currentTimeMillis();
		List<TestTable> list=ttrep.findAll();
		long t2=System.currentTimeMillis();
	    System.out.println(t2-t1);
		ResponseEntity<List<TestTable>> rent=new ResponseEntity<List<TestTable>>(list,HttpStatus.OK);
		return rent;
	}
	
	
	/**   
	 * @Title: findByLinkTd   
	 * @Description:
	 * @param: @param tid
	 * @param: @return      
	 * @return: ResponseEntity<List<TestTable>>
	 */ 
	@GetMapping("/findByLinkTd")
	@Timed
	@ApiOperation(value="根据id查询测试表中的数据", notes="根据id查询，使用JPA，我通过规则自己定义的方法")
	@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	public ResponseEntity<List<TestTable>> findByLinkTd(String tid){
		List<TestTable> list = ttrep.findByTid(tid);
		
		return new ResponseEntity<List<TestTable>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/findByLinkTd12")
	@Timed
	@ApiOperation(value="根据id查询测试表中的数据12", notes="根据id查询，使用JPA，我通过规则自己定义的方法12")
	@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	public ResponseEntity<List<TestTable>> findByLinkTd12(String tid){
		List<TestTable> list = tts.getTestTableByTid(tid);
		
		return new ResponseEntity<List<TestTable>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/findByLinkTdtwo")
	@Timed
	@ApiOperation(value="根据id查询测试表中的数据", notes="根据id查询，使用JPA，直接用JPA自带的根据id查询的方法")
	@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	public ResponseEntity<TestTable> findByLinkTdTwo(String tid){
		TestTable tt = ttrep.findOne(tid);	
		
		return new ResponseEntity<TestTable>(tt, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/addTestTable")
	@Timed
	@ApiOperation(value="向表中insert数据", notes="向表中insert数据")
	//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	@ApiImplicitParams({
		//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tname", value = "测试表的名字", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tage", value = "测试表的年龄", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "tsex", value = "测试表的性别", required = true, dataType = "String",paramType="query")
	})
	public ResponseEntity<TestTable> addTestTable(String tname,int tage,String tsex){
		TestTable tt = new TestTable();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		tt.setTid(uuid);
		tt.setTname(tname);
		tt.setTage(tage);
		tt.setTsex(tsex);
		TestTable tt1 = new TestTable();
		tt1=ttrep.save(tt);
		System.out.println(tt1);
		return new ResponseEntity<TestTable>(tt1, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/updateTestTable")
	@Timed
	@ApiOperation(value="根据id修改测试表中的数据", notes="根据id修改测试表数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tname", value = "测试表的名字", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tage", value = "测试表的年龄", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "tsex", value = "测试表的性别", required = true, dataType = "String",paramType="query")
	
	})
	@Transactional
	@Modifying
	@CacheEvict(cacheNames="testtables",allEntries = true)
	public ResponseEntity<TestTable> updateTestTable(TestTable tt){
		TestTable tt1 = ttrep.findOne(tt.getTid());	
		tt1.setTname(tt.getTname());
		tt1.setTage(tt.getTage());
		tt1.setTsex(tt.getTsex());
		return new ResponseEntity<TestTable>(tt1, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/deleteTestTableTwo")
	@Timed
	@ApiOperation(value="根据id删除测试表中的数据", notes="根据id删除测试表中的数据（有返回提示）")
	@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	@Transactional
	@Modifying
	@CacheEvict(cacheNames="testtables",allEntries = true)
	public ResponseEntity<TestTable> deleteTestTableTwo(String tid){
		TestTable tt = ttrep.findOne(tid);	
		ttrep.delete(tt);
		return new ResponseEntity<TestTable>(tt, HttpStatus.OK);
	}
	
	@GetMapping("/deleteTestTable")
	@Timed
	@ApiOperation(value="根据id删除测试表中的数据", notes="根据id删除测试表中的数据（没有返回提示的删除）")
	@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	public void deleteTestTable(String tid){
		//TestTable tt = ttrep.findOne(tid);	
		
		ttrep.delete(tid);
	}
	
	
	/*
	
	
	@GetMapping("/findAllTestTabel")
	@Timed
	@ApiOperation(value="查询测试表中的全部数据（分页）", notes="查询测试表中的全部数据（分页）")
	@ApiImplicitParams({
		//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "pageable.page", value = "页数", required = true),
		@ApiImplicitParam(name = "pageable.size", value = "一页显示的个数", required = true),
		@ApiImplicitParam(name = "pageable.sort", value = "用什么字段排序（默认升序）", required = true)
	})
	public ResponseEntity<List<TestTable>>findAllTestTabel(Pageable pageable){
		TestTable tt = ttrep.findOne(tid);
		TestTable tt=new TestTable();
		tt.setTname("xiaoming");
		ExampleMatcher matcher = ExampleMatcher.matching();
		matcher.withMatcher("tname", GenericPropertyMatchers.startsWith());
		matcher.withIgnorePaths("字段");
		Example<TestTable> example = Example.of(tt); 
		Page<TestTable> page=ttrep.findAll(example, pageable);
		Page<TestTable> page=ttrep.findAll(pageable);
		ResponseEntity<List<TestTable>> ren=new ResponseEntity<List<TestTable>>(page.getContent(),HttpStatus.OK);
		return ren;
	}
	
	
	
	@GetMapping("/findByTestTableLike")
	@Timed 
	@ApiOperation(value="模糊查询测试表中的数据", notes="模糊查询测试表中的数据")
	
	//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	public ResponseEntity<List<TestTable>> findByTestTableLike(TestTable testtable){
		List<TestTable> list=new ArrayList<TestTable>();
		if(testtable.getTage()==-1){
			list = ttrep.findByTnameLikeAndTsexLike("%"+testtable.getTname()+"%","%"+testtable.getTsex()+"%");	
		}else{
			list=ttrep.findByTidLikeAndTnameLikeAndTageAndTsexLike("%"+testtable.getTid()+"%","%"+testtable.getTname()+"%",testtable.getTage(),"%"+testtable.getTsex()+"%");
		}
		//ttrep.deleteInBatch(Iterable<TestTable> entities);
		return new ResponseEntity<List<TestTable>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/deleteManyTestTable")
	@Timed
	@ApiOperation(value="批量删除测试表中的数据", notes="批量删除测试表中的数据（没有返回提示的删除）")
	//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	@Transactional
	@Modifying
	@CacheEvict(cacheNames="testtables",allEntries = true)
	public void deleteManyTestTable(String []ids){
		//专门的批量删除（有优化的）ttrep.delete(list);也是支持批量的

		List<TestTable> list=new ArrayList<TestTable>();
		
		for (int i = 0; i < ids.length; i++) {
			TestTable tt=new TestTable();
			tt.setTid(ids[i]);
			list.add(tt);
		}

		ttrep.deleteInBatch(list);
		
		
	}
	

	
	
	@GetMapping("/addManyTestTable")
	@Timed
	@ApiOperation(value="批量向表中insert数据", notes="批量向表中insert数据（为了测试所以后台将相同数据进行循环）")
	//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	@ApiImplicitParams({
		//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tname", value = "测试表的名字", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tage", value = "测试表的年龄", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "tsex", value = "测试表的性别", required = true, dataType = "String",paramType="query")
	})
	public ResponseEntity<List<TestTable>> addManyTestTable(String tname,int tage,String tsex){
		
		List<TestTable> list=new ArrayList<TestTable>();
		
		for (int i = 0; i < 100000; i++) {
			TestTable tt = new TestTable();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			tt.setTid(uuid);
			tt.setTname(tname);
			tt.setTage(tage);
			tt.setTsex(tsex);
			list.add(tt);
		}
		
		TestTable tt1 = new TestTable();
		tt1=ttrep.save(tt);
		List<TestTable> list1=ttrep.save(list);
		return new ResponseEntity<List<TestTable>>(list1, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/updateSaveTestTable")
	@Timed
	@ApiOperation(value="用save修改表中数据", notes="用save修改表中数据")
	//@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tid", value = "测试表的ID", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tname", value = "测试表的名字", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "tage", value = "测试表的年龄", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "tsex", value = "测试表的性别", required = true, dataType = "String",paramType="query")
	})
	public ResponseEntity<TestTable> updateSaveTestTable(String tid,String tname,int tage,String tsex){

			TestTable tt = new TestTable();
			//String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			tt.setTid(tid);
			tt.setTname(tname);
			tt.setTage(tage);
			tt.setTsex(tsex);

		
		TestTable tt1 = new TestTable();
		tt1=ttrep.save(tt);
		TestTable tt1=ttrep.save(tt);
		return new ResponseEntity<TestTable>(tt1, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/findByTestTableToTClassTab")
	@Timed 
	@ApiOperation(value="查询测试表中的数据", notes="查询测试表中的数据")	
	public ResponseEntity<Page<TestTable>> findByTestTableToTClassTab(Pageable pageable){
		//Page<TestTable> page=ttrep.findByTestclasstable_Tcname(pageable);
		Page<TestTable> page=null;
		if(testtable.getTage()==-1){
			list = ttrep.findByTnameLikeAndTsexLike("%"+testtable.getTname()+"%","%"+testtable.getTsex()+"%");	
		}else{
			list=ttrep.findByTidLikeAndTnameLikeAndTageAndTsexLike("%"+testtable.getTid()+"%","%"+testtable.getTname()+"%",testtable.getTage(),"%"+testtable.getTsex()+"%");
		}
		
		return new ResponseEntity<Page<TestTable>>(page, HttpStatus.OK);
	}
	
	
	*/
	

}
