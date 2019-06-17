package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.Project;
import com.hcycom.ctginms.web.rest.vm.UpdateProjectMessage;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午9:36:09   
 * @name 李硕
 * @Description: 项目的持久层，project的表操作
 */
@Mapper
public interface ProjectMapper {

	//查询全部已激活的项目列表，projectstate字段为1
	List<Project> selectAllProject();
	
	//添加单条项目详细信息，主要为项目名称和项目描述
	int insertProjectOne(@Param("project")Project project);
	
	//通过项目id，单个查询项目
	Project selectOneProjectById(@Param("id")int id);
	
	//通过项目projectcode，单个查询项目
	Project selectOneProjectByProjectcode(@Param("projectcode")String projectcode);
	
	//通过项目编码，查询该项目做修改的详细信息（项目名称，项目描述，五大功能识别）
	UpdateProjectMessage selectUpdateProjectMessage(@Param("projectcode")String projectcode);
	
	//修改项目的名称和描述
	int updateProject(@Param("project")Project project);
	
	/*删除项目（这里删除项目，仅将项目的激活字段projectstate设置为2，
	其余与项目相关的事件表以及function功能表，共享项目的表都不会动，
	以后删除项目后，可以做数据迁移，这方面的优化，就是项目列表中为2的，其他表中的数据
	可以暂时迁移其他表，不在正式的表中，这样可以提高项目事件的查询效率）
	这样删除实际修改，是因为首先是保留项目，其次，为了防止误删，可以恢复项目数据，超级管理员有恢复删除项目的权限
	*/
	//修改操作，做删除和恢复功能
	int updateProjectState(@Param("project")Project project);
	
	//查询全部被删除的项目
	List<Project> selectISDeleteProject();
	
	
	
	
	
}
