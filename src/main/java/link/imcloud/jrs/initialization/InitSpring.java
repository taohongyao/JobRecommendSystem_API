package link.imcloud.jrs.initialization;

import link.imcloud.jrs.resume.process.GenerateWordVec;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by 44247 on 2017/3/21 0021.
 */
@Component
public class InitSpring implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    WriteJobs2FileThread writeJobs2FileTaskThread;
    @Resource
    Word2VecThread word2VecTaskThread;
    protected Logger logger=Logger.getLogger("InitSpring");

    public void onApplicationEvent(ContextRefreshedEvent event) {
//        writeJobs2FileTaskThread.start();
//        word2VecTaskThread.start();
    }
}
