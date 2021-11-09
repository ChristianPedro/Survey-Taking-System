import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class SurveyManager {
    public static String basePath = FSConfig.serialDir + "surveys" + File.separator;
    public static String ResponsebasePath = FSConfig.serialDir + "response" + File.separator;
    static Survey CurrentSurvey;

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        boolean run = true;
        while (run){
            System.out.println("1) Create a new Survey\n" +
                    "2) Display an existing Survey\n" +
                    "3) Load an existing Survey\n" +
                    "4) Save the current Survey\n" +
                    "5) Take the current Survey\n" +
                    "6) Modifying the current Survey\n" +
                    "7) Quit");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "1":
                    //Completed
                    //Create new survey and add questions in menu 2
                    System.out.println("please enter a survey name.");
                    String surveyName = scanner.nextLine();
                    CurrentSurvey = new Survey(surveyName);
                    Menu2(scanner);
                    break;
                case "2":
                    //Completed display all questions properly
                    //Display an existing survey
                    if (CurrentSurvey != null) {
                        CurrentSurvey.DisplaySurvey();
                    } else {
                        System.out.println("You have to load or create a survey before trying to view it.");
                    }
                    break;
                case "3":
                    //completed
                    //Load existing survey
                    String loadedSurvey = FileUtils.listAndPickFileFromDir(basePath);
                    CurrentSurvey = SerializationHelper.deserialize(Survey.class, loadedSurvey);
                    break;
                case "4":
                    //completed
                    //Save survey
                    if (CurrentSurvey != null) {
                    SerializationHelper.serialize(Survey.class, CurrentSurvey, basePath, CurrentSurvey.surveyName + "." + "survey");
                    } else {
                        System.out.println("You have to load or create a survey before trying to save it.");
                    }
                    break;
                case"5":
                    //Completed
                    //Take survey
                    if (CurrentSurvey != null) {
                        CurrentSurvey.TakeSurvey(scanner);
                        SerializationHelper.serialize(Survey.class, CurrentSurvey, ResponsebasePath, CurrentSurvey.surveyName+ Math.floor(Math.random()*(100-1+1)+1)+"."+"answered");
                    } else {
                        System.out.println("You have to load or create a survey before trying to take it.");
                    }
                    break;
                case"6":
                    //Complete
                    //Modify survey
                    if (CurrentSurvey != null) {
                        CurrentSurvey.ModifySurvey(scanner);
                    } else {
                        System.out.println("You have to load or create a survey before trying to modify it.");
                    }
                    break;
                case"7":
                    run=false;
                    break;
                default:
                    System.out.println("Please enter a proper option number.");

            }
        }

    }
    //Completed
    private static void Menu2(Scanner scanner){
        boolean run = true;
        while (run){
            System.out.println("1) Add a new T/F question\n" +
                    "2) Add a new multiple-choice question\n" +
                    "3) Add a new short answer question\n" +
                    "4) Add a new essay question\n" +
                    "5) Add a new date question\n" +
                    "6) Add a new matching question\n" +
                    "7) Return to previous menu");
            String input = scanner.nextLine();
            switch (input.toLowerCase()){
                case "1":
                    //Completed
                    //Adds T/F question survey and asks user for the prompt and options
                    System.out.println("You chose T/F question.");
                    System.out.println("What is the question prompt?");
                    String prompt = scanner.nextLine();
                    TrueAndFalse tf = new TrueAndFalse(prompt);
                    tf.AddOption("True");
                    tf.AddOption("False");
                    CurrentSurvey.AddQuestion(tf);
                    System.out.println(CurrentSurvey.getQuestions());
                    break;

                case"2":
                    //Completed
                    //Adds Multiple choice question survey and asks user for the prompt and options
                    System.out.println("You chose Multiple Choice question.");
                    System.out.println("What is the question prompt?");
                    String MCprompt = scanner.nextLine();
                    MultipleChoice MC = new MultipleChoice(MCprompt);
                    System.out.println("how many options would you like to allow the user to pick?");
                    int number = scanner.nextInt();
                    MC.setNumberOfPossibleResponses(number);
                    scanner.nextLine();
                    MC.ChangeOptions(scanner);
                    CurrentSurvey.AddQuestion(MC);
                    System.out.println(CurrentSurvey.getQuestions());
                    break;

                case"3":
                    //Completed
                    //add new short answer question
                    System.out.println("You chose Short Answer question.");
                    System.out.println("What is the question prompt?");
                    String Shortprompt = scanner.nextLine();
                    ShortAnswer ShortAnswerObject = new ShortAnswer(Shortprompt);
                    CurrentSurvey.AddQuestion(ShortAnswerObject);
                    System.out.println(CurrentSurvey.getQuestions());
                    break;

                case"4":
                    //Completed
                    //Add new essay question
                    System.out.println("You chose Essay question.");
                    System.out.println("What is the question prompt?");
                    String Essayprompt = scanner.nextLine();
                    Essay EssayObject = new Essay(Essayprompt);
                    System.out.println("how many options would you like to allow the user to pick?");
                    int Essaynumber = scanner.nextInt();
                    scanner.nextLine();
                    EssayObject.setNumberOfPossibleResponses(Essaynumber);
                    CurrentSurvey.AddQuestion(EssayObject);
                    System.out.println(CurrentSurvey.getQuestions());
                    break;
                case"5":
                    //Completed
                    //Add new date question
                    System.out.println("You chose Date question.");
                    System.out.println("What is the question prompt?");
                    String Dateprompt = scanner.nextLine();
                    Date DateObject = new Date(Dateprompt);
                    CurrentSurvey.AddQuestion(DateObject);
                    System.out.println(CurrentSurvey.getQuestions());
                    break;
                case"6":
                    //Completed
                    //add new matching question
                    System.out.println("You chose Matching question.");
                    System.out.println("What is the question prompt?");
                    String Matchingprompt = scanner.nextLine();
                    Matching MatchingObject = new Matching(Matchingprompt);
                    System.out.println("how many options would you like to allow the user to pick?");
                    int number1 = scanner.nextInt();
                    scanner.nextLine();
                    MatchingObject.setNumberOfPossibleResponses(number1);
                    MatchingObject.ChangeOptions(scanner);
                    CurrentSurvey.AddQuestion(MatchingObject);
                    System.out.println(CurrentSurvey.getQuestions());
                    break;
                case"7":
                    run=false;
                    break;


            }
        }
    }
}
