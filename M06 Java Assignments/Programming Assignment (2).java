import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateComparison {
    // JDBC URL, username, and password for connecting to the database
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    static final String USERNAME = "Jeaigar";
    static final String PASSWORD = "123456789";

    public static void main(String[] args) {
        // Create and display the dialog box for database connection
        SwingUtilities.invokeLater(() -> {
            DBConnectionDialog dialog = new DBConnectionDialog();
            dialog.setVisible(true);
        });
    }

    static class DBConnectionDialog extends JDialog {
        // Components for the dialog box
        private DBConnectionPanel connectionPanel;

        public DBConnectionDialog() {
            setTitle("Database Connection");
            setSize(300, 150);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            connectionPanel = new DBConnectionPanel();
            add(connectionPanel);

            // Event listener for the Connect button
            connectionPanel.getConnectButton().addActionListener(e -> {
                // Attempt to connect to the database
                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                    // Insert records without batch updates
                    insertRecords(connection, false);

                    // Insert records with batch updates
                    insertRecords(connection, true);

                    JOptionPane.showMessageDialog(this, "Records inserted successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage(),
                            "Connection Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        // Method to insert records into the database
        private void insertRecords(Connection connection, boolean useBatch) throws SQLException {
            String insertQuery = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                long startTime = System.currentTimeMillis();

                // Insert a thousand records
                for (int i = 0; i < 1000; i++) {
                    // Generate random numbers for each record
                    double num1 = Math.random();
                    double num2 = Math.random();
                    double num3 = Math.random();

                    // Set values for the prepared statement
                    statement.setDouble(1, num1);
                    statement.setDouble(2, num2);
                    statement.setDouble(3, num3);

                    // Execute the statement (with or without batch updates)
                    if (useBatch) {
                        statement.addBatch();
                    } else {
                        statement.executeUpdate();
                    }
                }

                // Execute batch updates if using batch mode
                if (useBatch) {
                    statement.executeBatch();
                }

                long endTime = System.currentTimeMillis();
                System.out.println("Time taken (with batch updates " + useBatch + "): " + (endTime - startTime) + " ms");
            }
        }
    }
}
