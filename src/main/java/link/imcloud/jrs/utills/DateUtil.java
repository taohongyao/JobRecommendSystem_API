package link.imcloud.jrs.utills;

import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by 44247 on 2016/7/26 0026.
 */
public class DateUtil {
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");

    public static String getDateFormat(Date date){
        return simpleDateFormat.format(date);
    }

    /**
     * 获取 yyyyMMddhhmmss
     * @return
     */
    public static String getDateFormatByNowDate(){
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    /**
     * 获得当前时间的 前minute分（后minute分） 的时间串
     * @param minute
     * @return
     */
    public static String getDateFormatByControlMinute(int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        calendar.add(Calendar.MINUTE, minute);
        return simpleDateFormat.format(calendar.getTimeInMillis());
    }

    /**
     * 获得当前时间的 前minute分（后hour分） 的时间串
     * @param hour
     * @return
     */
    public static String getDateFormatByControlHour(int hour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        calendar.add(Calendar.HOUR, hour);
        return simpleDateFormat.format(calendar.getTimeInMillis());
    }
    public static String getCurrentTimeSecond(){
        int currenttime= (int) (System.currentTimeMillis()/1000);
        return ""+currenttime;
    }
    @Test
    public void test(){

        System.out.println(getCurrentTimeSecond());
    }
}
