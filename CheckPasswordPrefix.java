import java.util.Scanner;

public class CheckPasswordPrefix {
    public static boolean isGoodPassword(String password) {
        String[] words = password.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].startsWith(words[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        input.close();
        if (isGoodPassword(password)) {
            System.out.println("GOOD PASSWORD");
        } else {
            System.out.println("BAD PASSWORD");
        }
    }
}
