package link.imcloud.jrs.db.mapper;

import link.imcloud.jrs.db.entities.TBArea;
import link.imcloud.jrs.db.entities.TBFacultyTest;
import link.imcloud.jrs.db.entities.TBFuntype;

import java.util.List;

/**
 * Created by 44247 on 2016/11/19 0019.
 */
public interface FunTypeMapper {
    List<TBFuntype> getAllFunTypes();
}
