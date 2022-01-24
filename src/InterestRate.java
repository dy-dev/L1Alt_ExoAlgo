public class InterestRate {
    public static void calculateCost() {
        System.out.println("How much do you need");
        int borrowedAmount = Main.scan.nextInt();
        System.out.println("Interest rate");
        float rate = Main.scan.nextFloat();
        System.out.println("How many years ?");
        int nbYears= Main.scan.nextInt();

        float cost = calculateCost(borrowedAmount, rate, nbYears);
        System.out.println("Your loan will cost you : " + cost);
    }

    private static float calculateCost(int borrowedAmount, float rate, int nbYears) {
        float monthlyRate = rate/(12.f*100.f);
        float monthly = (float) ((borrowedAmount * monthlyRate)/(1-Math.pow(1+monthlyRate,-12*nbYears)));

        return monthly*nbYears*12 - borrowedAmount;
    }
}
