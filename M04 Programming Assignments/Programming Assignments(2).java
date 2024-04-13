import java.util.*;
import java.io.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords sourceFile");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // Call countKeywords method and print the result
        System.out.println("The number of keywords in " + args[0]
            + " is " + countKeywords(sourceFile));
    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean", 
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int", 
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static", 
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", 
            "volatile", "while", "true", "false", "null"};

        Set<String> keywordSet = 
            new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        // Check if in comment
        boolean inComment = false;
        // Check if in string
        boolean inString = false;

        while (input.hasNext()) {
            String word = input.next();

            // Check for comment blocks
            if (word.contains("/*")) {
                inComment = true;
            }
            if (word.contains("*/")) {
                inComment = false;
            }

            // Check for strings
            if (word.startsWith("\"")) {
                inString = true;
            }
            if (word.endsWith("\"")) {
                inString = false;
            }

            // Increase count if it's a keyword, not in a comment or string
            if (!inComment && !inString && keywordSet.contains(word)) {
                count++;
            }
        }

        return count;
    }
}
