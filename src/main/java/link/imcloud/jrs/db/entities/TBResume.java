package link.imcloud.jrs.db.entities;

/**
 * Created by 44247 on 2016/11/19 0019.
 */
public class TBResume {
    private Integer resumeId;
    private String resumeContext;
    private String userAccount;
    private String updateTime;

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeContext() {
        return resumeContext;
    }

    public void setResumeContext(String resumeContext) {
        this.resumeContext = resumeContext;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
