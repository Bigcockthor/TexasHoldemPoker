import java.util.Scanner;

/**
 * Created by Zou on 2016/10/7.
 */
public class Subject {
    static char[] sortPoker = {'2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A'};

    public static void main(String[] args) {
        Poker poker[][] = new Poker[2][7];
        Scanner mScanner = new Scanner(System.in);
        Perflop(poker, mScanner);
        FlopTurnRiver(poker, mScanner);
        Sort(poker);
        JudgingEnd(poker);
    }

    private static void Sort(Poker[][] poker) {
        Poker temp;
        int num1 = 0, num2 = 0;
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
                        temp = poker[i][j];
                        poker[i][j] = poker[i][k];
                        poker[i][k] = temp;
                    }
                }
            }
        }

    }

    private static void JudgingEnd(Poker[][] poker) {
        RoyalFlush(poker);
        StraightFlush(poker);
    }

    private static void StraightFlush(Poker[][] poker) {
        int flag[]={0,0};
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <3 ; j++) {
                for (int k = 0; k <13 ; k++) {
                    if (poker[i][j].point==sortPoker[k]&&poker[i][j+1].point==sortPoker[k+1]
                            &&poker[i][j+2].point==sortPoker[k+2]&&poker[i][j+3].point==sortPoker[k+3]
                            &&poker[i][j+4].point==sortPoker[k+4]&&poker[i][j].suit==poker[i][j+1].suit
                            &&poker[i][j+1].suit==poker[i][j+2].suit&&poker[i][j+2].suit==poker[i][j+3].suit
                            &&poker[i][j+3].suit==poker[i][j+4].suit){
                        flag[i]=j+1;
                    }
                }
            }
        }
        if (flag[0]!=0&&flag[1]==0){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (flag[0]==0&&flag[1]!=0){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
    }

    private static void RoyalFlush(Poker[][] poker) {
        int flag[]={0,0};
        for (int i = 0; i <2 ; i++) {
            if (poker[0][2].point == '0' && poker[0][3].point == 'J'
                    && poker[0][4].point == 'Q' && poker[0][5].point == 'K' && poker[0][6].point == 'A'
                    &&poker[0][2].suit==poker[0][3].suit&&poker[0][3].suit==poker[0][4].suit
                    &&poker[0][4].suit==poker[0][5].suit&&poker[0][5].suit==poker[0][6].suit) {
                flag[i]++;
            }
        }
        if (flag[0]>flag[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        else if (flag[0]<flag[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
        else{
            Draw(poker,1);
        }
    }

    private static void Draw(Poker[][] poker, int n) {
        int num1=0,num2=0;
        for (int i = n; i >=0 ; i--) {
            for (int l = 0; l < 13; l++) {
                if (poker[0][i].point == sortPoker[l]) {
                    num1 = l;
                }
                if (poker[1][i].point == sortPoker[l]) {
                    num2 = l;
                }
                if (num1>num2){
                    System.out.println("Player 1 win!");
                    System.exit(0);
                }
                if (num2>num1){
                    System.out.println("Player 2 win!");
                    System.exit(0);
                }
            }
        }
        System.out.println("Draw!");
        System.exit(0);
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
        System.out.println("Perflop:");
        for (int i = 0; i < 2; i++) {
            System.out.println("Please input Player " + (i + 1) + "'s card:");
            for (int j = 0; j < 2; j++) {
                InputCard(poker, mScanner, i, j);
            }
        }
    }

    private static void InputCard(Poker[][] poker, Scanner mScanner, int i, int j) {
        String card = mScanner.nextLine();
        Boolean flag;
        for (int k = 0; k < card.length(); k++) {
            if (card.charAt(k) == ' ') {
                char temp[] = new char[10];
                flag=true;
                Poker tempCard=null;
                card.getChars(0, k, temp, 0);
                try {
                    card.charAt(k + 2);
                } catch (IndexOutOfBoundsException e) {
                    tempCard = new Poker(String.valueOf(temp), card.charAt(k + 1));
                    flag = false;
                }
                if (flag) {
                    tempCard = new Poker(String.valueOf(temp), '0');
                }
                poker[i][j] = tempCard;
            }
        }
    }
}
