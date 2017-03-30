package link.imcloud.jrs.initialization;

import link.imcloud.jrs.services.SMSService;
import link.imcloud.jrs.utills.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 44247 on 2017/3/23 0023.
 */
@Component
public class Word2VecThread extends Thread{
    @Resource
    protected SMSService smsService;
    protected Logger logger=Logger.getLogger("Word2Vec");
    public void run() {
        try{
            logger.info("Word2Vec 线程已开启");
            Word2Vec word2Vec=new Word2Vec();
            word2Vec.convert();
            smsService.sentSMS("15927649590","The task of converting into vec is completed.("+ DateUtil.getDateFormatByNowDate()+")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
