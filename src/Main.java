import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Welcome to Rock Paper Scissors!");
	    System.out.println("To Start, enter \"rock\" \"paper\" or \"scissors\" below. Enter \"quit\" to quit the game");
        Scanner in = new Scanner(System.in);
        String input;

        do {
            System.out.print("> ");
            input = in.next();

            //Quit the game
            if(input.equals("quit"))
                break; //stops while loop

            //check input
            else if(!input.equals("rock") && !input.equals("paper") && !input.equals("scissors")){
                System.out.println("Not a valid Choice. Try Again");
            }
            //do something with input
            else{
                String computer = random();
                //As long as it's not a tie, play the game
                if(!computer.equals(input)) {
                    boolean userWin = whoWin(input, computer);
                    if (userWin)
                        System.out.println("You Won!");
                    else
                        System.out.println("You Lost :(");
                }
                else
                    System.out.println("It's a tie!");
            }
        }
        while(true);
    }

    public static String random(){
        int randNum = (int) (Math.random() * 3);
        String thing;
        switch (randNum){
            case 0:
                thing = "rock";
                break;
            case 1:
                thing = "paper";
                break;
            default:
                thing = "scissors";
                break;
        }
        System.out.println("The Computer chose: " + thing);
        return thing;
    }
    public static boolean whoWin(String input, String computer){
        return (!input.equals("scissors") || !computer.equals("rock")) &&
                (!input.equals("paper") || !computer.equals("scissors")) &&
                (!input.equals("rock") || !computer.equals("paper"));
    }
}
