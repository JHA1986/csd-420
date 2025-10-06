/* Jonah Aney 10/04/25 CSD-420 Module 10: Fans 

Follow the directions below:

    Write a program that views and updates fan information stored in database titled "databasedb", user ID titled “student1” with a password “pass”.
    The table name is to be “fans” with the fields of ID (integer, PRIMARY KEY), firstname (varchar (25)), lastname (varchar(25)), and favoriteteam (varchar(25)).
    Your interface is to have 2 buttons to display and update records.
        The display button will display the record with the provided ID in the display (ID user provides).
        The update button will update the record in the database with the changes made in the display.
    Your application is not to create or delete the table.
    To work on this using your home database, you can make the table and populate it.
    When the application is tested, the table will already be created and populated.
    Write test code that ensures all methods and the interface functions correctly.

 */

// Swing apllication with fields, ID, first name, last name, foveroite team.  It also has two buttons, Display and Update.

import javax.swing.*;
import java.awt.*;

public class FanApp extends JFrame {
    private final JTextField idField = new JTextField(8);
    private final JTextField firstNameField = new JTextField(20);
    private final JTextField lastNameField = new JTextField(20);
    private final JTextField favoriteTeamField = new JTextField(20);

    private final JButton displayButton = new JButton("Display");
    private final JButton updateButton = new JButton("Update");

    private final DatabaseHelper db = new DatabaseHelper();

    public FanApp() {
        setTitle("Fan Database Viewer / Updater");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLayout();
        pack();
        setLocationRelativeTo(null);
        attachListeners();
    }

    private void initLayout() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; p.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; p.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; p.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1; p.add(firstNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; p.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1; p.add(lastNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; p.add(new JLabel("Favorite Team:"), gbc);
        gbc.gridx = 1; p.add(favoriteTeamField, gbc);

        JPanel btnPanel = new JPanel();
        btnPanel.add(displayButton);
        btnPanel.add(updateButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
    }

    private void attachListeners() {
        displayButton.addActionListener(e -> onDisplay());
        updateButton.addActionListener(e -> onUpdate());
    }

    private void onDisplay() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter an ID to display.", "Input required", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID must be an integer.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Fan fan = db.getFanById(id);
        if (fan == null) {
            JOptionPane.showMessageDialog(this, "No record found for ID " + id, "Not found", JOptionPane.INFORMATION_MESSAGE);
            firstNameField.setText("");
            lastNameField.setText("");
            favoriteTeamField.setText("");
        } else {
            firstNameField.setText(fan.getFirstName());
            lastNameField.setText(fan.getLastName());
            favoriteTeamField.setText(fan.getFavoriteTeam());
        }
    }

    private void onUpdate() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter an ID to update.", "Input required", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID must be an integer.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fn = firstNameField.getText().trim();
        String ln = lastNameField.getText().trim();
        String team = favoriteTeamField.getText().trim();

        Fan fan = new Fan(id, fn, ln, team);
        boolean success = db.updateFan(fan);
        if (success) {
            JOptionPane.showMessageDialog(this, "Update successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Update failed (maybe ID doesn't exist).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FanApp().setVisible(true));
    }
}
