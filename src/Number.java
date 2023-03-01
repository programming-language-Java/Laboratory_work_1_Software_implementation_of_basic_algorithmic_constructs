import java.util.Scanner;

import static java.lang.Math.*;

public class Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("������� ����� �����: ");
        int N = sc.nextInt();
        int numberDigits = (int) ceil(log10(abs(N) + 0.5));
        boolean isEvenTwoDigitNumber = numberDigits == 2 && N % 2 == 0;
        String result = isEvenTwoDigitNumber ? "����� �������� ������ �����������" : "����� �� �������� ������ �����������";
        System.out.print(result);
    }
}
