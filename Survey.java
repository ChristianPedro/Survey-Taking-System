import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Survey implements Serializable{
    public String surveyName = "";
    ArrayList<Question> Questions = new ArrayList<Question>();
    private static final long serialVersionUID = 1L;

    public Survey(String SurveyName){
        surveyName = SurveyName;
    }
    public void AddQuestion(Question Element){
        Questions.add(Element);
    }

    public ArrayList<Question> getQuestions() {
        return Questions;
    }
    //Needs to be finished and talk to Andrew about if I should do the I/O in here or in the main
    public void DisplaySurvey(){
        for (int i = 0; i < Questions.size(); i++) {
            System.out.print((i + 1) + ". ");
            Questions.get(i).DisplayQuestion();
            System.out.println("\n");
        }
    }
    public void ModifySurvey(Scanner scanner){


        System.out.println("Which question would you like to modify?");
        int input = scanner.nextInt();
        scanner.nextLine();
        if (input > Questions.size()){
            System.out.println("you cannot modify this question, it does not exist");
            return;
        }
        Questions.get(input-1).DisplayQuestion();
        System.out.println("would you like to modify the prompt? (type 'yes' if you would)");
        String input2 = scanner.nextLine();
        if (input2.equalsIgnoreCase("yes")){
            System.out.println("Please type the new question prompt.");
            String newPrompt = scanner.nextLine();
            Questions.get(input-1).setPrompt(newPrompt);
        } else if (input2.equalsIgnoreCase("no")){
            System.out.println("would you like to modify the answers? (type 'yes' if you would)");
            String input3 = scanner.nextLine();
            if (input3.equalsIgnoreCase("yes")){
                Questions.get(input-1).ChangeOptions(scanner);
            }
        } else {
            System.out.println("invalid input returning to menu");
        }



    }

    public void TakeSurvey(Scanner scanner){
        for (int i = 0; i < Questions.size(); i++) {
            Questions.get(i).DisplayQuestion();

            for (int j=0; j< Questions.get(i).getNumberOfPossibleResponses(); j++) {
                System.out.println("you are allowed " + Questions.get(i).getNumberOfPossibleResponses() + " answers to this question");
                String answer = scanner.nextLine();
                Response userResponse = new Response(answer);
                Questions.get(i).AddAnswer(userResponse);

            }
            if (Questions.size() <= i++){
                    break;
                }

        }
    }
}
