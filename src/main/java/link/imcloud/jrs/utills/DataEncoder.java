package link.imcloud.jrs.utills;

import com.mysql.jdbc.log.LogUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Map;

/**
 * Created by 44247 on 2016/7/23 0023.
 */
public class DataEncoder {
    /*
    * @param 待输入字符串
    * @return 返回加密MD5
    * */
    public static String getMD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = new byte[0];
        try {
            byteArray = inStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /*
    * @param 待输入字符串
    * @return 返回加密SHA1
    * */
    public static String getSHA1(String inStr) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = new byte[0];
        try {
            byteArray = inStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 自动过滤掉sign字段，sign的值不会放入签名计算
     * @param entity
     * @param key
     * @return
     */
    public static String getSign(Map<String,String> entity,String key){
        StringBuffer str1=new StringBuffer();
        for(String entityKey:entity.keySet()){
            String value=entity.get(entityKey);
            if(entityKey.equals("sign")||value==null) continue;
            str1.append(entityKey+"="+value+"&");
        }
        str1.append("key="+key);
        Logger.getLogger(LogUtils.class).debug("sign:"+str1.toString());
        return  getMD5(str1.toString()).toUpperCase();
    }
}
