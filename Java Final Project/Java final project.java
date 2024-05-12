import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    private char currentPlayer = 'X'; // Player 'X' starts
    private Button[][] board = new Button[3][3]; // 3x3 Tic Tac Toe board

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Multifunctional App");

        // Create UI components
        Button ticTacToeButton = new Button("Play Tic Tac Toe");
        Button quoteButton = new Button("Get an Inspirational Quote");
        Button calculatorButton = new Button("Use the Calculator");

        // Set event handlers for buttons
        ticTacToeButton.setOnAction(e -> {
            startTicTacToe(primaryStage);
        });

        quoteButton.setOnAction(e -> {
            startQuoteGenerator(primaryStage);
        });

        calculatorButton.setOnAction(e -> {
            startCalculator(primaryStage);
        });

        // Create layout
        VBox layout = new VBox(20);
        layout.getChildren().addAll(ticTacToeButton, quoteButton, calculatorButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Start Tic Tac Toe game
    private void startTicTacToe(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create buttons for the Tic Tac Toe board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setOnAction(e -> {
                    if (button.getText().isEmpty()) {
                        button.setText(Character.toString(currentPlayer));
                        if (checkForWinner()) {
                            displayWinner(primaryStage);
                        } else if (checkForDraw()) {
                            displayDraw(primaryStage);
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    }
                });
                board[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 320, 320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Check if there's a winner
    private boolean checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].getText().isEmpty() &&
                    board[i][0].getText().equals(board[i][1].getText()) &&
                    board[i][0].getText().equals(board[i][2].getText())) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].getText().isEmpty() &&
                    board[0][j].getText().equals(board[1][j].getText()) &&
                    board[0][j].getText().equals(board[2][j].getText())) {
                return true;
            }
        }
        // Check diagonals
        if (!board[0][0].getText().isEmpty() &&
                board[0][0].getText().equals(board[1][1].getText()) &&
                board[0][0].getText().equals(board[2][2].getText())) {
            return true;
        }
        if (!board[0][2].getText().isEmpty() &&
                board[0][2].getText().equals(board[1][1].getText()) &&
                board[0][2].getText().equals(board[2][0].getText())) {
            return true;
        }
        return false;
    }

    // Check if the board is full (draw)
    private boolean checkForDraw() {
        for (Button[] row : board) {
            for (Button button : row) {
                if (button.getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    // Display the winner
    private void displayWinner(Stage primaryStage) {
        Stage winnerStage = new Stage();
        VBox winnerLayout = new VBox(20);
        winnerLayout.setAlignment(Pos.CENTER);
        winnerLayout.getChildren().add(new Label("Winner: " + currentPlayer));
        Scene winnerScene = new Scene(winnerLayout, 150, 100);
        winnerStage.setScene(winnerScene);
        winnerStage.show();
        primaryStage.close();
    }

    // Display draw message
    private void displayDraw(Stage primaryStage) {
        Stage drawStage = new Stage();
        VBox drawLayout = new VBox(20);
        drawLayout.setAlignment(Pos.CENTER);
        drawLayout.getChildren().add(new Label("It's a draw!"));
        Scene drawScene = new Scene(drawLayout, 150, 100);
        drawStage.setScene(drawScene);
        drawStage.show();
        primaryStage.close();
    }

    // Start Quote Generator
    private void startQuoteGenerator(Stage primaryStage) {
        primaryStage.setTitle("Quote Generator");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        // Add a label to display the quote
        Label quoteLabel = new Label("Your inspirational quote goes here.");
        vbox.getChildren().add(quoteLabel);

        // Add logic to generate and display quotes

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Start Calculator
    private void startCalculator(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        TextField display = new TextField();
        display.setPrefWidth(200);

        // Add buttons for digits and operations
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            for (int j = 0; j < buttonLabels[i].length; j++) {
                Button button = new Button(buttonLabels[i][j]);
                button.setMinSize(40, 40);
                button.setOnAction(e -> {
                    if (button.getText().equals("=")) {
                        calculate(display);
                    } else {
                        display.appendText(button.getText());
                    }
                });
                gridPane.add(button, j, i);
            }
        }

        vbox.getChildren().addAll(display, gridPane);

        Scene scene = new Scene(vbox, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(TextField display) {
        String expression = display.getText();
        try {
            double result = evaluateExpression(expression);
            display.setText(Double.toString(result));
        } catch (NumberFormatException | ArithmeticException ex) {
            display.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // Addition
                    else if (eat('-')) x -= parseTerm(); // Subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // Multiplication
                    else if (eat('/')) x /= parseFactor(); // Division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // Unary plus
                if (eat('-')) return -parseFactor(); // Unary minus
                double x;
                int startPos = this.pos;
                if (eat('(')) { // Parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }
        }.parse();
    }
}
