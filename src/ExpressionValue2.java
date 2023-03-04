import java.util.Scanner;

public class ExpressionValue2 {
    public static void main(String[] args) {
        System.out.println("Программа для вычисления значения выражения:\n" + "a(a - n)(a - 2n)*...*(a - n^2)");
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите вещественное число a: ");
        double a = sc.nextDouble();
        System.out.print("Введите целое число n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.print("Исходные данные не верны!");
            return;
        }

        double p = 1.0;
        int nextN = 0;
        while (nextN <= n * n) {
            p *= a - nextN;
            nextN += n;
            if (nextN == 0) break;
        }
        System.out.print("Значение выражения равно: " + p);
    }
}
