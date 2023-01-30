import java.util.Scanner;

public class CharacterCounter {
    final static Scanner console = new Scanner(System.in);
    public static void main(String[] args){
        int total = 0;
        String answer = getUserAnswer("Type a line (or \"quit\" to exit): ");
        while (answer.equals("quit") == false){
            total += getCharCount(answer);
            answer = getUserAnswer("Type a line (or \"quit\" to exit): ");
        }
        System.out.printf("You typed a total of %d characters.", total);
    }
    public static int getCharCount(String word){
        return word.length();
    }
    public static String getUserAnswer(String prompt){
        System.out.print(prompt);
        return console.next();
    }
}
