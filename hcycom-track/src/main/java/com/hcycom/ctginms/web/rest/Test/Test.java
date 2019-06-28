package com.hcycom.ctginms.web.rest.Test;

import org.joda.time.DateTime;

import java.sql.Time;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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






        int num1 =10;

        int num2 = 13 ;

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);

        System.out.println("num1和num2的百分比为:" + result + "%");

    }

}
