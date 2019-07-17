package com.hcycom.ctginms.web.rest.Test;

import org.joda.time.DateTime;

import java.io.File;
import java.sql.Time;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
      /*  long startTime = DateTime.now().getMillis();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(String.valueOf(date));
        Date date1 = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取String类型的时间
        String createdate = sdf.format(date1);
        String time = DateTime.now().toString("yyyyMMddHHmmssSSS");
        String time1 = DateTime.now().toString("yyyyMMddHHmmssSSS");
        String time2 = DateTime.now().toString("yyyyMMddHHmmssSSS");
        System.out.println("-------------------"+time);*/






        int num1 =  24;

        int num2 =  80;

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);

        System.out.println("num1是num2的百分比为:" + result + "%");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        System.out.println("输入数字查看数字有几位");
        String n=new Scanner(System.in).next();
        String str=n.toString();
        //int a=str.length();
        String bb=""+n;
        while (bb.length()<3) {
            bb= "0"+bb;
        }
        String a=df.format(new Date());
        System.out.println(a);
        System.out.println(bb);
        System.out.println(n+"是"+str.length()+"位");


        String path = "D:\\aa.xlsx";
        boolean b = delFile(path);
        System.out.println(b);


    }


    static boolean delFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return file.delete();
        } else {
            String[] filenames = file.list();
            for (String f : filenames) {
                delFile(f);
            }
            return file.delete();
        }
    }

}
