import java.util.Scanner;

public class BMICalc {
    public static double weight;
    public static double height;
    public static Scanner inputReader = new Scanner(System.in);
    public static String spaces = "    ";

    public static void main(String[] args){
        System.out.println("BMI Calculator");
        getInfo();
        System.out.println(spaces+"BMI: " + round((weight*703) / Math.pow(height,2), 1));
    }
    
    public static void getInfo(){
        weight = getInput("Enter your weight (lbs): ");
        height = getInput("Enter your height (in): ");
    }
    public static double getInput(String prompt){
        System.out.print(spaces+prompt);
        return inputReader.nextDouble();
    }
    public static double round(double num, int numPlaces){
        double finalNum = Math.round(num * (Math.pow(10, numPlaces)))/Math.pow(10, numPlaces);
        return finalNum;
    }
}
