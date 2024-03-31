+----------------------------------+
|     BinaryFormatException        |
+----------------------------------+
| - message: String                |
+----------------------------------+
| + BinaryFormatException(message: |
|   String)                        |
+----------------------------------+
                ^
                |
                |
                |
+----------------------------------+
|              Main                |
+----------------------------------+
| + main(args: String[]): void     |
| + bin2Dec(binaryString: String): |
|   int                            |
+----------------------------------+


// Define the custom exception
public class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(bin2Dec("1100101"));
            System.out.println(bin2Dec("1102101")); // This should throw an exception
        } catch (BinaryFormatException e) {
            e.printStackTrace();
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        if (!binaryString.matches("[01]+")) {
            throw new BinaryFormatException("Input string: " + binaryString + " is not a binary string.");
        }

        int decimal = 0;
        for (int i = 0, len = binaryString.length(); i < len; i++) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, len - 1 - i);
            }
        }
        return decimal;
    }
}