import java.util.Scanner;
import java.util.Random;
public class Craps {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        boolean loop = true;
        do {
            System.out.print("Roll the dice? (Y/n): ");
            String userChoice = in.nextLine();
            if(userChoice.equals("Y")) {
                int die1 = rnd.nextInt(6)+1;
                int die2 = rnd.nextInt(6)+1;
                int dieSum = die1 + die2;
                if(dieSum == 7 || dieSum == 11) {
                    System.out.println("You landed "+die1+" and "+die2+" making "+dieSum+".\nYou won with the game with a natural.");
                }
                else if(dieSum == 2 || dieSum == 3 || dieSum == 12) {
                    System.out.println("You landed "+die1+" and "+die2+" making "+dieSum+".\nYou crapped out.");
                }
                else {
                    System.out.print("You landed "+die1+" and "+die2+" making "+dieSum+".\nThe point is now set to "+dieSum+".\nEnter to try for the point. ");
                    boolean loopPoint = true;
                    do {
                        String pointTry = in.nextLine();
                        if(pointTry.equals("")) {
                            loopPoint = false;
                            boolean pointMade = false;
                            while(!pointMade) {
                                int pointDie1 = rnd.nextInt(6)+1;
                                int pointDie2 = rnd.nextInt(6)+1;
                                int pointDieSum = pointDie1 + pointDie2;
                                if(pointDieSum == dieSum) {
                                    System.out.println("You landed "+pointDie1+" and "+pointDie2+" making "+pointDieSum+".\nYou made the point.\n");
                                    pointMade = true;
                                }
                                else if(pointDieSum == 7) {
                                    System.out.println("You landed "+pointDie1+" and "+pointDie2+" making "+pointDieSum+".\nSeven out loss.");
                                    pointMade = true;
                                }
                                else {
                                    System.out.print("You landed "+pointDie1+" and "+pointDie2+" making "+pointDieSum+".\nHit Enter to try again for the point. ");
                                    boolean nestedLoopPoint = true;
                                    do {
                                        String nestedPointTry = in.nextLine();
                                        if(nestedPointTry.equals("")) {
                                            nestedLoopPoint = false;
                                        }
                                        else {
                                            System.out.print("Invalid Input. Simply press the Enter key on your keyboard.\nOn the other hand, if you tried to quit, you cannot do so now - you must keep playing until you either hit a 7 and lose, or make the point and win.");
                                        }
                                    }
                                    while(nestedLoopPoint);
                                }
                            }
                        }
                        else {
                            System.out.print("Invalid Input. Simply press the Enter key on your keyboard.\nOn the other hand, if you tried to quit, you cannot do so now - you must keep playing until you either hit a 7 and lose, or make the point and win.");
                        }
                    }
                    while(loopPoint);
                }
            }
            else if(userChoice.equals("n")) {
                loop = false;
            }
            else {
                System.out.println("Invalid Input. Please enter either 'Y' to play, or 'n' to quit.");
            }
        }
        while(loop);
    }
}