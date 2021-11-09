import java.io.Serializable;

public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    public String Answer;

    public Response(){

    }

    public Response(String answer){
        Answer = answer;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

}
