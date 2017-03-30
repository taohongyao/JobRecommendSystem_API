package link.imcloud.jrs.pool.register;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
public class RegisterPoolBean {
    private String smsCode;
    private long vaild;

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public long getVaild() {
        return vaild;
    }

    public void setVaild(long vaild) {
        this.vaild = vaild;
    }
}
