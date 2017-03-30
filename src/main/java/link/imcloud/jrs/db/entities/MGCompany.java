package link.imcloud.jrs.db.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public class MGCompany implements Serializable {


    private static final long serialVersionUID = 492333726081863348L;

    private String scale;
    private List<String> description;
    private String industry;
    private String company_id;
    private String location;
    private String type;
    private String name;

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
