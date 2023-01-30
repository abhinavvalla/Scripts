public class PrimeNumbers {
    public static void main(String[] args){
        printPrimes(50);
        printPrimes(19);
        printPrimes(1000);
    }
    public static void printPrimes(int max){
        if (max < 2){
            System.out.println("none");
        }
        else{
            System.out.printf("primes up through %d are [2", max);
            for (int i = 3; i <= max; i++){
                if (isPrime(i) == true){
                    System.out.printf(" %d",i);
                }
            }
            System.out.print("]\n");
        }
    }
    public static boolean isPrime(int num){
        for (int i = 2; i < num; i++){
            if (num%i == 0){
                return false;
            }
        }
        return true;
    }
}
