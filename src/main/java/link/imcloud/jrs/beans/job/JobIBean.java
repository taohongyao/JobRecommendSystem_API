package link.imcloud.jrs.beans.job;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public class JobIBean {
    private String jobId;
    private String jobName;
    private String funtype;

    public String getFuntype() {
        return funtype;
    }

    public void setFuntype(String funtype) {
        this.funtype = funtype;
    }

    private int pageSize = 10;

    private int pageNum = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
