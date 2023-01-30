import java.util.Scanner;
public class RhymeAndAlliterate {
    public static final Scanner CONSOLE = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Type two words: ");
        String word1 = CONSOLE.next();
        String word2 = CONSOLE.next();
        printRhymeAndOrAlliterate(word1, word2);
    }
    public static boolean isRhyming(String word1, String word2){
        return word1.length() > 1 && word2.length() > 1 && word1.toLowerCase().substring(word1.length()-2).equals(word2.toLowerCase().substring(word2.length()-2));
    }
    public static boolean isAlliterate(String word1, String word2){
        return word1.toLowerCase().startsWith(word2.toLowerCase().substring(0,1));
    }
    public static void printRhymeAndOrAlliterate(String word1, String word2){
        boolean rhyming = isRhyming(word1,word2);
        boolean alliterate = isAlliterate(word1,word2);
        if (rhyming){
            System.out.println("They rhyme!");
        }
        if (alliterate){
            System.out.println("They alliterate (start with the same letter)!");
        }
        if (!rhyming && !alliterate){
            System.out.println("They have nothing in common.");
        }
    }
}

