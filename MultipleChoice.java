import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<String> Options = new ArrayList<String>();


    public MultipleChoice(){
        super();
    }

    public MultipleChoice( String prompt){
        super(prompt);
    }

    public void AddOption(String option){
        Options.add(option);
    }

    @Override
    public void DisplayQuestion() {
        System.out.print(Prompt + "\n");

        for (int i = 0; i < Options.size(); i++) {
            System.out.print( Alphabet.get(i)+". "+Options.get(i) + "       ");
        }
        System.out.println("\n");
    }

    @Override
    public void ChangeOptions(Scanner scanner) {
        String MCAnswerPrompt = "";
        Options.clear();
        while (!MCAnswerPrompt.equalsIgnoreCase("quit")){
            System.out.println("What options would you like to provide the survey user?");
            System.out.println("Enter 'quit' to stop adding options");
            MCAnswerPrompt = scanner.nextLine();
            if (MCAnswerPrompt.equalsIgnoreCase("quit")){
                break;
            }
            AddOption(MCAnswerPrompt);
        }
    }



    public ArrayList<String> getOptions() {
        return Options;
    }
}
