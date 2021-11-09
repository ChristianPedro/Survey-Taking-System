import java.util.ArrayList;
import java.util.Scanner;

public class Matching extends Question{
    ArrayList<String> LeftColumn = new ArrayList<String>();
    ArrayList<String> RightColumn = new ArrayList<String>();
    public int LeftCount = 0;
    public int RightCount = 0;


    public Matching() {
        super();
    }

    public Matching(String prompt){
        super(prompt);
    }

    public void InsertLeft(String Element){
        LeftColumn.add(Element);
        LeftCount++;
    }

    public void InsertRight(String Element){
        RightColumn.add(Element);
        RightCount++;
    }

    public ArrayList<String> GetLeft(){
        return LeftColumn;
    }

    public ArrayList<String> GetRight(){
        return RightColumn;
    }

    public int getLeftCount(){
        return LeftCount;
    }

    public int getRightCount(){
        return RightCount;
    }

    @Override
    public void DisplayQuestion() {
        super.DisplayQuestion();

        for (int i = 0; i < getLeftCount(); i++) {
            System.out.printf( "%2s. %-20s %2d. %s \n", Alphabet.get(i), GetLeft().get(i), (i+1), GetRight().get(i));
        }
    }
    @Override
    public void ChangeOptions(Scanner scanner){
        String MatchingAnswerPrompt = "-";
        LeftColumn.clear();
        RightColumn.clear();
        LeftCount = 0;
        RightCount = 0;
        while (!MatchingAnswerPrompt.equals("next")){
            System.out.println("What options would you like to add to the left side?");
            System.out.println("Enter 'next' to stop adding to the left column and start adding to the right column.");
            MatchingAnswerPrompt = scanner.nextLine();
            if (MatchingAnswerPrompt.equalsIgnoreCase("next")){
                break;
            }
            InsertLeft(MatchingAnswerPrompt);
        }
        while (!MatchingAnswerPrompt.equals("end")){
            System.out.println("What options would you like to add to the right side?");
            System.out.println("Enter 'end' to stop adding to the right column.");
            MatchingAnswerPrompt = scanner.nextLine();
            if (MatchingAnswerPrompt.equalsIgnoreCase("end")){
                break;
            }
            InsertRight(MatchingAnswerPrompt);
        }
    }


}
