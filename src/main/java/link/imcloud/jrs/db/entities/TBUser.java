package link.imcloud.jrs.db.entities;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
public class TBUser {
    private String account;
    private String password;
    private String nickname;
    private String phone;
    private String photo;
    private String email;
    private String sex;
    private String area;

    //二期加入
    private String birthday;
    private String realname;
    private String major;
    private String married;
    private String educationalLevel;
    private String expectSalary;
    private String expectPlace;
    private String expectCompanytype;
    private String expectFuntype;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(String expectSalary) {
        this.expectSalary = expectSalary;
    }

    public String getExpectPlace() {
        return expectPlace;
    }

    public void setExpectPlace(String expectPlace) {
        this.expectPlace = expectPlace;
    }

    public String getExpectCompanytype() {
        return expectCompanytype;
    }

    public void setExpectCompanytype(String expectCompanytype) {
        this.expectCompanytype = expectCompanytype;
    }

    public String getExpectFuntype() {
        return expectFuntype;
    }

    public void setExpectFuntype(String expectFuntype) {
        this.expectFuntype = expectFuntype;
    }
}
