package link.imcloud.jrs.db.entities;

/**
 * Created by 44247 on 2016/11/19 0019.
 */
public class TBFacultyTest {
    private Integer questionId;
    private String questionContext;
    private String selectionOne;
    private String selectionTwo;
    private String selectionThree;
    private String selectionFour;
    private String answer;
    private Integer questionType;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContext() {
        return questionContext;
    }

    public void setQuestionContext(String questionContext) {
        this.questionContext = questionContext;
    }

    public String getSelectionOne() {
        return selectionOne;
    }

    public void setSelectionOne(String selectionOne) {
        this.selectionOne = selectionOne;
    }

    public String getSelectionTwo() {
        return selectionTwo;
    }

    public void setSelectionTwo(String selectionTwo) {
        this.selectionTwo = selectionTwo;
    }

    public String getSelectionThree() {
        return selectionThree;
    }

    public void setSelectionThree(String selectionThree) {
        this.selectionThree = selectionThree;
    }

    public String getSelectionFour() {
        return selectionFour;
    }

    public void setSelectionFour(String selectionFour) {
        this.selectionFour = selectionFour;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }
}
