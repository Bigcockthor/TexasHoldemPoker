import java.util.Scanner;

/**
 * Created by Zou on 2016/10/7.
 */
public class Subject {
    public static void main(String[] args) {
        Poker poker[][] = new Poker[2][7];
        Scanner mScanner = new Scanner(System.in);
        Perflop(poker, mScanner);
        FlopTurnRiver(poker, mScanner);
    }

    private static void FlopTurnRiver(Poker[][] poker, Scanner mScanner) {
        System.out.println("Flop:");
        for (int j = 2; j < 5; j++) {
            InputCard(poker, mScanner, 0, j);
            poker[1][j]=poker[0][j];
        }
        System.out.println("Turn:");
        InputCard(poker,mScanner,0,5);
        poker[1][5]=poker[0][5];
        System.out.println("River:");
        InputCard(poker,mScanner,0,6);
        poker[1][6]=poker[0][6];
    }

    private static void Perflop(Poker[][] poker, Scanner mScanner) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Please input Player " + (i + 1) + "'s card:");
            for (int j = 0; j < 2; j++) {
                InputCard(poker, mScanner, i, j);
            }
        }
    }

    private static void InputCard(Poker[][] poker, Scanner mScanner, int i, int j) {
        String card = mScanner.nextLine();
        for (int k = 0; k < card.length(); k++) {
            if (card.charAt(k) == ' ') {
                char temp[] = new char[10];
                card.getChars(0, k, temp, 0);
                Poker tempCard = new Poker(String.valueOf(temp), card.charAt(k + 1));
                poker[i][j] = tempCard;
            }
        }
    }
}
