import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String Prompt;
    ArrayList<String> Alphabet = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I"));
    ArrayList<Response> Answer = new ArrayList<Response>();
    private int NumberOfPossibleResponses = 1;

    public Question(){
    }
    public Question(String prompt){
        Prompt = prompt;
    }
    public void DisplayQuestion(){

        System.out.println(Prompt);
    }
    //Still need taking question

    public void ModifyQuestion(String UpdatedPrompt){
        Prompt = UpdatedPrompt;
    }

    public ArrayList<Response> GetAnswer(){
        return Answer;
    }

    public void SetAnswer(ArrayList<Response> answer){
        Answer = answer;
    }

    public void AddAnswer(Response answer){
        Answer.add(answer);
    }

    public void setPrompt(String prompt) {
        Prompt = prompt;
    }

    public void ChangeOptions(Scanner scanner){
        System.out.println("There are no options to change");
    }

    public int getNumberOfPossibleResponses() {
        return NumberOfPossibleResponses;
    }

    public void setNumberOfPossibleResponses(int number) {
        NumberOfPossibleResponses = number;
    }
}
