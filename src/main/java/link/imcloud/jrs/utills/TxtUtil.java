package link.imcloud.jrs.utills;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.*;

/**
 * Created by 44247 on 2017/3/21 0021.
 */
public class TxtUtil {

    @Test
    public void test() throws Exception {
        TxtUtil txtUtil=new TxtUtil();
        File text1=new File("web\\WEB-INF\\TXTUtileTest.txt");
        txtUtil.createFile(text1);
        txtUtil.writeTxtFile("hahaha",text1,true);
        txtUtil.writeTxtFile("hahaha",text1,true);
    }

    /**
     * 创建文件
     * @param fileName
     * @return
     */
    public static boolean createFile(File fileName)throws Exception{
        boolean flag=false;
        try{
            if(!fileName.exists()){
                fileName.createNewFile();
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Logger logger=Logger.getLogger("TxtUtil");
        logger.info(fileName.getAbsolutePath());
        return true;
    }

    /**
     * 读TXT文件内容
     * @param fileName
     * @return
     */
    public static String readTxtFile(File fileName)throws Exception{
        String result=null;
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try{
            fileReader=new FileReader(fileName);
            bufferedReader=new BufferedReader(fileReader);
            try{
                String read=null;
                while((read=bufferedReader.readLine())!=null){
                    result=result+read+"\r\n";
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(fileReader!=null){
                fileReader.close();
            }
        }
        System.out.println("读取出来的文件内容是："+"\r\n"+result);
        return result;
    }


    public static boolean writeTxtFile(String content,File fileName,boolean append)throws Exception{
        RandomAccessFile mm=null;
        boolean flag=false;
        FileOutputStream o=null;
        try {
            o = new FileOutputStream(fileName,append);
            o.write(content.getBytes("UTF-8"));
            o.close();
            flag=true;
        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            if(mm!=null){
                mm.close();
            }
        }
        return flag;
    }
}
