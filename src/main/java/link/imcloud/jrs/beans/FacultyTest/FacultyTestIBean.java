package link.imcloud.jrs.beans.FacultyTest;

import link.imcloud.jrs.beans.IBeanOperation;
import link.imcloud.jrs.db.entities.TBFacultyTest;

import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public class FacultyTestIBean extends IBeanOperation {
    List<TBFacultyTest> list;

    public List<TBFacultyTest> getList() {
        return list;
    }

    public void setList(List<TBFacultyTest> list) {
        this.list = list;
    }
}
