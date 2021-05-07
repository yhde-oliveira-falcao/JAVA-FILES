import java.util.Scanner;

public class Palindrome {
    public static void main(String args[]){
        String word = ""; //It can be a Stack class
        String comparison = ""; //The initialization to "" follows the best Java codding practices.
        int size;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a name or word:");
        word = input.nextLine();
        size = word.length();
        for(int i = size - 1; i >= 0; i--){ //This iteration will assign the word entered in reverse to the comparison
            comparison = comparison + word.charAt(i);
        }
        if(word.equals(comparison)){
            System.out.println("Word is palindrome");
        } else {
            System.out.println("Word is not palindrome");
        }
    }
}
