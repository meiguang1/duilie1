package com.hcycom.ctginms.web.rest.Test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;

public class Test1 {
    public static void main(String[] args) {
        String excelPath = "C:\\Users\\WeiJie Li\\Desktop\\aa.xlsx1";
        String aa= "";
        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else if("csv".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else{
                    System.out.println("文件类型错误！！！");
                    return;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        System.out.println("------------------"+subZeroAndDot(String.valueOf(row.getCell(0))));
                        System.out.println("------------------"+subZeroAndDot(String.valueOf(row.getCell(1))));
                        System.out.println("------------------"+row.getCell(2));
                        System.out.println("------------------"+row.getCell(3));
                        System.out.println("------------------"+row.getCell(4));
                        System.out.println("------------------"+subZeroAndDot(String.valueOf(row.getCell(5))));
                        System.out.println("------------------"+subZeroAndDot(String.valueOf(row.getCell(6))));
                        String str= subZeroAndDot(String.valueOf(row.getCell(6)));
                        String countycode=""+str;
                        while (countycode.length()<3) {
                            countycode= "0"+countycode;
                        }
                        System.out.println(countycode);
                       /* for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                System.out.println("数据："+cell.toString());
                            }
                        }*/
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(aa);
    }
    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
