import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] queries = input.split(",");
        Stack<Integer> enqueueStack = new Stack<>();
        Stack<Integer> dequeueStack = new Stack<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int operation = Integer.parseInt(parts[0]);

            switch (operation) {
                case 1:
                    int element = Integer.parseInt(parts[1]);
                    enqueue(enqueueStack, element);
                    break;
                case 2:
                    dequeue(enqueueStack, dequeueStack);
                    break;
                case 3:
                    printFront(enqueueStack, dequeueStack);
                    break;
            }
        }
    }

    private static void enqueue(Stack<Integer> enqueueStack, int element) {
        enqueueStack.push(element);
    }

    private static void dequeue(Stack<Integer> enqueueStack, Stack<Integer> dequeueStack) {
        if (dequeueStack.isEmpty()) {
            // Transfer elements from enqueue stack to dequeue stack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        if (!dequeueStack.isEmpty()) {
            dequeueStack.pop();
        }
    }

    private static void printFront(Stack<Integer> enqueueStack, Stack<Integer> dequeueStack) {
        if (dequeueStack.isEmpty()) {
            // Transfer elements from enqueue stack to dequeue stack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        if (!dequeueStack.isEmpty()) {
            System.out.print(dequeueStack.pop());
        }
    }
}
