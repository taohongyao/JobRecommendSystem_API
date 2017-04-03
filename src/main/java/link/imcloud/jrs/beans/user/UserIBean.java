package link.imcloud.jrs.beans.user;


import link.imcloud.jrs.beans.IBeanOperation;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
public class UserIBean extends IBeanOperation {
    private String oldPassword;
    private String newPassword;
    private String password;
    private String nickname;
    private String phone;
    private String smsCode;
    private String email;
    private String sex;
    private String area;
    private String photo;

    //二期
    private String birthday;
    private String realname;
    private String major;
    private String married;
    private String educational_level;
    private String expect_salary;
    private String expect_place;
    private String expect_companytype;
    private String expect_funtype;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getEducational_level() {
        return educational_level;
    }

    public void setEducational_level(String educational_level) {
        this.educational_level = educational_level;
    }

    public String getExpect_salary() {
        return expect_salary;
    }

    public void setExpect_salary(String expect_salary) {
        this.expect_salary = expect_salary;
    }

    public String getExpect_place() {
        return expect_place;
    }

    public void setExpect_place(String expect_place) {
        this.expect_place = expect_place;
    }

    public String getExpect_companytype() {
        return expect_companytype;
    }

    public void setExpect_companytype(String expect_companytype) {
        this.expect_companytype = expect_companytype;
    }

    public String getExpect_funtype() {
        return expect_funtype;
    }

    public void setExpect_funtype(String expect_funtype) {
        this.expect_funtype = expect_funtype;
    }
}
