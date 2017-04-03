package link.imcloud.jrs.services;

import com.mysql.jdbc.log.LogUtils;
import link.imcloud.jrs.db.entities.TBModel;
import link.imcloud.jrs.db.entities.TBResume;
import link.imcloud.jrs.db.mapper.ModelMapper;
import link.imcloud.jrs.db.mapper.ResumeMapper;
import link.imcloud.jrs.utills.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
@Service
public class ResumeService {
    @Resource
    protected ResumeMapper resumeMapper;
    @Resource
    protected ModelMapper modelMapper;

    protected Logger logger=Logger.getLogger(LogUtils.class);

    public void insertResume(TBResume resume){
        resume.setUpdateTime(DateUtil.getDateFormatByNowDate());
        // TODO: 2017/4/3 0003 处理简历
        //处理简历
        //更新用户模型

        resumeMapper.insertTBResume(resume);
    }

    public TBResume getResumeByUser(String account){
        List<TBResume> list=resumeMapper.getTBResumeByUser(account);
        return list.get(0);
    }

}
