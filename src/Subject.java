import java.util.Scanner;

/**
 * Created by Zou on 2016/10/7.
 */
public class Subject {
    static char[] pokerPoint = {'2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A'};
    static String[] pokerSuit = {"spades", "clubs", "hearts", "diamonds"};

    public static void main(String[] args) {
        Poker poker[][] = new Poker[2][7];
        Scanner mScanner = new Scanner(System.in);
        Perflop(poker, mScanner);
        FlopTurnRiver(poker, mScanner);
        sortPoint(poker);
        RoyalFlush(poker);
        StraightFlush(poker);
        FourOfAKind(poker);
        FullHouse(poker);
        Flush(poker);
        Straight(poker);
        ThreeOfAKind(poker);
        Pair(poker);
        HighCard(poker);
        System.out.println("Draw!");
    }

    private static void FullHouse(Poker[][] poker) {
        int a[][]=new int[2][13];
        int b[]=new int[2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <7 ; j++) {
                for (int k = 0; k <13 ; k++) {
                    if (poker[i][j].point==pokerPoint[k]){
                        a[i][k]++;
                    }
                }
            }
            for (int j = 0; j <13 ; j++) {
                if (a[i][j]==3){
                    b[i]++;
                    break;
                }
            }
            for (int j = 0; j <13 ; j++) {
                if (a[i][j]==2){
                    b[i]++;
                    break;
                }
            }
        }
        if (b[0]>b[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (b[0]<b[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
    }

    private static void HighCard(Poker[][] poker) {
        int b[][]=new int[2][7];
        for (int i = 0; i <2 ; i++) {
            int flag;
            flag = 0;
            for (int j = 6; j >= 0; j--) {
                for (int k = 0; k < 13; k++) {
                    if (poker[i][j].point == pokerPoint[k]) {
                        b[i][flag] = k;
                        flag++;
                    }
                }
            }
        }
        for (int i = 6; i >=0 ; i--) {
            if (b[0][i]>b[1][i]){
                System.out.println("Player 1 win!");
                System.exit(0);
            }
            if (b[0][i]<b[1][i]){
                System.out.println("Player 2 win!");
                System.exit(0);
            }
        }
    }

    private static void Pair(Poker[][] poker) {
        int a[][]=new int[2][13];
        int b[]=new int[2];
        int temp[]=new int[2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <7 ; j++) {
                for (int k = 0; k <13 ; k++) {
                    if (poker[i][j].point==pokerPoint[k]){
                        a[i][k]++;
                    }
                }
            }
            for (int j = 0; j <13 ; j++) {
                if (a[i][j]==2){
                    b[i]++;
                    temp[i]=j;
                }
            }
        }
        if (b[0]>b[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (b[0]<b[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
        if (b[0]==b[1]){
            if (temp[0]>temp[1]){
                System.out.println("Player 1 win!");
                System.exit(0);
            }
            if (temp[0]<temp[1]){
                System.out.println("Player 2 win!");
                System.exit(0);
            }
        }
    }

    private static void ThreeOfAKind(Poker[][] poker) {
        int a[][]=new int[2][13];
        int b[]=new int[2];
        int temp[]=new int[2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <7 ; j++) {
                for (int k = 0; k <13 ; k++) {
                    if (poker[i][j].point==pokerPoint[k]){
                        a[i][k]++;
                    }
                }
            }
            for (int j = 0; j <13 ; j++) {
                if (a[i][j]==3){
                    b[i]++;
                    temp[i]=j;
                }
            }
        }
        if (b[0]>b[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (b[0]<b[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
        if (b[0]==b[1]){
            if (temp[0]>temp[1]){
                System.out.println("Player 1 win!");
                System.exit(0);
            }
            if (temp[0]<temp[1]){
                System.out.println("Player 2 win!");
                System.exit(0);
            }
        }
    }

    private static void Straight(Poker[][] poker) {
        int b[]=new int[7];
        int c[]=new int[2];
        int big[]=new int[2];
        for (int i = 0; i <2 ; i++) {
            int flag;
            flag=0;
            for (int j = 6; j>=0  ; j--) {
                for (int k = 0; k < 13; k++) {
                    if (poker[i][j].point == pokerPoint[k]) {
                        b[flag] = k;
                        flag++;
                    }
                }
            }
            for (int j = 0; j <3 ; j++) {
                if (b[j]-1==b[j+1]&&b[j+1]-1==b[j+2]&&b[j+2]-1==b[j+3]&&b[j+3]-1==b[j+4]){
                    c[i]++;
                    big[i]=b[j+4];
                }
            }
        }
        if (c[0]>c[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (c[0]<c[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
        if (c[0]==c[1]&&c[0]==1){
            if (big[0]>big[1]){
                System.out.println("Player 1 win!");
                System.exit(0);
            }
            if (big[0]<big[1]){
                System.out.println("Player 2 win!");
                System.exit(0);
            }
        }
    }

    private static void Flush(Poker[][] poker) {
        int a[][]=new int[2][5];
        int b[]=new int[2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 7; j++) {
                if (poker[i][j].suit.equals(pokerSuit[0])) {
                    a[i][0]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[1])) {
                    a[i][1]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[2])) {
                    a[i][2]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[3])) {
                    a[i][3]++;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (a[i][j] >= 5) {
                    b[i]++;
                }
            }
        }
        if (b[0]>b[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (b[0]<b[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
    }

    private static void FourOfAKind(Poker[][] poker) {
        int a[][]=new int[2][13];
        int b[]=new int[2];
        int temp[]=new int[2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <7 ; j++) {
                for (int k = 0; k <13 ; k++) {
                    if (poker[i][j].point==pokerPoint[k]){
                        a[i][k]++;
                    }
                }
            }
            for (int j = 0; j <13 ; j++) {
                if (a[i][j]==4){
                    b[i]++;
                    temp[i]=j;
                }
            }
        }
        if (b[0]>b[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (b[0]<b[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
        if (b[0]==b[1]){
            if (temp[0]>temp[1]){
                System.out.println("Player 1 win!");
                System.exit(0);
            }
            if (temp[0]<temp[1]){
                System.out.println("Player 2 win!");
                System.exit(0);
            }
        }
    }

    private static void sortPoint(Poker[][] poker) {
        Poker temp;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = j + 1; k < 7; k++) {
                    for (int l = 0; l < 13; l++) {
                        if (poker[i][j].point == pokerPoint[l]) {
                            num1 = l;
                        }
                        if (poker[i][k].point == pokerPoint[l]) {
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

    private static void RoyalFlush(Poker[][] poker) {
        int a[][]=new int[2][5];
        int b[]=new int[2];
        String commonSuit=new String();
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <7 ; j++) {
                if (poker[i][j].suit.equals(pokerSuit[0])){
                    a[i][0]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[1])){
                    a[i][1]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[2])){
                    a[i][2]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[3])){
                    a[i][3]++;
                }
            }
            for (int j = 0; j <4 ; j++) {
                if (a[i][j]>=5){
                    commonSuit=pokerSuit[j];
                }
                a[i][j]=0;
            }
            for (int j = 0; j <7 ; j++) {
                if (poker[i][j].suit.equals(commonSuit)&&poker[i][j].point=='0'){
                    a[i][0]=1;
                }
                if (poker[i][j].suit.equals(commonSuit)&&poker[i][j].point=='J'){
                    a[i][1]=1;
                }
                if (poker[i][j].suit.equals(commonSuit)&&poker[i][j].point=='Q'){
                    a[i][2]=1;
                }
                if (poker[i][j].suit.equals(commonSuit)&&poker[i][j].point=='K'){
                    a[i][3]=1;
                }
                if (poker[i][j].suit.equals(commonSuit)&&poker[i][j].point=='A'){
                    a[i][4]=1;
                }
            }
            if (a[i][0]==1&&a[i][1]==1&&a[i][2]==1&&a[i][3]==1&&a[i][4]==1){
                b[i]++;
            }
        }
        if (b[0]>b[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (b[0]<b[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
    }

    private static void StraightFlush(Poker[][] poker) {
        int a[][]=new int[2][5];
        int b[]=new int[7];
        int c[]=new int[2];
        int big[]=new int[2];
        String commonSuit=new String();
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 7; j++) {
                if (poker[i][j].suit.equals(pokerSuit[0])) {
                    a[i][0]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[1])) {
                    a[i][1]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[2])) {
                    a[i][2]++;
                }
                if (poker[i][j].suit.equals(pokerSuit[3])) {
                    a[i][3]++;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (a[i][j] >= 5) {
                    commonSuit = pokerSuit[j];
                }
            }
            int flag;
            flag=0;
            for (int j = 6; j>=0  ; j--) {
                if (poker[i][j].suit.equals(commonSuit)){
                    for (int k = 0; k <13 ; k++) {
                        if (poker[i][j].point==pokerPoint[k]){
                            b[flag]=k;
                            flag++;
                        }
                    }
                }
            }
            for (int j = 0; j <3 ; j++) {
                if (b[j]-1==b[j+1]&&b[j+1]-1==b[j+2]&&b[j+2]-1==b[j+3]&&b[j+3]-1==b[j+4]){
                    c[i]++;
                    big[i]=b[j+4];
                }
            }
        }
        if (c[0]>c[1]){
            System.out.println("Player 1 win!");
            System.exit(0);
        }
        if (c[0]<c[1]){
            System.out.println("Player 2 win!");
            System.exit(0);
        }
        if (c[0]==c[1]&&c[0]==1){
            if (big[0]>big[1]){
                System.out.println("Player 1 win!");
                System.exit(0);
            }
            if (big[0]<big[1]){
                System.out.println("Player 2 win!");
                System.exit(0);
            }
        }
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
                flag = true;
                Poker tempCard = null;
                card.getChars(0, k, temp, 0);
                try {
                    card.charAt(k + 2);
                } catch (IndexOutOfBoundsException e) {
                    tempCard = new Poker(new String(temp).substring(0,k), card.charAt(k + 1));
                    flag = false;
                }
                if (flag) {
                    tempCard = new Poker(new String(temp).substring(0,k), '0');
                }
                poker[i][j] = tempCard;
            }
        }
    }
}
