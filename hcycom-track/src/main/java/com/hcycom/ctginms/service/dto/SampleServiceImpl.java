package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.*;
import com.hcycom.ctginms.postdomain.PostSample;
import com.hcycom.ctginms.postdomain.PostSampletwo;
import com.hcycom.ctginms.repository.SampleMapper;
import com.hcycom.ctginms.service.SampleService;
import com.hcycom.ctginms.web.rest.util.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: SampleServiceImpl
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 16:59
 **/
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public List<Map<String,?>> getSampleByEventtcode(String eventcode) {
        // TODO Auto-generated method stub
        List<Map<String,?>> sampleList = sampleMapper.getSampleByEventtcode(eventcode);
        return sampleList;
    }

    @Override
    public OperationLog getOperationlog(String describe){
        OperationLog operationLog = sampleMapper.getOperationlog(describe);
        return operationLog;
    }
    @Override
    public List<String> getQueryPageone(PostSample postSample){
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<OperationLog> pageBean = new PageBean<OperationLog>();

        //封装当前页数
        pageBean.setCurrPage(postSample.getCurrentPage());

        //每页显示的数据
        pageBean.setPageSize(postSample.getPageSize());

        //封装总记录数
        int totalCount = sampleMapper.selectCount(postSample.getEventCode());
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/postSample.getPageSize());//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(postSample.getCurrentPage()-1)*postSample.getPageSize());
        map.put("size", pageBean.getPageSize());
        map.put("samplecode", postSample.getSamplecode());
        map.put("personcode", postSample.getPersoncode());
        map.put("researchname", postSample.getResearchname());
        map.put("cryopreservedcode", postSample.getCryopreservedcode());
        map.put("starttime", postSample.getStarttime());
        map.put("endtime", postSample.getEndtime());
        map.put("eventcode", postSample.getEventCode());
        //封装每页显示的数据
        List<String> lists = sampleMapper.getQueryPageone(map);
        return lists;
    }

    @Override
    public List<Map<String,?>> getQueryPagetwo(List<String> list,String eventcode,String starttime,String endtime){
        List<Map<String,?>> sampleList = sampleMapper.getQueryPagetwo(list,eventcode,starttime,endtime);
        return sampleList;
    }

    @Override
    public List<Sample> getAll() {
        return sampleMapper.getAll();
    }

    @Override
    public int selectCount(String eventcode){
        return sampleMapper.selectCount(eventcode);
    }

    @Override
    public List<Map<String,?>> getStatistics(String eventcode){
        List<Map<String,?>> sampleList = sampleMapper.getStatistics(eventcode);
        return sampleList;
    }

    /**
     * 删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override
    public int importSampleModel(MultipartFile multipartFile,String sample_info_code) throws Exception{
        File directory = new File(".");
        String path = directory.getCanonicalPath();
        System.out.println("文件保存的路径"+path);
        File filePath = new File(path);
        if(!filePath.exists()&&!filePath.isDirectory()) {

            System.out.println("目录不存在，创建路径"+filePath);
            filePath.mkdir();
        }
        //获取原始文件名称
        String originalFileName = multipartFile.getOriginalFilename();
        //转义拆分重命名文件
        System.out.println("原始文件的名称"+originalFileName);
        String[] strArr=originalFileName.split("\\.");
        SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMDDHHmmss");
        String strName=sdf.format(new Date());
        originalFileName=strName+"."+strArr[1];
        System.out.println("重命名文件的名称"+originalFileName);

        System.out.println(path);

        //获取文件的类型，以“.”作为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        System.out.println("文件类型"+type);
        //在指定的路径下面创建一个新的文件
        File targerFile = new File(path,originalFileName);

        multipartFile.transferTo(targerFile);

        CsvUtils csvUtils=new CsvUtils();
        List<String> samplelist =csvUtils.importCsv(targerFile);
        List<ImportSampleModel> importList=new ArrayList<ImportSampleModel>();
        if(samplelist!=null && !samplelist.isEmpty()){
            for(String data : samplelist){
                ImportSampleModel importModel=new ImportSampleModel();
                String[] aa = data.split(",");
                importModel.setId(0);
                importModel.setSample_code(aa[0]);
                importModel.setPerson_name(aa[1]);
                importModel.setPerson_code(aa[2]);
                importModel.setSample_type(aa[3]);
                importModel.setCapacity(aa[4]);
                importModel.setCryopreserved_code(aa[5]);
                importModel.setCryopreserved_line(Integer.parseInt(aa[6]));
                importModel.setCryopreserved_column(Integer.parseInt(aa[7]));
                importModel.setSubpackage_time(aa[8]);
                importModel.setOffset_number(Integer.parseInt(aa[9]));
                importModel.setRefrigerator_code(aa[10]);
                importModel.setRefrigerator_layer(Integer.parseInt(aa[11]));
                importModel.setSample_shelf(aa[12]);
                importModel.setSamplebox_code(aa[13]);
                String bb = (aa[14]+','+aa[15]).replace("\"", "");
                importModel.setBox_place(bb);
                importModel.setHead(aa[17]);
                importModel.setSample_info_code(sample_info_code);
                importList.add(importModel);
                System.out.println(importModel);
            }
        }
        int aa = sampleMapper.importSampleModel(importList);
        deleteFile(targerFile);
        return aa;
    }

    @Override
    public List<ImportSampleModel> findSampleModelByCode(String sampleModeCode){
        return sampleMapper.findSampleModelByCode(sampleModeCode);
    }

    @Override
    public int addSample(List<PostSampletwo> sampleList){
        return sampleMapper.addSample(sampleList);
    }


}
