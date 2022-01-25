import java.util.*;

public class Prime {
    public static void findPrimeNumbers() {
        System.out.println("Give number");
        int n = Main.scan.nextInt();
        long start = System.nanoTime();
        List<Integer> primes = findPrimesBrutal(n);
        long end = System.nanoTime();
        long length = end - start;
        System.out.println("Time brutal : " + length/Math.pow(10, 9));
//        for (var prime :
//                primes) {
//            System.out.print(prime + ",");
//        }
        System.out.println();
        start = System.nanoTime();
        primes = findPrimesSmart(n);
        end = System.nanoTime();
        length = end - start;
        System.out.println("Time smart  : " + length/Math.pow(10, 9));
//        for (var prime :
//                primes) {
//            System.out.print(prime + ",");
//        }

    }

    private static List<Integer> findPrimesBrutal(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }

            }
            if (prime)
                primes.add(i);
        }
        return primes;
    }

    private static List<Integer> findPrimesSmart(int n) {
        List<Integer> primes = new ArrayList<>(List.of(2));

        for (int i = 3; i < n; i+=2) {
            if(isPrime(i))
                primes.add(i);
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        for (int j = 3; j*j <n +2 ; j+=2) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;)
    }


}
