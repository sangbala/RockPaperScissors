package com.mycompany.rockpaperscissors;

import java.util.*;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfRound = 0;
        //check if input is >=1 &&<=10
        boolean isValid = false;

        boolean playAgain = false;

        do {

            try {
                System.out.println("Please enter how many rounds you would like to play");
                String input = sc.nextLine();
                numberOfRound = Integer.parseInt(input);
                if (numberOfRound >= 1 && numberOfRound <= 10) {
                    isValid = true;
                } else {
                    System.out.println("Input must be between 1 and 10");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number");
            }

            //variable for result
            int win = 0, tie = 0, loss = 0;

            if (isValid == true) {

                for (int i = 0; i < numberOfRound; i++) {

                    boolean inputIsValid = false;
                    String choice = "";
                    int choiceInt = 0;
                    do {

                        System.out.println("What's your choice? 1 = Rock, 2 = Paper, 3 = Scissors");
                        choice = sc.nextLine();
                        choiceInt = Integer.parseInt(choice);
                        if (choiceInt == 1 || choiceInt == 2 || choiceInt == 3) {
                            inputIsValid = true;
                        } else {
                            System.out.println("Selection is not recognized. Please select again: 1 = Rock, 2 = Paper, 3 = Scissors");
                        }

                    } while (!inputIsValid);

                    Random rng = new Random();
                    int comChoice = rng.nextInt(3) + 1;
                    System.out.println(comChoice);
                    if (comChoice - choiceInt == 0) {
                        tie++;
                        System.out.println("This round: Tie");
                    } else if (choiceInt - comChoice == -2 || choiceInt - comChoice == 1) {
                        win++;
                        System.out.println("This round: You won");
                    } else {
                        loss++;
                        System.out.println("This round: You lost");
                    }

                }//end for loop

                System.out.println("Result: games you won: " + win + "; " + " games you lost: " + loss + "; " + " games tied: " + tie + ";");
                if (win > loss) {
                    System.out.println("You are the winner.");
                } else if (win < loss) {
                    System.out.println("The computer is the winner.");
                } else {
                    System.out.println("It is a tie");
                }
            }

            System.out.println("Would you like to play again?  1 for yes; anything else for no");
            String input = sc.nextLine();
            int inputInt = Integer.parseInt(input);
            if (inputInt == 1) {
                playAgain = true;
            } else {
                System.out.println("Thank you for playing.");
                playAgain = false;
            }

        } while (playAgain);

    }//main 

}
