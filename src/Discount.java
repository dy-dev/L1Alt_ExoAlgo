public class Discount {
    public static void calculateVariablesDiscount() {
        System.out.println("Define starting price");
        int price = Main.scan.nextInt();
        System.out.println("Select how many discounts you want");
        int nbDiscount = Main.scan.nextInt();

        int[] discounts = new int[nbDiscount];

        for (int i = 0; i < nbDiscount; i++) {
            discounts[i] = Main.scan.nextInt();
        }

        applydiscounts(price, discounts);
    }


    public static void applydiscounts(float price, int[] discounts) {
        //check if user has entered discounts in descending order
        int i = 1;
        for (int discount : discounts) {
            if (i == discounts.length - 1)
                break;
            if (discount < discounts[i++]) {
                System.out.println("Error, discount must be in descending order please try again");
                return;
            }
            price *= (1.f - discount / 100.f);
        }
        System.out.println("Final price is : " + price);
        int nb20DollarsBills = Main.scan.nextInt();

        checkAndPaybackGivenAmount(nb20DollarsBills, price);

    }

    public static void calcultateDiscount() {
        float price = 10.f;
        float finalprice = 0.5f * price;

        finalprice *= 0.7f;

        System.out.println("Final Price is : " + finalprice);
      }

    private static void checkAndPaybackGivenAmount(int nb20DollarsBills, float finalprice) {
        if (finalprice > 20 * nb20DollarsBills) {
            System.out.println("Not enough money sorry !!!");
            return;
        }
        int[] moneyArray = {50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        float amountToReturn = 20 * nb20DollarsBills - finalprice;

        int amountToReturnInCents = (int) (amountToReturn * 100.f);
        System.out.println("You have paid " + (20 * nb20DollarsBills) + " to pay for this item which value is " + finalprice);
        System.out.println("I have to return " + amountToReturn );
        for (int value : moneyArray) {
            int nbItem = amountToReturnInCents / value;
            amountToReturnInCents %= value;
            //Bills to give back
            String type = "";
            String nature = "$";
            if(value >= 500){
                type = "bills";
                value /= 100;
            }
            //dollar coins
            else if (value >= 100){
                type = "coin(s)";
                value /= 100;
            }
            //Cents coins
            else {
                type = "coin(s)";
                nature = "cents";
            }
            if(nbItem > 0)
                System.out.println(nbItem + " " + type +" of " + value + nature);

        }
    }


}
