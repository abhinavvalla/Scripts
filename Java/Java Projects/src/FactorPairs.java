public class FactorPairs {
    public static void main(String[] args){
        printFactorPairs(12);
    }
    public static void printFactorPairs(int number){
        System.out.printf("Factor pairs of %d:\n", number);
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                if (number/i < i){
                    return;
                }
                System.out.printf("  %d x %d\n", i, number/i);
            }
        }
    }
}
