import java.util.Stack;
import java.util.Scanner;
public class TextEditor {
    private static Stack<String> textHistory = new Stack<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        processOperation(input);
        scanner.close();
    }
    private static void processOperation(String input) {
        String[] operations = input.split(",");
        for (String operation : operations) {
            String[] parts = operation.trim().split(" ");
            int operationType = Integer.parseInt(parts[0]);
            switch (operationType) {
                case 1:
                    addText(parts[1]);
                    break;
                case 2:
                    deleteText(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    getCharacter(Integer.parseInt(parts[1]));
                    break;
                case 4:
                    undo();
                    break;
            }
        }
    }
    private static void addText(String text) {
        String currentText = getCurrentText();
        String newText = currentText + text;
        textHistory.push(newText);
    }
    private static void deleteText(int position) {
        String currentText = getCurrentText();
        if (position > 0 && position <= currentText.length()) {
            textHistory.push(currentText.substring(0, currentText.length() - position));
        }
    }
    private static void getCharacter(int position) {
        String currentText = getCurrentText();
        if (position > 0 && position <= currentText.length()) {
            System.out.print(currentText.charAt(position - 1) + " ");
        }
    }
    private static void undo() {
        if (!textHistory.isEmpty()) {
            textHistory.pop();
        }
    }
    private static String getCurrentText() {
        if (!textHistory.isEmpty()) {
            return textHistory.peek();
        } else {
            return "";
        }
    }
}
