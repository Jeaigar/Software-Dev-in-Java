import java.io.*;
import java.util.*;

public class GroupingSymbolsChecker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolsChecker <source-code filename>");
            System.exit(1);
        }

        String filename = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Stack<Character> stack = new Stack<>();
            int ch;
            while ((ch = reader.read()) != -1) {
                switch (ch) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push((char) ch);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                            System.out.println("Unmatched parentheses.");
                            return;
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') {
                            System.out.println("Unmatched braces.");
                            return;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            System.out.println("Unmatched brackets.");
                            return;
                        }
                        break;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("All grouping symbols are correctly matched.");
            } else {
                System.out.println("Unmatched grouping symbols.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
