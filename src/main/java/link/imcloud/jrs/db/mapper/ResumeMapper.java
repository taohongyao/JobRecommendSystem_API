package link.imcloud.jrs.db.mapper;

import link.imcloud.jrs.db.entities.TBResume;

import java.util.List;

/**
 * Created by 44247 on 2016/11/19 0019.
 */
public interface ResumeMapper {
    List<TBResume> getTBResumeByUser(String account);

    void insertTBResume(TBResume tbResume);

}
