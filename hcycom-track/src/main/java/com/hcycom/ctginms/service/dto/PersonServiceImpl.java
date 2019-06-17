package com.hcycom.ctginms.service.dto;

import java.util.List;

import com.hcycom.ctginms.domain.Researcher;
import com.hcycom.ctginms.postdomain.Tada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.Person;
import com.hcycom.ctginms.postdomain.PostPerson;
import com.hcycom.ctginms.repository.PersonMapper;
import com.hcycom.ctginms.service.PersonService;

/**
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月22日 上午11:01:12   
 * @name: 李硕
 * @Description: 人员表和人员事件对照表的服务层接口实现类
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonMapper pm;




    @Override
    public List<Person> getPersonByProjectcode(String projectcode) {
        // TODO Auto-generated method stub


        List<Person> plist = pm.selectPersonByProjectcode(projectcode);





        return plist;
    }

    @Override
    public List<Person> getPersonByEventCode(String eventcode) {
        // TODO Auto-generated method stub

        List<Person> plist = pm.selectPersonByEventCode(eventcode);


        return plist;
    }

    @Override
    public int updateOnePersonById(PostPerson person) {
        // TODO Auto-generated method stub

        Person person1 = new Person();

        person1.setId(person.getId());
        person1.setResearchcode(person.getResearchcode());
        person1.setResearchname(person.getResearchname());
        person1.setPosition(person.getPosition());
        person1.setProjectcode(person.getProjectcode());
        person1.setSex(person.getSex());
        person1.setSex(person.getSex());

        int a = pm.updateOnePersonById(person1);

        return a;
    }

    @Override
    public int deleteOnePersonById(int id) {
        // TODO Auto-generated method stub

        int a = pm.deleteOnePersonById(id);

        return a;
    }

    @Override
    public int addOnePerson(PostPerson person) {
        // TODO Auto-generated method stub

        Person person1=new Person();

        person1.setId(person.getId());
        person1.setResearchcode(person.getResearchcode());
        person1.setResearchname(person.getResearchname());
        person1.setPosition(person.getPosition());
        person1.setProjectcode(person.getProjectcode());
        person1.setSex(person.getSex());



        pm.addOnePerson(person1);

        int id = person1.getId();

        return id;
    }

    /*@Override
    public List<Person> findUserListByPage(int page, int pageSize, String projectcode) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<Person> findUserListByPage = pm.findUserListByPage(b, pageSize,projectcode);
        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+b+"aaaaaaaaaaaaaaaaaaaaaaaaaaa"+pageSize);
        return findUserListByPage;
    }*/

    @Override
    public Tada likeSelect(String projectcode, String researchname, String researchcode, int page, int pageSize) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<Person> researchers = pm.likeSelect(projectcode, researchname, researchcode, b, pageSize);
        Tada tada = new Tada();
        tada.setSelect(researchers);
        int likeTable = pm.getLikeTable(projectcode, researchname, researchcode);
        tada.setPages(likeTable);
        return tada;
    }


}
