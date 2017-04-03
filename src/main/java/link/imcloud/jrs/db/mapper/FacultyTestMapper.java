package link.imcloud.jrs.db.mapper;

import link.imcloud.jrs.db.entities.TBFacultyTest;
import link.imcloud.jrs.db.entities.TBModel;

import java.util.List;

/**
 * Created by 44247 on 2016/11/19 0019.
 */
public interface FacultyTestMapper {
    List<TBFacultyTest> getTestByType(Integer type);
    TBFacultyTest getTestById(Integer testId);
}
