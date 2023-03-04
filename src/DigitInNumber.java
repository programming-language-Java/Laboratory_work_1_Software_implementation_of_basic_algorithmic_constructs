import java.util.Scanner;

import static java.lang.Math.*;

public class DigitInNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int N = abs(sc.nextInt());
        int number = N;
        int digit;
        boolean isDigitInNumber = false;

        while (number > 0) {
            digit = number % 10;
            isDigitInNumber = isDigitInNumber(digit, number);
            if (isDigitInNumber) break;
            number /= 10;
        }
        if (isDigitInNumber || N == 0) {
            System.out.print("Цифра входит в запись числа");
            return;
        }
        System.out.print("Цифра НЕ входит в запись числа");
    }

    public static boolean isDigitInNumber(int digit, int N) {
        System.out.println("digit: " + digit);
        System.out.println("N: " + N);
        if (digit % 4 == 0) {
            String strN = Integer.toString(N),
                    strDigit = Integer.toString(digit);
            return strN.contains(strDigit);
        }
        return false;
    }
}
