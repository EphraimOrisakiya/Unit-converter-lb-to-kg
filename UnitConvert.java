import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnitConvert extends JFrame {

    public UnitConvert() {
        super("Measurement Unit Converter"); // setting frame title, size, and location
        setLocation(450, 200);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // setting the overall layoutinto border
        setLayout(new BorderLayout());

        // making the title
        JLabel title = new JLabel("Measurement Unit Converter", SwingConstants.CENTER); // making the title and
                                                                                        // centering it
        title.setFont(new Font("Tahoma", Font.BOLD, 18)); // setting the font of the title
        add(title, BorderLayout.NORTH); // setting title to the top of the frame

        // setting the center layout as a grid that will contain the components
        JPanel container = new JPanel(); // Creating a container panel where we will add the components
        container.setLayout(new GridLayout(3, 3, 2, 2)); // Set layout to 2x2 grid
        add(container, BorderLayout.CENTER); // Adding the container to the center of the frame

        JPanel poundpanel = new JPanel(); // Defining the section of pound
        JLabel enterpoundlabel = new JLabel("Pound (lb): ");
        enterpoundlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        JTextField inputpound = new JTextField(15);
        poundpanel.add(enterpoundlabel);
        poundpanel.add(inputpound);
        container.add(poundpanel);

        JPanel kgpanel = new JPanel(); // Defining the section of Kilogram
        JLabel enterkglabel = new JLabel("Kilogram (kg): ");
        enterkglabel.setFont(new Font("Tahoma", Font.PLAIN, 14)); // setting the font of the KG label
        JTextField inputkg = new JTextField(15);
        kgpanel.add(enterkglabel);
        kgpanel.add(inputkg);
        container.add(kgpanel);

        JPanel buttonpanel = new JPanel(); // Defining the section of buttons
        JButton convert = new JButton("convert");
        convert.setFont(new Font("Tahoma", Font.PLAIN, 14));
        JButton clear = new JButton("clear");
        clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonpanel.add(convert);
        buttonpanel.add(clear);
        container.add(buttonpanel);

        // Coloring the gui
        Color color1 = new Color(70, 130, 180); // steel blue
        Color color2 = new Color(185, 219, 249); // sky blue

        title.setForeground(color1);
        container.setBackground(color2);
        container.setBorder(BorderFactory.createLineBorder(color1, 7)); // setting a border color and thickness
        poundpanel.setBackground(color2);
        kgpanel.setBackground(color2);
        buttonpanel.setBackground(color2);
        enterkglabel.setForeground(Color.BLACK);
        enterpoundlabel.setForeground(Color.BLACK);
        clear.setForeground(Color.BLACK);
        convert.setForeground(Color.BLACK);

        // The components that are used here are:

        // convert - the convert button
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (inputpound.getText().isEmpty()) {
                    // inputkg - the kg textfield
                    try {
                        double kg = Double.parseDouble(inputkg.getText());
                        if (kg < 0) {
                            throw new NegativeException();
                        } else {
                            inputpound.setText(String.valueOf((Math.round((kg * 2.20462) * 1000) / 1000.00)));
                        }
                    } catch (NumberFormatException nfe) {
                        try {
                            throw new NonNumberException();
                        } catch (NonNumberException nne) {
                            JOptionPane.showMessageDialog(null, nne.getMessage());
                        }
                    } catch (NegativeException n) {
                        String message = n.getMessage();
                        JOptionPane.showMessageDialog(null, message);
                        inputpound.setText("");
                    }
                } else if (inputkg.getText().isEmpty()) {
                    // inputpound - the pound textfield
                    try {
                        double pound = Double.parseDouble(inputpound.getText());
                        if (pound < 0) {
                            throw new NegativeException();
                        } else {
                            inputkg.setText(String.valueOf((Math.round((pound * 0.453592) * 1000) / 1000.00)));
                        }
                    } catch (NumberFormatException nfe) {
                        try {
                            throw new NonNumberException();
                        } catch (NonNumberException nne) {
                            JOptionPane.showMessageDialog(null, nne.getMessage());
                        }
                    } catch (NegativeException n) {
                        String message = n.getMessage();
                        JOptionPane.showMessageDialog(null, message);
                        inputkg.setText("");
                    }
                }
            }
        });
        // clear - the clear button
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputpound.setText("");
                inputkg.setText("");
                inputpound.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        UnitConvert convert = new UnitConvert();
        convert.setVisible(true);
    }
}
