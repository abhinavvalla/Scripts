/*
Abhinav Vallabhaneni
1/23/2023
Mr. Thompson
Personality Project

This program returns the personality type of a person based on their answers to a test.
The program takes an input of x number of people's name and their test results and returns their personality type in an output file
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PersonalityProject {
    //Constant used for initializing arrays based on the 4 categories
    public static final int LENGTHCONSTANT = 4;
    //Main throws IO Exception to handle all input and output errors
    public static void main(String[] args) throws IOException {
        //Prints the starting phrase
        printStart();

        //Scanner for console input
        Scanner input = new Scanner(System.in);
        //File object for input file
        File inputFile = new File("src/" + getUserInput("input file name? ", input));
        //Scanner for input file reading
        Scanner InputfileScanner = new Scanner(inputFile);
        //Writer object for output file writing
        BufferedWriter writer = new BufferedWriter(new FileWriter(getUserInput("output file name? ", input)));

        //Loops through all input data
        while (InputfileScanner.hasNextLine()){
            //Gets person's name
            String name = InputfileScanner.nextLine();
            //Gets person's data
            int[] data = getAnswerPercentages(InputfileScanner.nextLine());
            //Gets person's personality type based on person's data
            String personality = calculatePersonality(data);
            //Writes person's data to the output file
            writer.write(getFormattedString(name, data, personality));
        }
        //Closes writer object
        writer.close();
        InputfileScanner.close();
    }
    //Function for printing the starting phrase
    public static void printStart(){
        System.out.println( "This program processes a file of answers to the\n" +
                "Keirsey Temperament Sorter.  It converts the\n" +
                "various A and B answers for each person into\n" +
                "a sequence of B-percentages and then into a\n" +
                "four-letter personality type.\n");
    }
    //Function for returning a formatted string that is used to write to the output file
    //Input: Person's name, data, and personality type
    //Output: Fully formatted string ready to be written to an output file
    public static String getFormattedString(String name, int[] data, String personality){
        return name + ": " + Arrays.toString(data) + " = " + personality+'\n';
    }
    //Function for calculating a person's personality type based on the person's data
    //Input: Person's data
    //Output: Returns the person's personality type as a string
    public static String calculatePersonality(int[] data){
        String[][] personalities = {{"E", "I"}, {"S", "N"}, {"T", "F"}, {"J", "P"}};
        String personality = "";
        for(int i = 0; i < LENGTHCONSTANT; i++){
            int currentBvalue = data[i];
            if (currentBvalue > 50){
                personality += personalities[i][1];
            }
            else if (currentBvalue < 50){
                personality += personalities[i][0];
            }
            else {
                personality += "X";
            }
        }
        return personality;
    }
    //Function for getting the 10, 7-length, substrings of a given answer line
    //Input: A person's answers
    //Output: Returns the substrings of length 7 in a String array of length 10
    public static String[] getSubstrings (String inputLine){
        String[] subStringArray = new String[10];
        for (int i = 0; i < 10; i++){
            subStringArray[i] = inputLine.substring(i*7, i*7+7);
        }
        return subStringArray;
    }
    //Function for get the B response percentages for all 4 categories
    //Input: A person's answers
    //Output: A person's category scores in a int array
    //Calls: getSubstrings(), calculateAnswerPercentage()
    public static int[] getAnswerPercentages(String inputLine){
        int[] outputArray = new int[LENGTHCONSTANT];
        String[] subStringsArray = getSubstrings(inputLine);
        for (int i = 0; i < LENGTHCONSTANT; i++){
            outputArray[i] = calculateAnswerPercentage(subStringsArray, i);
        }
        return outputArray;
    }
    //Function for calculating a certain categories answer percentage
    //Input: A string array containing the length-7 substrings of a persons answer response,
    //       the index corresponding to a category
    //Output: The percentage score of a given category as an int
    public static int calculateAnswerPercentage(String[] subStringArray, int categoryIndex){
        int numA = 0;
        int numB = 0;
        String sectionString = "";
        for(int i = 0; i < subStringArray.length; i++){
            if (categoryIndex == 0){
                sectionString += subStringArray[i].charAt(0);
            }
            else{
                sectionString += subStringArray[i].substring(categoryIndex*2-1, (categoryIndex*2-1) + 2);
            }
        }
        for (int i = 0; i < sectionString.length(); i++){
            String currentChar = String.valueOf(sectionString.charAt(i)).toUpperCase();
            if (currentChar.equals("A")){
                numA++;
            }
            else if (currentChar.equals("B")){
                numB++;
            }
        }
        return Math.round((float) numB/(numB+numA)*100);
    }
    //Function for getting user input based on a prompt
    //Input: The prompt as a string,
    //       The console scanner
    //Output: The user's response as a String
    public static String getUserInput(String prompt, Scanner input){
        System.out.print(prompt);
        return input.nextLine();
    }
}
