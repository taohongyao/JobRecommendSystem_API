package link.imcloud.jrs.db.entities;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public class TBModel {
    private String userAccount;
    private Integer modelId;
    private String modelOne;
    private String modelTwo;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelOne() {
        return modelOne;
    }

    public void setModelOne(String modelOne) {
        this.modelOne = modelOne;
    }

    public String getModelTwo() {
        return modelTwo;
    }

    public void setModelTwo(String modelTwo) {
        this.modelTwo = modelTwo;
    }
}
