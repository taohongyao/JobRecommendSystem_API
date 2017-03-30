package link.imcloud.jrs.initialization;

import com.mysql.jdbc.TimeUtil;
import com.mysql.jdbc.log.LogUtils;
import link.imcloud.jrs.beans.job.Pager;
import link.imcloud.jrs.db.dao.JobDao;
import link.imcloud.jrs.db.entities.MGJobItem;
import link.imcloud.jrs.resume.process.NLP;
import link.imcloud.jrs.services.SMSService;
import link.imcloud.jrs.utills.DateUtil;
import link.imcloud.jrs.utills.TxtUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by 44247 on 2017/3/21 0021.
 */
@Component
public class WriteJobs2File {
    @Resource
    protected JobDao jobDao;

    protected Logger logger=Logger.getLogger("WriteJobs2File");

    public  void writer( ) {
        File jobsDescriptionFile=new File ("jobsDescription"+ DateUtil.getDateFormatByNowDate()+".txt");
        NLP nlp=new NLP();
        Pager pager=new Pager();
        pager.setPageSize(100);
        pager.setPageNum(0);
        int jobsCounte=(int)Math.ceil(jobDao.getAllCounte()/(double)pager.getPageSize());

        String lastOfPageOId="57164204e138234f824ccf30"; //初始序列
        try {
            TxtUtil txtUtil=new TxtUtil();
            txtUtil.createFile(jobsDescriptionFile);
            FileWriter fw = new FileWriter(jobsDescriptionFile);
            List<MGJobItem> jobs=jobDao.selectGroupByFirstObjectId(lastOfPageOId,pager.getPageSize());
            while (jobs.size()!=0){
                pager.setPageNum(pager.getPageNum()+1);
                for(MGJobItem job:jobs){
                    lastOfPageOId=job.get_id();
                    fw.write(nlp.separate(job.getJob_name())+" ");
                    for(String description:job.getJob_description()){
                        fw.write(nlp.separate(description)+" ");
                    }
                    fw.write("\n");
                }
                logger.info("[Write Jobsfile Info] "+pager.getPageNum()+"/"+jobsCounte+" ["+String.format("%.2f",100*pager.getPageNum()/(double)jobsCounte)+"%]");
                jobs=jobDao.selectGroupByFirstObjectId(lastOfPageOId,pager.getPageSize());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
