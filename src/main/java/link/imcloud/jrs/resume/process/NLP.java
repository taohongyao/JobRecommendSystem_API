package link.imcloud.jrs.resume.process;


import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by 44247 on 2017/3/20 0020.
 */

public class NLP {

    protected Logger logger=Logger.getLogger("NLP");

    // 构建IK分词器，使用smart分词模式-
    private Analyzer analyzer = new IKAnalyzer(true);

    /**
     * 词频统计
     *
     */
    public List<FrequenceItem>  statisticWord (String str) {
        // 获取Lucene的TokenStream对象
        TokenStream ts = null;
        ArrayList<FrequenceItem> list = new ArrayList<FrequenceItem>();
        try {
            ts = analyzer.tokenStream("myfield", new StringReader(str));
            // 获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            // 获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            // 获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);

            // 重置TokenStream（重置StringReader）
            ts.reset();
            // 迭代获取分词结果

            HashMap<String,Integer> map=new HashMap<String, Integer>();

            while (ts.incrementToken()) {
                if (map.containsKey(term.toString())){
                    map.put(term.toString(),map.get(term.toString())+1);
                }else {
                    map.put(term.toString(),1);
                }

//                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : "
//                        + term.toString() + " | " + type.type());
            }




            for(String key:map.keySet()){
                list.add(new FrequenceItem(map.get(key),key));
            }

            sort(list,0,list.size()-1);
            // 关闭TokenStream（关闭StringReader）
            ts.end(); // Perform end-of-stream operations, e.g. set the final offset.

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放TokenStream的所有资源
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }

    }

    public String  separate(String senternce) {


        // 获取Lucene的TokenStream对象
        TokenStream ts = null;
        StringBuilder str=new StringBuilder();;
        try {
            ts = analyzer.tokenStream("myfield", new StringReader(senternce));
            // 获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            // 获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            // 获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);

            // 重置TokenStream（重置StringReader）
            ts.reset();
            // 迭代获取分词结果


            while (ts.incrementToken()) {
                str.append(term.toString()+" ");
//                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : "
//                        + term.toString() + " | " + type.type());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放TokenStream的所有资源
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return str.toString();
        }
    }


    public static void sort(ArrayList<FrequenceItem> a, int low, int high){
        int start = low;
        int end = high;
        int key = a.get(low).getFrequence();


        while(end>start){
            //从后往前比较
            while(end>start&&a.get(end).getFrequence()<=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a.get(end).getFrequence()>=key){
                FrequenceItem temp = a.get(end);
                a.set(end,a.get(start));
                a.set(start, temp);
            }
            //从前往后比较
            while(end>start&&a.get(start).getFrequence()>=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a.get(start).getFrequence()<=key){
                FrequenceItem temp = a.get(start);
                a.set(start,a.get(end));
                a.set(end, temp);
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

}
