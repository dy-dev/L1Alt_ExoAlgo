import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Select the exercise you want to check");
        int exNumber = scan.nextInt();
        switch (exNumber) {
            case 1 -> {
                Discount.calcultateDiscount();
            }
            case 2 -> {
                Discount.calculateVariablesDiscount();
            }
        }

    }
}
