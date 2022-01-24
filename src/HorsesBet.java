import java.math.BigInteger;

public class HorsesBet {
    public static void calculateBets() {
        System.out.println("How many horses are running?");
        int nbHorsesRunning = Main.scan.nextInt();
        System.out.println("How many horses are yuo playing");
        int nbHorsesPlayed = Main.scan.nextInt();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {

            // brutalCalculationWithLong(nbHorsesRunning, nbHorsesPlayed);
            brutalCalculationWithBigInteger(nbHorsesRunning, nbHorsesPlayed);
        }
        long end = System.nanoTime();
        long length = end - start;
        System.out.println("Time brutal : " + length/Math.pow(10, 9));
        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++)
            smartCalculation(nbHorsesRunning, nbHorsesPlayed);

        end = System.nanoTime();
        length = end - start;
        System.out.println("Time brutal : " + length/Math.pow(10, 9));
    }

    private static void smartCalculation(int nbHorsesRunning, int nbHorsesPlayed) {
        long order = 1;
        long factp = 1;
        for (long i = 0; i < nbHorsesPlayed; i++) {
            order *= (nbHorsesRunning - i);
            factp *= (i + 1);
        }
     //   System.out.println("Your chance to guess in the right order " + order);
     //   System.out.println("Your chance to guess in disorder " + order / factp);

    }

    private static void brutalCalculationWithBigInteger(int nbHorsesRunning, int nbHorsesPlayed) {
        BigInteger factN = fact(BigInteger.valueOf(nbHorsesRunning));
        BigInteger factNminusP = fact(BigInteger.valueOf(nbHorsesRunning).subtract(BigInteger.valueOf(nbHorsesPlayed)));
        BigInteger factP = fact(BigInteger.valueOf(nbHorsesPlayed));
//        System.out.println("Your chance to guess in the right order " + factN.divide(factNminusP));
//        System.out.println("Your chance to guess in disorder " + factN.divide(factP.multiply(factNminusP)));


    }

    private static BigInteger fact(BigInteger n) {
        if (n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else
            return n.multiply(fact(n.subtract(BigInteger.ONE)));
    }

    private static void brutalCalculationWithLong(int nbHorsesRunning, int nbHorsesPlayed) {
        long factN = factoriel(nbHorsesRunning);
        long factNminusP = factoriel(nbHorsesRunning - nbHorsesPlayed);
        long factP = factoriel(nbHorsesPlayed);
//        System.out.println("Your chance to guess in the right order " + factN / factNminusP);
//        System.out.println("Your chance to guess in disorder " + factN / (factP * factNminusP));
    }

    private static long factoriel(long n) {
        if (n == 0)
            return 1;
        else
            return n * factoriel(n - 1);
    }
}
