package link.imcloud.jrs.db.mapper;

import link.imcloud.jrs.db.entities.TBModel;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public interface ModelMapper {
    TBModel getModelByUser(String user);
    void insertModel(TBModel model);
    void updateModelByUser(TBModel model);
}
