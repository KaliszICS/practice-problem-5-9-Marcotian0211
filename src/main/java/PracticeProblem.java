import java.util.Stack;
import java.util.ArrayDeque;
public class PracticeProblem {

	public static void main(String args[]) {

	}

    public static String processBackspaces(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != '#') {
                stack.push(ch);
            }
            else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        String result = "";

        for (char c : stack) {
            result += c;
        }
        return result;
    }


    public static String simulateLine(String[] commands) {

        ArrayDeque<String> line = new ArrayDeque<String>();

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];


            if (command.startsWith("ENQUEUE")) {

                String name = command.substring(8);
                line.addLast(name);

            }


            else if (command.startsWith("VIP")) {

                String name = command.substring(4);
                line.addFirst(name);

            }


            else if (command.equals("SERVE")) {

                if (!line.isEmpty()) {
                    line.removeFirst();
                }

            }

            else if (command.equals("REQUEUE")) {

                if (!line.isEmpty()) {

                    String person = line.removeFirst();
                    line.addLast(person);

                }

            }

            else if (command.equals("SCARE")) {

                if (!line.isEmpty()) {
                    line.removeLast();
                }

            }

        }

        return line.toString();
    }

}