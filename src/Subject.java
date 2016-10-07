import java.util.Scanner;

/**
 * Created by Zou on 2016/10/7.
 */
public class Subject {
    public static void main(String[] args) {
        Poker poker[][]=new Poker[2][7];
        Scanner mScanner=new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <2 ; j++) {
                poker[i][j].suit = mScanner.next();
            }
        }
    }
}
