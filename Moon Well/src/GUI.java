import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI implements ActionListener {

    int count = 0;
    JLabel label;
    JLabel valueLabel;
    JLabel amountLabel;

    JFrame frame;
    JPanel panel;
    JTextField value;
    JTextField amount;

    public static boolean isNumeric(String string) {
        int intValue;

//        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
//            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
//            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public GUI() {
        frame = new JFrame();

        value = new JTextField();
        amount = new JTextField();

        JButton button = new JButton("Dunk");
        button.addActionListener(this);

        label = new JLabel("Input amount of gems and value, then click Dunk");
        amountLabel = new JLabel("Amount of Gems");
        valueLabel = new JLabel("Value of Gems");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(amountLabel);
        panel.add(amount);
        panel.add(valueLabel);
        panel.add(value);
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Moon Well");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isNumeric(value.getText()) && isNumeric(amount.getText())){
            Random flip = new Random();
            int halved = 0;
            int doubled = 0;
            double halvedVal = Double.parseDouble(value.getText()) / 2;
            double doubledVal = Double.parseDouble(value.getText()) * 2;
            int i;
            for (i = 0; i < Integer.parseInt(amount.getText()); i++) {
                int roll = flip.nextInt(2) + 1;
                if (roll == 1) {
                    halved++;
                } else {
                    doubled++;
                }
            }
            double halvedTotal = halved * halvedVal;
            double doubledTotal = doubled * doubledVal;
            label.setText("<html>" + halved + " gems halved in price. Value: " + halvedTotal + "<br/>" + doubled + " gems doubled in price. Value: " + doubledTotal + "<br/>" + "Total value: " + (halvedTotal + doubledTotal) + "</html>");
        }
        else {
            label.setText("Please input numbers in both boxes");

        }

//        System.out.println(halved + " gems halved in price. Value: " + halvedTotal);
//        System.out.println(doubled + " gems doubled in price. Value: " + doubledTotal);
//        System.out.println("Total value: " + (halvedTotal + doubledTotal));
    }
}
