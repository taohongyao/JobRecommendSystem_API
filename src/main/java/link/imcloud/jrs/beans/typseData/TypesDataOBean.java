package link.imcloud.jrs.beans.typseData;

import link.imcloud.jrs.db.entities.*;

import java.util.List;

/**
 * Created by 44247 on 2017/4/3 0003.
 */
public class TypesDataOBean {
    private List<TBArea> areas;
    private List<TBMarriedType>  marriedTypes;
    private List<TBMajorType> majorTypes;
    private List<TBEducationType> educationTypes;
    private List<TBFuntype> funtypes;
    private List<TBCompanyType> companyTypes;
    private List<TBSalaryType> salaryTypes;

    public List<TBArea> getAreas() {
        return areas;
    }

    public void setAreas(List<TBArea> areas) {
        this.areas = areas;
    }

    public List<TBMarriedType> getMarriedTypes() {
        return marriedTypes;
    }

    public void setMarriedTypes(List<TBMarriedType> marriedTypes) {
        this.marriedTypes = marriedTypes;
    }

    public List<TBMajorType> getMajorTypes() {
        return majorTypes;
    }

    public void setMajorTypes(List<TBMajorType> majorTypes) {
        this.majorTypes = majorTypes;
    }

    public List<TBEducationType> getEducationTypes() {
        return educationTypes;
    }

    public void setEducationTypes(List<TBEducationType> educationTypes) {
        this.educationTypes = educationTypes;
    }

    public List<TBFuntype> getFuntypes() {
        return funtypes;
    }

    public void setFuntypes(List<TBFuntype> funtypes) {
        this.funtypes = funtypes;
    }

    public List<TBCompanyType> getCompanyTypes() {
        return companyTypes;
    }

    public void setCompanyTypes(List<TBCompanyType> companyTypes) {
        this.companyTypes = companyTypes;
    }

    public List<TBSalaryType> getSalaryTypes() {
        return salaryTypes;
    }

    public void setSalaryTypes(List<TBSalaryType> salaryTypes) {
        this.salaryTypes = salaryTypes;
    }
}
