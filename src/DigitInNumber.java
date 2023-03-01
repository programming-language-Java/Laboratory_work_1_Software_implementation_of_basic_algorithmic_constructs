import java.util.Scanner;

import static java.lang.Math.*;

public class DigitInNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("������� ����� �����: ");
        int N = abs(sc.nextInt());
        int digit = 0;
        boolean isDigitInNumber = false;

        while (N > 0) {
            digit = N % 10;
            isDigitInNumber = isDigitInNumber(digit, N);
            if (isDigitInNumber) break;
            N /= 10;
        }
        if (isDigitInNumber) {
            System.out.print("����� ������ � ������ �����");
            return;
        }
        System.out.print("����� �� ������ � ������ �����");
    }

    public static boolean isDigitInNumber(int digit, int N) {
        if (digit % 4 == 0) {
            String strN = Integer.toString(N),
                    strDigit = Integer.toString(digit);
            return strN.contains(strDigit);
        }
        return false;
    }
}
