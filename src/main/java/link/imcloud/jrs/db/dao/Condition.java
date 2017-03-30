package link.imcloud.jrs.db.dao;

/**
 * Created by 44247 on 2017/3/19 0019.
 */
public class Condition {
    private String field;
    private String value;
    private int regex=0;

    public Condition() {
    }

    public Condition(String field, String value, int regex) {
        this.field = field;
        this.value = value;
        this.regex = regex;
    }

    public int getRegex() {
        return regex;
    }

    public void setRegex(int regex) {
        this.regex = regex;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
