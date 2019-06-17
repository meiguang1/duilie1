package com.hcycom.ctginms.service.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.DeathRate;
import com.hcycom.ctginms.domain.ExposeRelation;
import com.hcycom.ctginms.domain.RegionPopulation;
import com.hcycom.ctginms.repository.ValueMapper;
import com.hcycom.ctginms.service.DeathRateService;
import com.hcycom.ctginms.service.ExposeRelationService;
import com.hcycom.ctginms.service.RegionPopulationService;
import com.hcycom.ctginms.service.ValueService;
import com.hcycom.ctginms.web.rest.vm.CityPM25AverageAndRisk;
import com.hcycom.ctginms.web.rest.vm.DailyAveragePM25;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午5:23:28   
 * @name 李硕
 * @Description: vlaue表服务层实现类
 */
@Service
public class ValueServiceImpl implements ValueService{

	@Autowired
	private ValueMapper valuemapper;
	
	@Autowired
	private DeathRateService drs;
	
	@Autowired
	private ExposeRelationService ers;
	
	@Autowired
	private RegionPopulationService rps;
	
	@Override
	public List<List<DailyAveragePM25>> getValueByDistrictAndCurrenttime(String[] province, String[] city, String[] district,Date starttime, Date endtime) {
		// TODO Auto-generated method stub
		List<DailyAveragePM25> list=new ArrayList<DailyAveragePM25>();
		List<List<DailyAveragePM25>> list1=new ArrayList<List<DailyAveragePM25>>();
		//按照不用区域将每个地区的每日的pm2.5均值放到list中，再将list放入list1中
		for(int i=0;i<province.length;i++){
			list= valuemapper.selectValueByDistrictAndCurrenttime(province[i], city[i], district[i], starttime, endtime);
			list1.add(list);
		}
		
				
		return list1;
	}

	@Override
	public List<CityPM25AverageAndRisk> getCityPM25AverageAndRisk(String[] province, String[] city, String[] district,
			Date starttime, Date endtime,String disease) {
		// TODO Auto-generated method stub
		List<DailyAveragePM25> list=new ArrayList<DailyAveragePM25>();
		List<CityPM25AverageAndRisk> cparlist=new ArrayList<CityPM25AverageAndRisk>();
		Double pm25=0.0;		
		//按照不同区域，将所选择的这一时间段的pm2.5的均值计算以及超额总死亡人数，并存入cparlist中
		
		//目前创建一个写死的暴反系数
		Double er=0.0;
		//超额总死亡人数
		int risk=0;
		for(int i=0;i<province.length;i++){
			pm25=0.0;
			System.out.println(province[i]+"***"+city[i]+"***"+district[i]+"***"+disease);
			//计算不用区域将每个地区的每日的pm2.5均值，for循环将pm2.5值加起来
			list= valuemapper.selectValueByDistrictAndCurrenttime(province[i], city[i], district[i], starttime, endtime);
			//获取该地区暴反系数
//			List<ExposeRelation> erlist=ers.getExposeRelationByArea(province[i], city[i], district[i], disease);
//			System.out.println("暴反系数："+erlist.get(0).getExposeratio());
			//暴反关系现在将上面查询数据库的方法注销，是因为，这个目前是固定的暴反关系系数
			if(disease.equals("非意外总死亡")){
				er=0.15;
			}else if(disease.equals("呼吸系统疾病")){
				er=0.05;
			}else if(disease.equals("循环系统疾病")){
				er=0.27;
			}
			System.out.println("暴反系数："+er);
			//获取该地区人口死亡率
			List<DeathRate> drlist=drs.getDeathRateByArea(province[i], city[i], district[i]);
			System.out.println("人口死亡率："+drlist.get(0).getDeathratevalue());
			Double dr=Double.parseDouble(drlist.get(0).getDeathratevalue());
			//获取该地区人口数
			List<RegionPopulation> rplist=rps.getRegionPopulationByArea(province[i], city[i], district[i]);
			System.out.println("人口总数："+rplist.get(0).getPopnumber());
			int rp=rplist.get(0).getPopnumber();
			for (int j = 0; j < list.size(); j++) {
				pm25+=list.get(j).getPm25();				
			}
			//risk=(int) (er*dr*rp*pm25/10/365); 
			//四舍五入   非意外总死亡数
			risk=new BigDecimal(er*dr*rp*pm25/10/365).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			System.out.println("超额总死亡人数（计算结果）:"+er*dr*rp*pm25/10/365);
			System.out.println("超额总死亡人数（最终结果）:"+risk);
			CityPM25AverageAndRisk cpar=new CityPM25AverageAndRisk();
			cpar.setProvince(list.get(0).getProvince());
			cpar.setCity(list.get(0).getCity());
			cpar.setDistrict(list.get(0).getDistrict());
			cpar.setRisk(risk);
			cpar.setPm25(pm25/list.size());
			cpar.setDays(list.size());
			cparlist.add(cpar);			
		}
		
		return cparlist;
	}

	
}
