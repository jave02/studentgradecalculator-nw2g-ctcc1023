/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgradecalculator;

/**
 *
 * @author jesse
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class StudentGradeCalculator extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Input fields for grade calculation
    private JTextField nameField, englishField, mathField, filipinoField, scienceField;
    private JTextField apField, tleField, mapehField, espField;
    private JTextArea displayArea;

    // Login system storage
    private Map<String, String> users;

    public StudentGradeCalculator() {
        // Initialize user database (for simplicity)
        users = new HashMap<>();
        users.put("admin", "password"); // Default user

        // Set up the frame
        setTitle("Student Grade Calculator");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main card layout panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add login, signup, and main screen panels
        mainPanel.add(createLoginPanel(), "login");
        mainPanel.add(createSignupPanel(), "signup");
        mainPanel.add(createMainScreen(), "main");

        // Add main panel to the frame
        add(mainPanel);

        // Show login screen initially
        cardLayout.show(mainPanel, "login");
        setVisible(true);
    }

    // Create login panel
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        JTextField usernameField = new JTextField(20);
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");
        loginPanel.add(loginButton, gbc);
        gbc.gridx = 1;
        loginPanel.add(signupButton, gbc);

        // Login button action
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (users.containsKey(username) && users.get(username).equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                cardLayout.show(mainPanel, "main");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        // Signup button action
        signupButton.addActionListener(e -> cardLayout.show(mainPanel, "signup"));

        return loginPanel;
    }

    // Create signup panel
    private JPanel createSignupPanel() {
        JPanel signupPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel signupLabel = new JLabel("Sign Up");
        signupLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        signupPanel.add(signupLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        signupPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        JTextField usernameField = new JTextField(20);
        signupPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        signupPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        signupPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton createAccountButton = new JButton("Create Account");
        JButton backButton = new JButton("Back");
        signupPanel.add(createAccountButton, gbc);
        gbc.gridx = 1;
        signupPanel.add(backButton, gbc);

        // Create account button action
        createAccountButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.");
            } else if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists.");
            } else {
                users.put(username, password);
                JOptionPane.showMessageDialog(this, "Account created successfully!");
                cardLayout.show(mainPanel, "login");
            }
        });

        // Back button action
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        return signupPanel;
    }

    // Create main screen
    private JPanel createMainScreen() {
        JPanel mainScreen = new JPanel(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180));
        JLabel headerLabel = new JLabel("Student Grade Calculator");
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Student Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(30);
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("English:"), gbc);
        gbc.gridx = 1;
        englishField = new JTextField(30);
        inputPanel.add(englishField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Mathematics:"), gbc);
        gbc.gridx = 1;
        mathField = new JTextField(30);
        inputPanel.add(mathField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(createStyledLabel("Filipino:"), gbc);
        gbc.gridx = 1;
        filipinoField = new JTextField(30);
        inputPanel.add(filipinoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(createStyledLabel("Science:"), gbc);
        gbc.gridx = 1;
        scienceField = new JTextField(30);
        inputPanel.add(scienceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(createStyledLabel("Araling Panlipunan (AP):"), gbc);
        gbc.gridx = 1;
        apField = new JTextField(30);
        inputPanel.add(apField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(createStyledLabel("TLE:"), gbc);
        gbc.gridx = 1;
        tleField = new JTextField(30);
        inputPanel.add(tleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        inputPanel.add(createStyledLabel("MAPEH:"), gbc);
        gbc.gridx = 1;
        mapehField = new JTextField(30);
        inputPanel.add(mapehField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        inputPanel.add(createStyledLabel("ESP:"), gbc);
        gbc.gridx = 1;
        espField = new JTextField(30);
        inputPanel.add(espField, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton calculateButton = createStyledButton("Calculate Average");
        JButton clearButton = createStyledButton("Clear Fields");
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        // Action listeners
        calculateButton.addActionListener(e -> calculateAverage());
        clearButton.addActionListener(e -> clearFields());

        // Display area
        displayArea = new JTextArea(12, 50);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Results"));

        // Add components to the frame
        mainScreen.add(headerPanel, BorderLayout.NORTH);
        mainScreen.add(inputPanel, BorderLayout.CENTER);
        mainScreen.add(buttonPanel, BorderLayout.SOUTH);
        mainScreen.add(scrollPane, BorderLayout.EAST);

        return mainScreen;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return label;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(60, 179, 113));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private void calculateAverage() {
        try {
            String name = nameField.getText().trim();
            double english = Double.parseDouble(englishField.getText());
            double math = Double.parseDouble(mathField.getText());
            double filipino = Double.parseDouble(filipinoField.getText());
            double science = Double.parseDouble(scienceField.getText());
            double ap = Double.parseDouble(apField.getText());
            double tle = Double.parseDouble(tleField.getText());
            double mapeh = Double.parseDouble(mapehField.getText());
            double esp = Double.parseDouble(espField.getText());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the student's name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Map<String, Double> grades = new HashMap<>();
            grades.put("English", english);
            grades.put("Mathematics", math);
            grades.put("Filipino", filipino);
            grades.put("Science", science);
            grades.put("Araling Panlipunan (AP)", ap);
            grades.put("TLE", tle);
            grades.put("MAPEH", mapeh);
            grades.put("ESP", esp);

            double total = 0;
            StringBuilder results = new StringBuilder("Student Name: ").append(name).append("\nGrades:\n");
            for (Map.Entry<String, Double> entry : grades.entrySet()) {
                results.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                total += entry.getValue();
            }

            double average = total / grades.size();
            results.append("\nAverage Grade: ").append(String.format("%.2f", average));
            displayArea.setText(results.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid grades for all subjects.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        englishField.setText("");
        mathField.setText("");
        filipinoField.setText("");
        scienceField.setText("");
        apField.setText("");
        tleField.setText("");
        mapehField.setText("");
        espField.setText("");
        displayArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGradeCalculator::new);
    }
}
