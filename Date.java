import java.io.Serializable;

public class Date extends Question implements Serializable {
    private static final long serialVersionUID = 1L;
    public String dateFormat = "MM-DD-YYYY";
    private String DateAnswer;

    public Date(){
        super();
    }
    public Date(String prompt){
      super(prompt);
    }

    public String getDateAnswer() {
        return DateAnswer;
    }
    public void setDateAnswer(String date){
        DateAnswer = date;
    }

    @Override
    public void DisplayQuestion() {
        super.DisplayQuestion();
        System.out.println("A date should be entered in the following format: " + dateFormat);
    }
}
