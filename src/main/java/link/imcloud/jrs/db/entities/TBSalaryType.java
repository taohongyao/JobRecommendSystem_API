package link.imcloud.jrs.db.entities;

/**
 * Created by 44247 on 2017/4/3 0003.
 */
public class TBSalaryType {
    private String  salaryTypeId;
    private int max;
    private int min;
    private String salaryTypeName;

    public String getSalaryTypeId() {
        return salaryTypeId;
    }

    public void setSalaryTypeId(String salaryTypeId) {
        this.salaryTypeId = salaryTypeId;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getSalaryTypeName() {
        return salaryTypeName;
    }

    public void setSalaryTypeName(String salaryTypeName) {
        this.salaryTypeName = salaryTypeName;
    }
}
