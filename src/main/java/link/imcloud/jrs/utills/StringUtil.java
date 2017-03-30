package link.imcloud.jrs.utills;

import java.util.Random;

/**
 * Created by 44247 on 2016/7/24 0024.
 */
public class StringUtil {
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomNumber(int length) { //length表示生成字符串的长度
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String generateOutTradeNo(int length){
        if(length>=14)
        return DateUtil.getDateFormatByNowDate()+getRandomString(length-14);
        return DateUtil.getDateFormatByNowDate()+getRandomString(6);
    }
}
