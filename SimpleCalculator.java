/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public SimpleCalculator() {
        textField = new JTextField(16);
        textField.setEditable(false);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Function buttons
        String[] functionNames = {"/", "*", "-", "+", ".", "=", "C", "DEL"};
        for (int i = 0; i < 8; i++) {
            functionButtons[i] = new JButton(functionNames[i]);
            functionButtons[i].addActionListener(this);
        }

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.add(textField);

        for (int i = 0; i < 10; i++) {
            panel.add(numberButtons[i]);
        }

        for (int i = 0; i < 8; i++) {
            panel.add(functionButtons[i]);
        }

        add(panel);
        setTitle("Simple Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        for (int i = 0; i < 8; i++) {
            if (e.getSource() == functionButtons[i]) {
                if (functionButtons[i].getText().equals("+")) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '+';
                    textField.setText("");
                } else if (functionButtons[i].getText().equals("-")) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '-';
                    textField.setText("");
                } else if (functionButtons[i].getText().equals("*")) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '*';
                    textField.setText("");
                } else if (functionButtons[i].getText().equals("/")) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '/';
                    textField.setText("");
                } else if (functionButtons[i].getText().equals(".")) {
                    textField.setText(textField.getText().concat("."));
                } else if (functionButtons[i].getText().equals("=")) {
                    num2 = Double.parseDouble(textField.getText());

                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            result = num1 / num2;
                            break;
                    }

                    textField.setText(String.valueOf(result));
                } else if (functionButtons[i].getText().equals("C")) {
                    textField.setText("");
                } else if (functionButtons[i].getText().equals("DEL")) {
                    String s = textField.getText();
                    textField.setText("");
                    for (int j = 0; j < s.length() - 1; j++) {
                        textField.setText(textField.getText() + s.charAt(j));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
