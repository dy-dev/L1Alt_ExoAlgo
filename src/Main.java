import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select the exercise you want to check");
        int exNumber = scan.nextInt();
        switch (exNumber){
            case 1 -> {calcultateDiscount();}
            case 2 -> {
                calculateVariablesDiscount();}
        }

    }

    private static void calculateVariablesDiscount() {
        System.out.println("Define starting price");
        int price = scan.nextInt();
        System.out.println("Select how many discounts you want");
        int nbDiscount = scan.nextInt();

        int[] discounts = new int[nbDiscount];

        for (int i = 0; i < nbDiscount; i++) {
            discounts[i]= scan.nextInt();
        }

        applydiscounts(price , discounts);


    }

    private static void applydiscounts(float price, int[] discounts) {
        //check if user has entered discounts in descending order
        int i = 1;
        for (int discount : discounts) {
            if(i == discounts.length -1)
                break;
            if( discount > discounts[i])
            {
                System.out.println("Error, discount must be in descending order please try again");
                return;
            }
            price *= (1.f-discount/100.f);
        }
        System.out.println("Final price is : " + price);

    }

    private static void calcultateDiscount() {
        float price = 10.f;
        float finalprice = 0.5f * price;

        finalprice *= 0.7f;

        System.out.println("Final Price is : " + finalprice);
    }
}
