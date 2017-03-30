package link.imcloud.jrs.db.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public class MGJobItem implements Serializable {
    private static final long serialVersionUID = 7410841403789212239L;
    private String _id;
    private String salary;
    private String issue_date;
    private String job_id;
    private String url;
    private MGCompany company;
    private String company_type;
    private String recruitment_info;
    private String job_tag;
    private String funtype;
    private String company_location;
    private List<String> job_description;
    private String work_place;
    private String job_name;
    private String company_name;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MGCompany getCompany() {
        return company;
    }

    public void setCompany(MGCompany company) {
        this.company = company;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getRecruitment_info() {
        return recruitment_info;
    }

    public void setRecruitment_info(String recruitment_info) {
        this.recruitment_info = recruitment_info;
    }

    public String getJob_tag() {
        return job_tag;
    }

    public void setJob_tag(String job_tag) {
        this.job_tag = job_tag;
    }

    public String getFuntype() {
        return funtype;
    }

    public void setFuntype(String funtype) {
        this.funtype = funtype;
    }

    public String getCompany_location() {
        return company_location;
    }

    public void setCompany_location(String company_location) {
        this.company_location = company_location;
    }

    public List<String> getJob_description() {
        return job_description;
    }

    public void setJob_description(List<String> job_description) {
        this.job_description = job_description;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
