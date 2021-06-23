import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class MoonWell {


    public static void main(String[] args) {
        new GUI();

        Scanner input = new Scanner(System.in);
        Random flip = new Random();
        boolean loop = true;
        while (loop == true) {
            System.out.println("What value of gem is being dunked?");
            double value = input.nextInt();
            System.out.println("How many are there?");
            int amount = input.nextInt();

            double halved = 0;
            double doubled = 0;
            double halvedVal = value / 2;
            double doubledVal = value * 2;
            int i;
            for (i = 0; i < amount; i++) {
                int roll = flip.nextInt(2) + 1;
                if (roll == 1) {
                    halved++;
                } else {
                    doubled++;
                }
            }
            double halvedTotal = halved * halvedVal;
            double doubledTotal = doubled * doubledVal;
            System.out.println(halved + " gems halved in price. Value: " + halvedTotal);
            System.out.println(doubled + " gems doubled in price. Value: " + doubledTotal);
            System.out.println("Total value: " + (halvedTotal + doubledTotal));
            System.out.println("Rerun? Y/N");
            String loopcheck = input.next();
            if (loopcheck.equals("N")) {
                loop = false;
            }
        }
        return;

    }


}
