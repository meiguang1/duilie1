package com.hcycom.ctginms.service;

import java.util.List;

import com.hcycom.ctginms.postdomain.Tada;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.Person;
import com.hcycom.ctginms.postdomain.PostPerson;
import org.springframework.stereotype.Service;

/**
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月22日 上午11:02:02   
 * @name: 李硕
 * @Description: 人员表和人员事件对照表的服务层接口
 */
public interface PersonService {




    //根据项目编码code,获取查询全部人员
    List<Person> getPersonByProjectcode(String projectcode);

    //根据事件编码code，查询全部所属事件人员
    List<Person> getPersonByEventCode(String eventcode);

    //修改单个人员信息，返回int为改变行数非id
    int updateOnePersonById(PostPerson person);

    //通过id，删除单个人员信息（逻辑删除，更改状态）
    int deleteOnePersonById(int id);

    //新增一个人员（该方法仅单个添加）返回新增人员的id
    int addOnePerson(PostPerson person);


    /*分页查询所有数据
    @param page //当前页
    @param pageSize //每页记录数
    List<Person> findUserListByPage(int page, int pageSize, String projectcode);
    */


    //按照项目编码对调查对象编号以及姓名进行查询以及分页
    Tada likeSelect(String projectcode, String researchname, String researchcode, int page, int pageSize);


}
