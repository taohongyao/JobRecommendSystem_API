package link.imcloud.jrs.resume.process;

/**
 * Created by 44247 on 2017/3/20 0020.
 */
public class FrequenceItem {
    private int frequence;
    private String item;

    public FrequenceItem(int frequence, String item) {
        this.frequence = frequence;
        this.item = item;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "[" +
                frequence +
                " : " + item +
                ']';
    }
}
