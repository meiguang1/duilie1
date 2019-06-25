package com.hcycom.ctginms.web.rest.Test;

import org.joda.time.DateTime;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
       /* String string = "1561102939261";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
           date = dateFormat.parse(string);
            System.out.println(date.toLocaleString().split(" ")[0]);//切割掉不要的时分秒数据
        } catch (ParseException e) {
            e.printStackTrace();
         }*/

        /*String s = "1561102939261";//这是你要转换为date类型的字符串
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");//设置一个时间转换器
        Date d = null;
        try {
            d = sf.parse(s);//将字符串s通过转换器转换为date类型
        } catch (ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(d);//输出date类型
        System.out.println(sf.format(d));//输出date类型d但以转换器表示的形式打印*/
        long startTime = DateTime.now().getMillis();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(String.valueOf(date));
        /*long a = 1561102939261L;
        Date d = new Date(1561102939261L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");//设置一个时间转换器*/

        //System.out.printf(new DateTime().fo);




        Date date1 = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取String类型的时间
        String createdate = sdf.format(date1);
        String time = DateTime.now().toString("yyyyMMddHHmmssSSS");
        String time1 = DateTime.now().toString("yyyyMMddHHmmssSSS");
        String time2 = DateTime.now().toString("yyyyMMddHHmmssSSS");
        System.out.println("-------------------"+time);

    }

}
