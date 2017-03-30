package link.imcloud.jrs.initialization;

import com.mysql.jdbc.log.LogUtils;

import link.imcloud.jrs.services.SMSService;
import link.imcloud.jrs.utills.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by 44247 on 2017/3/21 0021.
 */

@Component
public class WriteJobs2FileThread extends Thread{
    @Resource
    protected WriteJobs2File writeJobs2File;
    @Resource
    protected SMSService smsService;
    protected Logger logger=Logger.getLogger("WriteJobs2FileThread");
    public void run() {
        try{
            logger.info("WriteJobs2File 线程已开启");
            writeJobs2File.writer();
            smsService.sentSMS("15927649590","The task of converting into text is completed.("+ DateUtil.getDateFormatByNowDate()+")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
