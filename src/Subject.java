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
        Sort(poker);
        JudgingEnd(poker);
    }

    private static void Sort(Poker[][] poker) {
        char sortPoker[] = {'2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A'};
        Poker temp;
        int num1=0, num2=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = j + 1; k < 7; k++) {
                    for (int l = 0; l < 13; l++) {
                        if (poker[i][j].point == sortPoker[l]) {
                            num1 = l;
                        }
                        if (poker[i][k].point == sortPoker[l]) {
                            num2 = l;
                        }
                    }
                    if (num1 > num2) {
                        temp=poker[i][j];
                        poker[i][j]=poker[i][k];
                        poker[i][k]=temp;
                    }
                }
            }
        }

    }

    private static void JudgingEnd(Poker[][] poker) {

    }

    private static void FlopTurnRiver(Poker[][] poker, Scanner mScanner) {
        System.out.println("Flop:");
        for (int j = 2; j < 5; j++) {
            InputCard(poker, mScanner, 0, j);
            poker[1][j] = poker[0][j];
        }
        System.out.println("Turn:");
        InputCard(poker, mScanner, 0, 5);
        poker[1][5] = poker[0][5];
        System.out.println("River:");
        InputCard(poker, mScanner, 0, 6);
        poker[1][6] = poker[0][6];
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
                char temp2[] = new char[2];
                Poker tempCard;
                card.getChars(0, k, temp, 0);
                card.getChars(k + 1, k + 2, temp2, 0);
                if (String.valueOf(temp2) != "10") {
                    tempCard = new Poker(String.valueOf(temp), card.charAt(k + 1));
                } else {
                    tempCard = new Poker(String.valueOf(temp), '0');
                }
                poker[i][j] = tempCard;
            }
        }
    }
}
