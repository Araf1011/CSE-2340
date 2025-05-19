import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window

        JLabel label = new JLabel("Enter two numbers and select an operation");
        JTextField number1Field = new JTextField(10); // Text field for the first number
        JTextField number2Field = new JTextField(10); // Text field for the second number
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result: ");

        JRadioButton addButton = new JRadioButton("Addition", true);
        JRadioButton subtractButton = new JRadioButton("Subtraction");
        JRadioButton multiplyButton = new JRadioButton("Multiplication");
        JRadioButton divideButton = new JRadioButton("Division");

        ButtonGroup operationGroup = new ButtonGroup();
        operationGroup.add(addButton);
        operationGroup.add(subtractButton);
        operationGroup.add(multiplyButton);
        operationGroup.add(divideButton);

        calculateButton.addActionListener(e -> {
            try {

                double num1 = Double.parseDouble(number1Field.getText());
                double num2 = Double.parseDouble(number2Field.getText());
                double result = 0;
                String operation = "";

                if (addButton.isSelected()) {
                    result = num1 + num2;
                    operation = "Addition";
                } else if (subtractButton.isSelected()) {
                    result = num1 - num2;
                    operation = "Subtraction";
                } else if (multiplyButton.isSelected()) {
                    result = num1 * num2;
                    operation = "Multiplication";
                } else if (divideButton.isSelected()) {
                    if (num2 == 0) {
                        resultLabel.setText("Error: Division by zero!");
                        return;
                    }
                    result = num1 / num2;
                    operation = "Division";
                }

                resultLabel.setText(String.format("Result: %.2f (%s)", result, operation));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Please enter valid numbers.");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Use FlowLayout as in original
        panel.add(label);
        panel.add(new JLabel("Number 1:"));
        panel.add(number1Field);
        panel.add(new JLabel("Number 2:"));
        panel.add(number2Field);
        panel.add(new JLabel("Operation:"));
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(calculateButton);
        panel.add(resultLabel);

        frame.add(panel);

        frame.setVisible(true);
    }
}
