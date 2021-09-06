import java.util.Scanner;

@FunctionalInterface
interface MyCalculator {

    double compute(double a, double b);
}

public class Main {

    public static void main(String[] args) {

        char ch = 'y';
        int num;
        double a, b;
        MyCalculator add = (x, y) -> x+y;
        MyCalculator sub = (x, y) -> x-y;
        MyCalculator mul = (x, y) -> x*y;
        MyCalculator div = (x, y) -> x/y;
        while(ch == 'y') {
            System.out.println("1. Addition   2. Subtraction   3. Multiplication   4. Division");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            a = sc.nextDouble();
            b = sc.nextDouble();
            switch (num) {
                case 1 -> System.out.println(add.compute(a, b));
                case 2 -> System.out.println(sub.compute(a, b));
                case 3 -> System.out.println(mul.compute(a, b));
                case 4 -> System.out.println(div.compute(a, b));
                default -> System.out.println("Invalid");
            }
            System.out.println("Do you want to continue?(y/n)");
            ch = sc.next().charAt(0);
        }
    }
}
