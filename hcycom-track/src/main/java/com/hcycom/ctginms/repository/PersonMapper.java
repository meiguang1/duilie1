package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.Person;

/**
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月22日 上午11:02:45
 * @name: 李硕
 * @Description: 人员表和人员事件对照表的持久层操作
 */
@Mapper
public interface PersonMapper {


    //根据项目查询全部人员
    List<Person> selectPersonByProjectcode(@Param("projectcode")String projectcode);

    //根据事件查询全部人员
    List<Person> selectPersonByEventCode(@Param("eventcode")String eventcode);
	/*
	//服务分页的查询全部数量（根据项目查询全部人员）
	int selectCountPersonByProjectcode(@Param("projectcode")String projectcode);

	//服务分页的查询全部数量（根据事件查询全部人员）
	int selectCountPersonByEventCode(@Param("eventcode")String eventcode);


	//根据项目查询全部人员(带分页)
	List<Person> selectLimitPersonByProjectcode(@Param("projectcode")String projectcode,@Param("start")int start,@Param("end")int end);

	//根据事件查询全部人员(带分页)
	List<Person> selectLimitPersonByEventCode(@Param("eventcode")String eventcode,@Param("start")int start,@Param("end")int end);
	*/

    /*分页,并且以事件编码进行分页
    List<Person>  findUserListByPage(@Param("page") int page ,
                                     @Param("pageSize") int pageSize,
                                     @Param("projectcode") String projectcode);*/


    //修改单个人员信息
    int updateOnePersonById(@Param("person")Person person);

    //删除单个人员信息（逻辑删除，更改状态）
    int deleteOnePersonById(@Param("id")int id);

    //新增一个人员（该方法仅单个添加）返回新增人员的id
    int addOnePerson(@Param("person")Person person);

    //按照项目编码对调查对象编号以及姓名进行查询(分页)
    List<Person> likeSelect(@Param("projectcode")String projectcode,
                            @Param("researchname")String researchname,
                            @Param("researchcode")String researchcode,
                            @Param("page") int page ,
                            @Param("pageSize") int pageSize);

    //按照项目编码对调查对象编号以及姓名进行查询(总条数)
    int getLikeTable(@Param("projectcode")String projectcode,
                     @Param("researchname")String researchname,
                     @Param("researchcode")String researchcode);



}
