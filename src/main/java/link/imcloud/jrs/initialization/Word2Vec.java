package link.imcloud.jrs.initialization;

import link.imcloud.jrs.resume.process.GenerateWordVec;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by 44247 on 2017/3/23 0023.
 */

public class Word2Vec {
    protected Logger logger=Logger.getLogger("Word2Vec");


    @Test
    public  void convert() throws IOException {
        logger.info("Task start");
        GenerateWordVec generateWordVec=new GenerateWordVec();
        generateWordVec.cerateWordVec(new File("D:\\study\\project\\Competetion\\职位推荐系统\\jobsDescription20170322063758.txt"),"D:\\study\\project\\Competetion\\职位推荐系统\\wordvectmodel00.txt");
    }
}
