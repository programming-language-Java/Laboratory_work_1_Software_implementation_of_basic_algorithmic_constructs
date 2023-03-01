import java.util.Scanner;

import static java.lang.Math.sin;

public class ExpressionValue {
    public static void main(String[] args) {
        System.out.println("¬ведите данные дл€ вычислени€ значени€ выражени€ (x + 0.45 * z) / 7 * y + x * y / sin(x - 2 * z)");
        Scanner sc = new Scanner(System.in);
        System.out.print("¬ведите x: ");
        double x = sc.nextDouble();
        System.out.print("¬ведите y: ");
        double y = sc.nextDouble();
        System.out.print("¬ведите z: ");
        double z = sc.nextDouble();
        double result = (x + 0.45 * z) / 7 * y + x * y / sin(x - 2 * z);
        System.out.print("–езультата: " + result);
    }
}